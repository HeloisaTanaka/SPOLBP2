package com.example.react_e_spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.react_e_spring.model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin(origins = "*")

public class AlunoController {
    private List<Aluno> alunos = new ArrayList<>();

    public AlunoController() {
        alunos.add(new Aluno(1L, "Ana Silva", "Técnico em Informática"));
        alunos.add(new Aluno(2L, "Carlos Souza", "Engenharia Elétrica"));
        alunos.add(new Aluno(3L, "Maria Fernanda", "Análise e Desenvolvimento de Sistemas"));
    }

    @GetMapping
    public List<Aluno> listarTodos() {return alunos;}
}
