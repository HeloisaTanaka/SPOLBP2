package com.example.jogo.controllers;

import java.util.List;

import com.example.jogo.models.Jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jogo.dtos.JogoRequestDTO;
import com.example.jogo.dtos.JogoResponseDTO;
import com.example.jogo.services.JogoService;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping
    public ResponseEntity<List<JogoResponseDTO>> getAll() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<JogoResponseDTO> create(@RequestBody JogoRequestDTO data) {
        JogoResponseDTO response = service.salvar(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> atualizar(@PathVariable Long id, @RequestBody JogoRequestDTO dto){
        JogoResponseDTO response = service.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return  ResponseEntity.noContent().build();
    }
}

