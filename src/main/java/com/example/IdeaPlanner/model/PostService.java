package com.example.IdeaPlanner.model;

// src/main/java/com/example/IdeaPlanner/model/PostService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostDAO postDAO;

    public void inserirPost(Post post) {
        postDAO.inserirPost(post);
    }
}
