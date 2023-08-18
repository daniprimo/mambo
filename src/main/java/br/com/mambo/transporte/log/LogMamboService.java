package br.com.mambo.transporte.log;

import java.beans.JavaBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JavaBean
public class LogMamboService {
	
	private final Logger log ;
	
	private String local;

	public LogMamboService(String local, Class<?> classe) {
		this.local = local;
		this.log = LoggerFactory.getLogger(classe);
	}
	
	public void info(String menssagem) {
		log.info(local + " - " +menssagem);
	}
	

	public void error(String menssagem) {
		log.error(local + " - " +menssagem);		
	}
	
	public String getLocal() {
		return local;
	}
	
	
	
}
