package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.TratamentoErroLivroNaoEncontrado;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;



@ControllerAdvice
public class ResourcesExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<TratamentoErroLivroNaoEncontrado> handleLivroNaoEncontradroException
								(LivroNaoEncontradoException e, HttpServletRequest request) {
		
		TratamentoErroLivroNaoEncontrado tratamento = new TratamentoErroLivroNaoEncontrado();
		
		tratamento.setCodigo("404");
		tratamento.setMensagem("Livro não encontrado.");
		tratamento.setUrl("http:erro.socialbooks/404");
		tratamento.setTimestramp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tratamento);
		
	}

}
