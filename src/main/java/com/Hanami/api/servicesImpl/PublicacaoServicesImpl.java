package com.Hanami.api.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hanami.api.exceptions.ListaPublicacoesVaziaException;
import com.Hanami.api.exceptions.PublicacaoNaoLocalizadaException;
import com.Hanami.api.model.Publicacao;
import com.Hanami.api.repository.PublicacaoRepository;
import com.Hanami.api.services.PublicacaoService;

@Service
public class PublicacaoServicesImpl implements PublicacaoService {

	@Autowired
	private PublicacaoRepository publiRepository;

	@Override
	@Transactional
	public Publicacao salvarPublicacao(Publicacao publicacao) {
		return publiRepository.save(publicacao);
	}

	@Override
	public Publicacao atualizarPublicacao(Long id, Publicacao publicacaoAtualizada) {
		Publicacao PostExistente = publiRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id informado não encontrado na base de dados"));
		if (PostExistente != null) {
			PostExistente.setNomeAutor(publicacaoAtualizada.getNomeAutor());
			PostExistente.setTítuloPublicacao(publicacaoAtualizada.getTítuloPublicacao());
			PostExistente.setConteudoPublicacao(publicacaoAtualizada.getConteudoPublicacao());

			return publiRepository.save(PostExistente);
		} else {
			throw new RuntimeException("Post com o ID:" + id + " não encontrado.");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Publicacao> listarPublicacoes() {
		List<Publicacao> publicacoes = publiRepository.findAll();
		if (publicacoes.isEmpty()) {
			throw new ListaPublicacoesVaziaException();
		}
		return publicacoes;
	}
	 public boolean deletePublicacao(Long idPost) {
	        if (publiRepository.existsById(idPost)) {
	            publiRepository.deleteById(idPost);
	            return true;
	        } else {
	            return false;
	        }
	 }
	@Override
	@Transactional(readOnly = true)
	public Publicacao obterUmaPublicacao(Long idPublicacao) {
		return publiRepository.findById(idPublicacao).orElseThrow(() -> new PublicacaoNaoLocalizadaException());
	}
}
