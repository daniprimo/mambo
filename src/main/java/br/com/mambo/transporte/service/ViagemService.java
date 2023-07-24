package br.com.mambo.transporte.service;

import java.util.List;

import br.com.mambo.transporte.dto.ViagemDTO;
import br.com.mambo.transporte.model.Horarios;
import br.com.mambo.transporte.model.Viagem;

public interface ViagemService {
	
	public Viagem programarNovaViagem(ViagemDTO dto);
	public List<Viagem> listarViagensProgramadas();
	public Viagem buscarPorId(Long id);
	public Horarios buscarHorarioPorId(Long id);

}
