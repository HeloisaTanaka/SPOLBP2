package com.example.atividadeAluno.controller;

import com.example.atividadeAluno.model.Aluno;
import com.example.atividadeAluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("alunos", repository.findAll()); //"alunos" no HTML tem o valor de repository.findAll()
        model.addAttribute("novoAluno", new Aluno()); //"novoAluno" no HTML é um objeto vazio do tipo Aluno no java
        return "index"; //renderiza o index.html por causa do thymeleaf
    }

    @PostMapping("/adicionar") //Dá valores aos atributos do objeto vazio novoAluno
    public String adicionar(@ModelAttribute Aluno aluno) { //Os valores obtidos do forms formam o obj aluno, da classe Aluno
        repository.save(aluno);
        return "redirect:/";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/buscarPorProntuario/{prontuario}")
    public String buscar(Model model, @PathVariable String prontuario) {
        model.addAttribute("alunos", repository.findByProntuario(prontuario)); //Para listagem de alunos
        model.addAttribute("novoAluno", new Aluno()); //Para criar novos alunos
        return "index";
    }

    @GetMapping("/editar/{id}")
    public String pgeditar(Model model, @PathVariable Long id) {
        model.addAttribute("aluno", repository.findById(id));
        return "editar";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute Aluno aluno) {
        repository.save(aluno); //como o objeto é obtido do forms, para fazer um update com save precisamos adicionar um input "hidden" no HTML com o id.
        return "redirect:/"; //Se aquele id já existir, ocorrerá a atualização da instância, caso contrário será criada uma nova linha no bdd
    } //Se não pasar o valor do id no forms, o objeto terá id=Null, então uma nova linha será criada
}
