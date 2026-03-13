package com.example.IdeaPlanner.controller;

// src/main/java/com/example/IdeaPlanner/controller/PostController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.IdeaPlanner.model.Post;
import com.example.IdeaPlanner.model.PostService;

@Controller
public class PostController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts/new")
    public String formPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/form";
    }

    @PostMapping("/posts")
    public String salvarPost(@ModelAttribute Post post, Model model) {
        PostService ps = context.getBean(PostService.class);
        ps.inserirPost(post);
        return "posts/sucesso";
    }
}
