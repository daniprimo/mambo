package br.com.mambo.transporte.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Origem;
import br.com.mambo.transporte.repository.OrigemRepository;
import br.com.mambo.transporte.service.OrigemService;

@Service
public class OrigemImplementacao implements OrigemService {

	@Autowired
	public OrigemRepository origemRepository;
	
	@Override
	public Origem addOrigem(Origem origem) {
		return origemRepository.save(origem);
	}

	@Override
	public List<Origem> listaDeOrigens() {
		return origemRepository.findAll();
	}

	@Override
	public Origem pesquisarOrigemPelaNome(String nome) {
		return origemRepository.findByNome(nome);
	}

}
