package br.com.mambo.transporte.implementacao;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.LojaEntregas;
import br.com.mambo.transporte.repository.LojaEntregasRepository;
import br.com.mambo.transporte.service.LojaEntregasService;

@Service
public class LojaEntregasServiceImpl implements LojaEntregasService {

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

}
