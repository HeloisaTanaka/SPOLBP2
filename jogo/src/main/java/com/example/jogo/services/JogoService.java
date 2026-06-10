package com.example.jogo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jogo.dtos.JogoRequestDTO;
import com.example.jogo.dtos.JogoResponseDTO;
import com.example.jogo.models.Jogo;
import com.example.jogo.repositories.JogoRepository;

import javax.management.RuntimeErrorException;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repository;

    public List<JogoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(p -> new JogoResponseDTO(p.getId(), p.getTitulo(), p.getPlataforma()))
                .toList();
    }

    public JogoResponseDTO salvar(JogoRequestDTO data) {
        Jogo novoJogo = new Jogo(null, data.titulo(), data.plataforma());
        Jogo salvo = repository.save(novoJogo);
        return new JogoResponseDTO(salvo.getId(), salvo.getTitulo(), salvo.getPlataforma());
    }

    public JogoResponseDTO atualizar(Long id, JogoRequestDTO dto){
        Jogo jogoExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Jogo não encontrado"));

        jogoExistente.setTitulo(dto.titulo());
        jogoExistente.setPlataforma(dto.plataforma());

        Jogo jogoAtualizado = repository.save(jogoExistente);
        return new JogoResponseDTO(
                jogoAtualizado.getId(),
                jogoAtualizado.getTitulo(),
                jogoAtualizado.getPlataforma()
        );
    }

    public void deletar(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Jogo não encontrado");
        }

        repository.deleteById(id);
    }

}

