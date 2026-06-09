package com.example.IdeaPlanner.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.IdeaPlanner.model.Post;
import com.example.IdeaPlanner.model.PostService;
import com.example.IdeaPlanner.model.UsuarioRepository;

@Controller
public class PostController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts")
	public String listarPosts(Model model, @AuthenticationPrincipal UserDetails userDetails){
		String usuarioId = usuarioRepository.findByEmail(userDetails.getUsername()).orElseThrow().getId().toString();
		PostService cs = context.getBean(PostService.class);
		ArrayList<Post> posts = (ArrayList<Post>) cs.listarPosts(usuarioId);
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
    
    @GetMapping("/posts/{uuid}/edit")
	public String editarPosts(@PathVariable String uuid, Model model){
		PostService ps = context.getBean(PostService.class);
		Post post = ps.mostrarPost(uuid);
		model.addAttribute("post",post);
		return "posts/form";
	}

    @GetMapping("/post/sucesso")
    public String sucesso() {
        return "posts/sucesso";
    }

    @PostMapping("/post")
    public String salvarPost(@ModelAttribute Post post, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String usuarioId = usuarioRepository.findByEmail(userDetails.getUsername()).orElseThrow().getId().toString();
        PostService ps = context.getBean(PostService.class);
        ps.inserirPost(post, usuarioId);
        return "redirect:/post/sucesso";
    }
    
    @PostMapping("/post/{uuid}")
    public String salvarPost(@PathVariable String uuid, @ModelAttribute Post post, Model model) {
        PostService ps = context.getBean(PostService.class);
        ps.atualizarPost(post, uuid);
        return "redirect:/post/sucesso";
    }
    
    @PostMapping("/post/{uuid}/delete")
    public String deletarPost(@PathVariable String uuid, RedirectAttributes redirectAttributes) {
        PostService ps = context.getBean(PostService.class);
        ps.deletarPost(uuid);
        return "redirect:/posts";
    }
}
