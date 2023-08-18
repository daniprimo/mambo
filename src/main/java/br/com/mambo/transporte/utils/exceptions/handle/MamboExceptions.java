package br.com.mambo.transporte.utils.exceptions.handle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MamboExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String menssagem;
	
	public MamboExceptions(String menssagem) {
		this.menssagem = menssagem;
	}
	
	public MamboExceptions() {
	}
	

}
