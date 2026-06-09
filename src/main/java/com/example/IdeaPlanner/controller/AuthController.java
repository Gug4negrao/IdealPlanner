package com.example.IdeaPlanner.controller;

import com.example.IdeaPlanner.model.Usuario;
import com.example.IdeaPlanner.model.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/cadastro")
    public String cadastroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "auth/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Usuario usuario) {
        usuarioService.cadastrar(usuario);
        return "redirect:/login?cadastrado";
    }
}
