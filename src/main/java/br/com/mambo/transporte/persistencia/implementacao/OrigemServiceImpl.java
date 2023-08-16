package br.com.mambo.transporte.persistencia.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Origem;
import br.com.mambo.transporte.persistencia.repository.OrigemRepository;
import br.com.mambo.transporte.persistencia.service.OrigemService;

@Service
public class OrigemServiceImpl implements OrigemService {
	
	@Autowired
	private OrigemRepository origemRepository;

	@Override
	public Origem addNovaOrigem(Origem origem) {
		return origemRepository.save(origem);
	}

	@Override
	public List<Origem> buscarTodasOrigensCadastradas() {
		return origemRepository.findAll();
	}

	@Override
	public Origem buscarLojaPorNomeDaOrigem(String nome) {
		return origemRepository.findById(nome).get();
	}

}
