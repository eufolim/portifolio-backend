package com.example;

import java.util.HashMap;
import java.util.Map;

public class Filme {
    Map<String, Boolean> assentos = new HashMap<>();
    String nome;
    float preco;
    int idadeMinima;

    public Filme(String nome, float preco, int idadeMinima){
        this.nome = nome;
        this.preco = preco;
        this.idadeMinima = idadeMinima;
        String[] n = {"A","B","C","D","E","F"};
        for (String i : n) {
            for (int x = 1; x <= 5; x++){
                String y = i + x;
                assentos.put(y,false);
            }
        }
    }
    public void mudaAssento(String assento){
        assentos.put(assento, Boolean.TRUE);
    }
}
