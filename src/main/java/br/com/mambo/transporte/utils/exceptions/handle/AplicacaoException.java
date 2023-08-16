package br.com.mambo.transporte.utils.exceptions.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import br.com.mambo.transporte.utils.exceptions.dto.DefaultError;

@ControllerAdvice
public class AplicacaoException extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(AplicacaoException.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception exc) {
		DefaultError err = new DefaultError(HttpStatus.BAD_GATEWAY.value(), "Erro interno contatar o suporte");
		LOG.error("Erro genérico");
		return new ResponseEntity(err, HttpStatus.BAD_GATEWAY);
	}

}
