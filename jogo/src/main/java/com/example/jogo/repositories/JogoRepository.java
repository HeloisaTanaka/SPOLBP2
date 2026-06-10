package com.example.jogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jogo.models.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}

