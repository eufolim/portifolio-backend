package com.example.exercicio07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Exercicio07Application {
	public static void main(String[] args) {
		SpringApplication.run(Exercicio07Application.class, args);
	}
	@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
	@GetMapping("/recomendar")
    public String recomendacao(@RequestParam(value = "genero") String genero, @RequestParam(value = "ambiente") String ambientacao){
		int nGenero;
		int nAmbientacao;
		switch (genero) {
			case "comedia" -> nGenero = 2;
			case "drama" -> nGenero = 4;
			default -> throw new AssertionError();
		}
		switch (ambientacao) {
			case "futurista" -> nAmbientacao = 1;
			case "medieval" -> nAmbientacao = 2;
			default -> throw new AssertionError();
		}
		String[] listaFilmes = {"Homens de Preto","Shrek","Arrivel","Gladiador"};
		String filmeRecomendacao = listaFilmes[nAmbientacao + nGenero - 3];
		return filmeRecomendacao;
	}
}

