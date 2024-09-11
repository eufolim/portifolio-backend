package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cinema {
    Map<String,Filme> filmesDisponiveis = new HashMap<>();
    List<Ingresso> ingressosVendidos = new ArrayList<>();

    public void addFilme(String nome, float preco, int idadeMinima){
        Filme filme = new Filme(nome, preco, idadeMinima);
        filmesDisponiveis.put(nome, filme);
    };

    public void ingressos(Ingresso ingresso){
        ingressosVendidos.add(ingresso);
    };

    /* public Filme disponivel(String nomeFilme) {
        for (Filme filmesDisponivel : this.filmesDisponiveis) {
            if (filmesDisponivel.nome == null ? nomeFilme == null : filmesDisponivel.nome.equals(nomeFilme)){
                Filme tempFilme = filmesDisponivel;
                return tempFilme;
            }
        }
    } */
}
