package com.Hanami.api.exceptions;

public class PublicacaoNaoLocalizadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PublicacaoNaoLocalizadaException() {
		super("Publicação não encontrada");
	}
}
