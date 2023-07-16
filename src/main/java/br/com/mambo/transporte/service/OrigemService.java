package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.model.Origem;

public interface OrigemService {
	public Origem addNovaOrigem(Origem origem);

	public List<Origem> buscarTodasOrigensCadastradas();

	public Origem buscarLojaPorNomeDaOrigem(String nome);

}
