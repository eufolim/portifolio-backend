package com.example.exercicio08.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClient;

import com.example.exercicio08.models.Response;

@Service
public class lista {
    static RestClient cliente = RestClient.create("https://parallelum.com.br");
    
    /* @GetMapping("/marcas")     */
    @ResponseBody
    public static String getMarcas(String marca) {
        ArrayList<Object> marcas = cliente
            .get()
            .uri("/fipe/api/v1/carros/marcas")
            .retrieve()
            .body(ArrayList.class);
        String idMarca = null;
        for (int idx = 0; idx < marcas.size(); idx++) {
            Response temp = (Response) marcas.get(idx);
            if (temp.getNome().equals(marca)){
                idMarca = temp.getCodigo();
                break;
            }
        }
        return idMarca;
    }

    /* @GetMapping("/modelos") */
    @ResponseBody
    public static String getModelos(String idMarca, String modelo) {
        ArrayList<Object> modelos = cliente
            .get()
            .uri("/fipe/api/v1/carros/marcas/"+idMarca+"/modelos")
            .retrieve()
            .body(ArrayList.class);
        String idModelos = null;
        for (int idx = 0; idx < modelos.size(); idx++) {
            Response temp = (Response) modelos.get(idx);
            if (temp.getNome().regionMatches(true, 0, modelo, 0, modelo.length())) {
                idModelos = temp.getCodigo();
                break;
            }
        }
        return idModelos;
    }
    
    /* @GetMapping("/anos") */
    @ResponseBody
    public static String getAnos(String idMarca, String idModelo, String ano) {
        ArrayList<Object> anos = cliente
            .get()
            .uri("/fipe/api/v1/carros/marcas/"+idMarca+"/modelos/"+idModelo+"/anos")
            .retrieve()
            .body(ArrayList.class);
        String idAno = null;
        for (int idx = 0; idx < anos.size(); idx++) {
            Response temp = (Response) anos.get(idx);
            if (temp.getNome().regionMatches(true, 0, ano, 0, ano.length())){
                idAno =temp.getCodigo();
                break;
            }
        }
        return idAno;
    }
}
