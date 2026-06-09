package com.example.IdeaPlanner.controller;

import com.example.IdeaPlanner.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UserAdvice {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @ModelAttribute("nomeUsuario")
    public String nomeUsuario(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) return null;
        return usuarioRepository.findByEmail(userDetails.getUsername())
                .map(u -> u.getNome())
                .orElse(null);
    }
}
