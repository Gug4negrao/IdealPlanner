package com.example.IdeaPlanner.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostDAO postDAO;

    public void inserirPost(Post post, String usuarioId) {
        postDAO.inserirPost(post, usuarioId);
    }

    public Post mostrarPost(String uuid){
        return postDAO.mostrarPost(uuid);
    }

    public ArrayList<Post> listarPosts(String usuarioId){
        return postDAO.listarPosts(usuarioId);
    }

    public void atualizarPost(Post post, String uuid){
        postDAO.atualizarPost(post, uuid);
    }
    
    public void deletarPost(String uuid){
        postDAO.deletarPost(uuid);
    }
}
