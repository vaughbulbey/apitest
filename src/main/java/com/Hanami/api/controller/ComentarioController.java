package com.Hanami.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hanami.api.model.Comentario;
import com.Hanami.api.services.ComentarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/comentarios")
@Tag(name = "API - Blog Hanami")
public class ComentarioController {

	@Autowired
	private ComentarioService cService;
	
	@Operation(summary = "Insere comentário na publicação", method = "POST")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Comentário cadastrado"),
			@ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	@PostMapping
	public ResponseEntity<Comentario> criarComentario(@Valid @RequestBody Comentario comentario) {
		cService.criarComentario(comentario);
		return ResponseEntity.ok(comentario);

	}
}