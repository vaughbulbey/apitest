package com.Hanami.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hanami.api.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
