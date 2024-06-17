package com.Hanami.api.exceptions;

public class ListaPublicacoesVaziaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ListaPublicacoesVaziaException() {
		super("Nenhuma publicação encontrada");
	}
}
