package com.Hanami.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hanami.api.model.Publicacao;
import com.Hanami.api.services.PublicacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/publicacoes")
@Tag(name = "API - Blog Hanami")
public class PublicacaoController {

	@Autowired
	private PublicacaoService publiService;
	@Operation(summary = "Atualiza um post específico", method = "PUT")
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Atualização de uma publicação"),
			@ApiResponse(responseCode = "404", description = "Nenhuma publicação encontrada") })
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePost(@PathVariable("id") Long id, @RequestBody Publicacao postAtualizado) {
		try {
			publiService.atualizarPublicacao(id, postAtualizado);
			return ResponseEntity.ok("Publicacao atualizada com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o post");
		}
	}

	@Operation(summary = "Realiza a inserção dos dados da publicação", method = "POST")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Publicação cadastrada"),
			@ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	@PostMapping
	public ResponseEntity<Publicacao> criarPost(@Valid @RequestBody Publicacao post) {
		publiService.salvarPublicacao(post);
		return ResponseEntity.ok(post);

	}

	@Operation(summary = "Lista todas as publicações", method = "GET")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Exibição da lista de publicações"),
			@ApiResponse(responseCode = "404", description = "Nenhuma publicação encontrada") })
	@GetMapping
	public ResponseEntity<List<Publicacao>> obterTodasPublicacoes() {
		List<Publicacao> publicacoesObtidas = publiService.listarPublicacoes();
		return ResponseEntity.ok(publicacoesObtidas);
		
		
	}
@Operation(summary = "Deleta um post específico", method = "DELETE")
@DeleteMapping("/{id}")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Publicação deletada"),
		@ApiResponse(responseCode = "404", description = "Nenhuma publicação encontrada") })	
public ResponseEntity<String> deletePost(@PathVariable Long idPost) {
    try {
        boolean isDeleted = publiService.deletePublicacao(idPost);
        if (isDeleted) {
            return ResponseEntity.ok("Publicação excluída com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicação não encontrada.");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir a publicação.");
    }
}


	@Operation(summary = "Recupera uma publicação por ID", method = "GET")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Publicação encontrada"),
			@ApiResponse(responseCode = "404", description = "Publicação não encontrada") })
	@GetMapping("/{id}")
	public ResponseEntity<Publicacao> obterUmaPublicacao(@PathVariable Long id) {
		Publicacao publicacaoObtida = publiService.obterUmaPublicacao(id);
		return ResponseEntity.ok(publicacaoObtida);
	}


}
