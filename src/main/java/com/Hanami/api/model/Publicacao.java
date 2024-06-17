package com.Hanami.api.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Publicacao {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idPublicacao;
	
	@JsonProperty("nome_autor")
	@Column(name="nome_autor")
	@NotNull(message="O nome do autor não pode estar vazio.")	
	private String nomeAutor;
	
	@JsonProperty("titulo_publicacao")
	@NotNull(message="O título não pode estar vazio")
	@Column(name="titulo_publicacao")
	private String títuloPublicacao;
	
	@JsonProperty("conteudo")
	@NotNull(message="O conteúdo não pode estar vazio")
	@Column(name="conteudo", length = 500)
    @Size(max = 1000)
	private String conteudoPublicacao;
	
	@JsonProperty("data_criacao")
	@Column(name="data_criacao")
	private LocalDate dataCriacao;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicacao", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private List<Comentario> comentarios;

		
	public Publicacao() {
	}

	public Publicacao(Long idPublicacao, @NotNull(message = "O nome do autor não pode estar vazio.") String nomeAutor,
			@NotNull(message = "O título não pode estar vazio") String títuloPublicacao,
			@NotNull(message = "O conteúdo não pode estar vazio") String conteudoPublicacao, LocalDate dataCriacao) {
		this.idPublicacao = idPublicacao;
		this.nomeAutor = nomeAutor;
		this.títuloPublicacao = títuloPublicacao;
		this.conteudoPublicacao = conteudoPublicacao;
		this.dataCriacao = dataCriacao;
	}

	@JsonProperty("id_Publicacao")
	public Long getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(Long idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTítuloPublicacao() {
		return títuloPublicacao;
	}

	public void setTítuloPublicacao(String títuloPublicacao) {
		this.títuloPublicacao = títuloPublicacao;
	}

	public String getConteudoPublicacao() {
		return conteudoPublicacao;
	}

	public void setConteudoPublicacao(String conteudoPublicacao) {
		this.conteudoPublicacao = conteudoPublicacao;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
		
	
}