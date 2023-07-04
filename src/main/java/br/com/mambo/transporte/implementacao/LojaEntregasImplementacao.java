package br.com.mambo.transporte.implementacao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.LojaEntregas;
import br.com.mambo.transporte.repository.LojasEntregasRepository;
import br.com.mambo.transporte.service.LojasEntregasService;

@Service
public class LojaEntregasImplementacao implements LojasEntregasService {

	@Autowired
	public LojasEntregasRepository entregasRepository; 
	
	@Override
	public LojaEntregas addLojaEntregas(LojaEntregas lojaEntregas) {
		return entregasRepository.save(lojaEntregas);
	}

	@Override
	public List<LojaEntregas> buscarTodasEntregas() {
		return entregasRepository.findAll();
	}

	@Override
	public List<LojaEntregas> listarEntregasPorData(LocalDate data) {
		return entregasRepository.findByData(data);
	}

	@Override
	public LojaEntregas buscarEntregasPorCodigo(String codigo) {
		return entregasRepository.findById(codigo).get();
	}

}
