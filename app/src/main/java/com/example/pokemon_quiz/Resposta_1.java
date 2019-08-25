package com.example.pokemon_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resposta_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta_1);
        getSupportActionBar().hide(); // METODO DE OCULTAR A ACTION BAR

        ImageView imgResposta = findViewById(R.id.imgResposta);
        TextView resposta =findViewById(R.id.resposta);
        Button  btnJogarNovamente = (Button) findViewById(R.id.btnJogarNovamente);

        Intent intent = getIntent();//RECUPERAR O INTENT QUE CHEGOU NESSA ACT, PRA CONSEGUIR
        int pontos = intent.getIntExtra("pontos",0); // O EXTRA "ACERTOU" QUE FOI PASSADO NA ACT DE QUIZ
        if(intent.hasExtra("acertou")){
            btnJogarNovamente.setVisibility(View.INVISIBLE);
            boolean acertou = intent.getBooleanExtra("acertou",false);
            if (acertou)
            {// VERIFICAR SE A PESSOA ESCOLHEU A RESPOSTA CERTA PRA DEFINIR O TEXTO E IMAGEM
                imgResposta.setImageResource(R.drawable.acertoumizeravi);
                resposta.setText("ACERTOU MIZERAVI PONTOS !!! + " + pontos);

            }
            else
            {
                imgResposta.setImageResource(R.drawable.repostaerrada);
                resposta.setText("ERRÔUUUUUUU  PONTOS    " + pontos );

            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(2000);  // FIZ UM TRY CATCH PARA FINALIZAÇÃO
                        // DA ACTIVITY DEMORAR 2 SGUNDOS
                    } catch (InterruptedException intexp){
                        intexp.printStackTrace();
                    }
                    finish();
                }
            });
            thread.start();

        } else {
            btnJogarNovamente.setVisibility(View.VISIBLE);
            resposta.setText("Fez     "   + pontos +     "pontos");
            if (pontos >= 3)
            imgResposta.setImageResource(R.drawable.gaisensei);

            else
            imgResposta.setImageResource(R.drawable.fufu);

        }







    }
    public void btnJogarNovamente(View view){
        Intent intent = new Intent(this,QuizActivity.class);
        startActivity(intent);
        finish();
    }

}
