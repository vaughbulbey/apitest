package com.Hanami.api.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class ValidationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException ex) {
		Map<String, String> errors = new HashMap<>();

		Throwable cause = ex.getCause();
		if (cause instanceof InvalidFormatException) {
			InvalidFormatException ife = (InvalidFormatException) cause;
			String fieldName = ife.getPath().stream().map(ref -> ref.getFieldName()).reduce("",
					(partialString, element) -> partialString + "." + element);
			fieldName = fieldName.startsWith(".") ? fieldName.substring(1) : fieldName;
			errors.put(fieldName, "Formato de entrada de dados inválido: " + ife.getValue());
		} else {
			errors.put("Erro", "Não foi possível cadastrar no banco de dados");
		}

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("Erro:", ex.getMessage());

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ListaPublicacoesVaziaException.class)
	public ResponseEntity<Map<String, String>> handleListaPublicacaoVaziaException(ListaPublicacoesVaziaException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("Erro", ex.getMessage());
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PublicacaoNaoLocalizadaException.class)
	public ResponseEntity<Map<String, String>> handlePublicacaoNaoLocalizadaException(
			PublicacaoNaoLocalizadaException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("Erro", ex.getMessage());
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

}