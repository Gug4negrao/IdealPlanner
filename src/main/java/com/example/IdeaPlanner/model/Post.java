package com.example.IdeaPlanner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// src/main/java/com/example/IdeaPlanner/model/Post.java

public class Post {

    private String id;
    private String titulo;
    private String ideia;
    private String plataforma;
    private String status;
    private String dataPrevista;

    // Construtor vazio — usado pelo formulário
    public Post() {}

    // Construtor para INSERT
    public Post(String titulo, String ideia, String plataforma, String status, String dataPrevista) {
        this.titulo = titulo;
        this.ideia = ideia;
        this.plataforma = plataforma;
        this.status = status;
        this.dataPrevista = dataPrevista;
    }

    // Construtor para SELECT
    public Post(String id, String titulo, String ideia, String plataforma, String status, String dataPrevista) {
        this.id = id;
        this.titulo = titulo;
        this.ideia = ideia;
        this.plataforma = plataforma;
        this.status = status;
        this.dataPrevista = dataPrevista;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIdeia() { return ideia; }
    public void setIdeia(String ideia) { this.ideia = ideia; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDataPrevista() { return dataPrevista; }
    public void setDataPrevista(String dataPrevista) { this.dataPrevista = dataPrevista; }

    public static Post converter(Map<String,Object> registro){
        UUID id = (UUID) registro.get("id");
        String titulo = (String) registro.get("titulo");
        String ideia = (String) registro.get("ideia");
        String plataforma = (String) registro.get("plataforma");
        String status = (String) registro.get("status");
        String dataPrevista = (String) registro.get("data_prevista");
        return new Post(id.toString(),titulo, ideia, plataforma, status, dataPrevista);
    }

    public static ArrayList<Post> converterTodos(List<Map<String,Object>> registros){
        ArrayList<Post> aux = new ArrayList<>();
        for(Map<String,Object> registro : registros){
            aux.add(converter(registro));
        }
        return aux;
    }
}
