package com.example.pokemon_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {



    RadioGroup rgRespostas;
    int pontos;
    ImageView imgPergunta;
    ImageView question2;
    RadioButton rbResposta1, rbResposta2, rbResposta3,rbResposta4;
    int respostaCerta = R.id.rbReposta1;


    List<Questao> questoes = new ArrayList<Questao>(){

        {
            add(new Questao(R.drawable.entei_img,R.id.rbResposta4,"Raikou","Suicune","Ho-ho","Entei"));
            add(new Questao(R.drawable.moltres_img,R.id.rbReposta2,"Zapdos","Moltres","Articuno","Lugia"));
            add(new Questao(R.drawable.clefairy_img,R.id.rbResposta3,"Pikachu","Jiggypluff","Clefairy","Totodile"));
            add(new Questao(R.drawable.metapod_img,R.id.rbReposta1,"Metapod","Kakuna","Beedrill","Margikap"));
            add(new Questao(R.drawable.charizard_img,R.id.rbResposta4,"Mew","Arcanaine","Ditto","Charizard"));

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        question2 = findViewById(R.id.imgPergunta);
        rgRespostas = findViewById(R.id.rgRespostas);
        rbResposta1 = (RadioButton)findViewById(R.id.rbReposta1);
        rbResposta2 = (RadioButton)findViewById(R.id.rbReposta2);
        rbResposta3 = (RadioButton)findViewById(R.id.rbResposta3);
        rbResposta4 = (RadioButton)findViewById(R.id.rbResposta4);
        carregarQuestao();
    }
    protected void onRestart(){
        super.onRestart();

        carregarQuestao();
    }


    public void btnResponder (View view)
    {
        RadioGroup rgRespostas = findViewById(R.id.rgRespostas);
        RadioButton rb = (RadioButton)findViewById(rgRespostas.getCheckedRadioButtonId());
        Intent intent = new Intent(this,Resposta_1.class);
        if(rgRespostas.getCheckedRadioButtonId() == respostaCerta) {
            intent.putExtra("acertou", true);
            pontos++;
        }
        else intent.putExtra("acertou", false);
        intent.putExtra("pontos", pontos);
        startActivity(intent);
        rb.setChecked(false);

    }

    private void carregarQuestao(){

        if(questoes.size() > 0){
            Questao q = questoes.remove(0);
            List<String> respostas = q.getRespostas();
            question2.setImageResource(q.getImgPergunta());
            rbResposta1.setText(respostas.get(0));
            rbResposta2.setText(respostas.get(1));
            rbResposta3.setText(respostas.get(2));
            rbResposta4.setText(respostas.get(3));
            respostaCerta = q.getRespostaCerta();
            rgRespostas.setSelected(false);

        }
        else{// AQUI ACABA AS QUESTÕES
            Intent intent = new Intent(this,Resposta_1.class);
            intent.putExtra("pontos",pontos);
            startActivity(intent);
            finish();
        }

    }
}






