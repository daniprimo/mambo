package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.model.Viagem;

public interface ViagemService {

	public Viagem addNovaViagem (Viagem viagem);
	
	public List<Viagem> listaViagens();
	
}
