package com.example.IdeaPlanner.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/posts")
	public String listarPosts(Model model){
		PostService cs = context.getBean(PostService.class);
		ArrayList<Post> posts = (ArrayList<Post>) cs.listarPosts();
		model.addAttribute("posts",posts);
		return "posts/list";
	}

    @GetMapping("/posts/new")
    public String formPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/form";
    }

    @GetMapping("/posts/{uuid}")
	public String verPosts(@PathVariable String uuid, Model model){
		PostService ps = context.getBean(PostService.class);
		Post post = ps.mostrarPost(uuid);
		model.addAttribute("post",post);
		return "posts/detalhe";
	}

    @PostMapping("/post")
    public String salvarPost(@ModelAttribute Post post, Model model) {
        PostService ps = context.getBean(PostService.class);
        ps.inserirPost(post);
        return "posts/sucesso";
    }
}
