package com.Hanami.api.services;

import java.util.List;

import com.Hanami.api.model.Publicacao;

public interface PublicacaoService {

	Publicacao salvarPublicacao(Publicacao post);

	Publicacao atualizarPublicacao(Long id, Publicacao publicacaoAtualizada);

	List<Publicacao> listarPublicacoes();
	
	boolean deletePublicacao(Long idPost);


	Publicacao obterUmaPublicacao(Long idPublicacao);

 
}