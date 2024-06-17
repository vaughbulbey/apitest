package com.Hanami.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id_comentario")
	private Long idComentario;
	
	@JsonProperty("autor_comentario")
	@NotEmpty(message = "O nome do autor do comentário não pode estar vazio!")
	@Column(name = "autor_comentario", length = 50)
	private String autorComentario;
	
	@JsonProperty("conteudo_comentario")
	@NotEmpty(message = "O comentário não pode estar vazio!")
	@Column(name = "comentario", length = 200)
	private String conteudo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_publicacao")
	@JsonBackReference
	private Publicacao publicacao;
	
	public Comentario() {

	}


	public Comentario(Long idComentario,
			@NotEmpty(message = "O nome do autor do comentário não pode estar vazio!") String autorComentario,
			@NotEmpty(message = "O comentário não pode estar vazio!") String conteudo) {
		this.idComentario = idComentario;
		this.autorComentario = autorComentario;
		this.conteudo = conteudo;
	}



	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public String getAutorComentario() {
		return autorComentario;
	}

	public void setAutorComentario(String autorComentario) {
		this.autorComentario = autorComentario;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public Publicacao getPublicacao() {
		return publicacao;
	}


	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}
	
	
}	