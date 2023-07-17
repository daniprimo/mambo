package br.com.mambo.transporte.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.LojaEntregas;
import br.com.mambo.transporte.repository.LojaEntregasRepository;
import br.com.mambo.transporte.service.LojaEntregasService;

@Service
public class LojaEntregasServiceImpl implements LojaEntregasService {

	@Autowired
	private LojaEntregasRepository entregasRepository;
	
	@Override
	public LojaEntregas addNovaEntrega(LojaEntregas entrega) {
		return entregasRepository.save(entrega);
	}

	@Override
	public List<LojaEntregas> buscarTodasEntregasCadastradas() {
		return entregasRepository.findAll();
	}

	@Override
	public LojaEntregas buscarLojaPorNumeroDaEntrega(Long id) {
		return entregasRepository.findById(id).get();
	}

	@Override
	public List<LojaEntregas> salvoUmaListaDeEntregas(List<LojaEntregas> entregas) {
		return entregasRepository.saveAll(entregas);
	}

	

}
