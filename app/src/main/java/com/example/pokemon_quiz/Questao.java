package com.example.pokemon_quiz;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Questao {


    private int imgPergunta;
    private List<String>respostas = new ArrayList<>();
    private  int respostaCerta;

    public Questao(int imgPergunta, int respostaCerta, String... respostas ){
        this.imgPergunta = imgPergunta;
        this.respostas.add(respostas[0]);
        this.respostas.add(respostas[1]);
        this.respostas.add(respostas[2]);
        this.respostas.add(respostas[3]);
        this.respostaCerta  = respostaCerta;
    }

   public List<String> getRespostas(){return this.respostas;}
   public int getImgPergunta(){return this.imgPergunta;}
   public int getRespostaCerta(){return this.respostaCerta;}
}
