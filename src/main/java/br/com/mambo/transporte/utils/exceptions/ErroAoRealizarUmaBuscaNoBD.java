package br.com.mambo.transporte.utils.exceptions;

import br.com.mambo.transporte.utils.exceptions.handle.MamboExceptions;

public class ErroAoRealizarUmaBuscaNoBD extends MamboExceptions {

	private static final long serialVersionUID = 1L;

	public ErroAoRealizarUmaBuscaNoBD(String menssagem) {
		super(menssagem);
	}


}
