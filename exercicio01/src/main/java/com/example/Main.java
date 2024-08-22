package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        
        String[] listaFilmes = {"Homens de Preto","Shrek","Arrivel","Gladiador"};

        try (Scanner leitor = new Scanner(System.in)) {
            System.out.println("Que ambientação você prefere");
            System.out.println("1 - sci fi");
            System.out.println("2 - medieval");
            Integer opcaoAmbientacao = leitor.nextInt();
            
            System.out.println("Que genero você prefere");
            System.out.println("1 - comedia");
            System.out.println("2 - drama");
            Integer opcaoGenero = leitor.nextInt() * 2;
            
            String filmeRecomendacao = listaFilmes[opcaoAmbientacao + opcaoGenero - 3];
            
            System.out.println(filmeRecomendacao);
            
            leitor.close();
        }
    }
}