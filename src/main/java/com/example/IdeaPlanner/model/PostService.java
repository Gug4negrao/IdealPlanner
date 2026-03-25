package com.example.IdeaPlanner.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostDAO postDAO;

    public void inserirPost(Post post) {
        postDAO.inserirPost(post);
    }

     public Post mostrarPost(String uuid){
        return postDAO.mostrarPost(uuid);
    }

    public ArrayList<Post> listarPosts(){
        return postDAO.listarPosts();
    }
}
