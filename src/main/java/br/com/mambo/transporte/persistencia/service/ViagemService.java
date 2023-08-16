package br.com.mambo.transporte.persistencia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mambo.transporte.dto.ViagemDTO;
import br.com.mambo.transporte.model.Horarios;
import br.com.mambo.transporte.model.Viagem;

@Service
public interface ViagemService {
	
	public Viagem programarNovaViagem(ViagemDTO dto);
	public List<Viagem> listarViagensProgramadas();
	public Viagem buscarPorId(Long id);
	public Horarios buscarHorarioPorId(Long id);
	public List<Viagem> findByData(String data);

}
