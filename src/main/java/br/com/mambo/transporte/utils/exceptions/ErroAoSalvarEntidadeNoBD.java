package br.com.mambo.transporte.utils.exceptions;

import br.com.mambo.transporte.utils.exceptions.handle.MamboExceptions;

public class ErroAoSalvarEntidadeNoBD extends MamboExceptions {

	private static final long serialVersionUID = 1L;

	public ErroAoSalvarEntidadeNoBD(String menssagem) {
		super(menssagem);
	}


}
