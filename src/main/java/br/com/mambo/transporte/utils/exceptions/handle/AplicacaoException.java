package br.com.mambo.transporte.utils.exceptions.handle;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import br.com.mambo.transporte.utils.exceptions.ErroAoRealizarUmaBuscaNoBD;
import br.com.mambo.transporte.utils.exceptions.ErroAoSalvarEntidadeNoBD;
import br.com.mambo.transporte.utils.exceptions.ErroQuandoORetornoForNull;
import br.com.mambo.transporte.utils.exceptions.dto.DefaultError;
import br.com.mambo.transporte.utils.exceptions.dto.StandarError;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AplicacaoException extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(AplicacaoException.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception exc) {
		DefaultError err = new DefaultError(HttpStatus.BAD_GATEWAY.value(), "Erro interno contatar o suporte");
		LOG.error("Erro genérico");
		return new ResponseEntity(err, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(ErroAoRealizarUmaBuscaNoBD.class)
	public ResponseEntity<StandarError> naoEncontradoNoBancoDeDados(ErroAoRealizarUmaBuscaNoBD e, HttpServletRequest request){
		StandarError err = new StandarError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Erro ao realizar uma busca no banco de dados.");
		err.setMessage(e.getMenssagem());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(ErroAoSalvarEntidadeNoBD.class)
	public ResponseEntity<StandarError> erroAoSalvarEntidadeNoBancoDeDados
	(ErroAoSalvarEntidadeNoBD e, HttpServletRequest request){
		StandarError err = new StandarError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Erro salvar algo no Banco de Dados");
		err.setMessage(e.getMenssagem());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(ErroQuandoORetornoForNull.class)
	public ResponseEntity<StandarError> dsadf(ErroQuandoORetornoForNull e, HttpServletRequest request){
		StandarError err = new StandarError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Erro quando os retornos for null");
		err.setMessage(e.getMenssagem());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
