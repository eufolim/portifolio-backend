package com.example;

public class Ingresso {
    Cliente cliente;
    Filme filme;
    String assento;

    public Ingresso(Cliente cliente, Filme filme, String assento) {
        this.cliente = cliente;
        this.filme = filme;
        this.assento = assento;
    }

    public String retornaIngresso(){
        return String.format("Ingresso vendido com sucesso! %1s - %2s - %3s - %3.2f", cliente.nome, filme.nome, assento, filme.preco);
    }
}
