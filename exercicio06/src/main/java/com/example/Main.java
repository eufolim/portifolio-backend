package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cinema arco = new Cinema();
        arco.addFilme("Atlas", 26.00f, 14);
        arco.addFilme("Sherk", 26.00f, 0);
        arco.addFilme("Gladiador", 26.00f, 16);
        arco.addFilme("Homens de Preto", 26.00f, 12);
        arco.addFilme("Arrival", 26.00f, 12);
        try (Scanner leitor = new Scanner(System.in)){
            while (true){
                System.out.println("Que filme você deseja assistir?");
                String nomeFilme = leitor.next();
                /* boolean b = false;
                Filme tempFilme = null;
                for (Filme filmesDisponivel : arco.filmesDisponiveis) {
                    if (filmesDisponivel.nome == null ? nomeFilme == null : filmesDisponivel.nome.equals(nomeFilme)){
                        tempFilme = filmesDisponivel;
                        b = true;
                        break;
                    }
                }
                if (b == false) {
                    System.out.println("Filme indisponivel");
                    continue;
                } */
                Filme tempFilme = arco.filmesDisponiveis.getOrDefault(nomeFilme, null);
                if (tempFilme == null){
                    continue;
                }
                System.out.println("Qual assento você deseja?");
                String assento = leitor.next();
                Boolean tempAssento = tempFilme.assentos.getOrDefault(assento,true);
                if (tempAssento == null || tempAssento == true){
                    System.out.println("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
                    continue;
                }
                tempFilme.mudaAssento(assento);
                System.out.println("Qual o seu nome?");
                String nome = leitor.next();
                System.out.println("Qual a sua idade?");
                int idade = leitor.nextInt();
                Cliente tempCliente = new Cliente(nome, idade);
                if (tempCliente.idade < tempFilme.idadeMinima) {
                    System.out.println("O ingresso não pode ser vendido pois sua idade não permite!");
                    continue;
                }
                Ingresso ingresso = new Ingresso(tempCliente,tempFilme,assento);
                /* String m = "Ingresso vendido com sucesso! %1s - %2s - %3s";
                m = String.format(m, nome, nomeFilme, assento); */
                System.out.println(ingresso.retornaIngresso());
            }
        }
    }
}