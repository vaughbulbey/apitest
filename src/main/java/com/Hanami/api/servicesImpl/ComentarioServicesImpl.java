package com.Hanami.api.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hanami.api.model.Comentario;
import com.Hanami.api.repository.ComentarioRepository;
import com.Hanami.api.services.ComentarioService;

@Service
public class ComentarioServicesImpl implements ComentarioService {

	@Autowired
	private ComentarioRepository cRepository;

	@Override
	public Comentario criarComentario(Comentario comentario) {
		return cRepository.save(comentario); 		
	}
	
	
	
}
