package br.com.mambo.transporte.utils.exceptions;

import br.com.mambo.transporte.utils.exceptions.handle.MamboExceptions;

public class NaoEncontradoNoBancoDeDados extends MamboExceptions {

	private static final long serialVersionUID = 1L;

	public NaoEncontradoNoBancoDeDados(String menssagem) {
		super(menssagem);
	}


}
