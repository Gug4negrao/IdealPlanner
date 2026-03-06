package com.example.IdeaPlanner.controller;

// ===================================================
//  IdeaPlanner – PostController.java
//  src/main/java/com/ideaplanner/controller/PostController.java
// ===================================================

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    // ── Landing page ──────────────────────────────
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // ── Listar posts ──────────────────────────────
    @GetMapping("/posts")
    public String list() {
        return "posts/list";
    }

    // ── Formulário de criação ─────────────────────
    @GetMapping("/posts/new")
    public String newForm() {
        return "posts/form";
    }

    // ── Salvar novo post ──────────────────────────
    @PostMapping("/posts")
    public String save() {
        return "redirect:/posts";
    }

    // ── Formulário de edição ──────────────────────
    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable Long id) {
        return "posts/form";
    }

    // ── Salvar edição ─────────────────────────────
    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable Long id) {
        return "redirect:/posts";
    }

    // ── Excluir post ──────────────────────────────
    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable Long id) {
        return "redirect:/posts";
    }
}
