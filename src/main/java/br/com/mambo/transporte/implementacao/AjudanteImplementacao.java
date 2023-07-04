package br.com.mambo.transporte.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Ajudante;
import br.com.mambo.transporte.repository.AjudanteRepository;
import br.com.mambo.transporte.service.AjudanteService;

@Service
public class AjudanteImplementacao implements AjudanteService {

	@Autowired
	public AjudanteRepository ajudanteRepository;
	
	@Override
	public Ajudante addAjudante(Ajudante ajudante) {
		return ajudanteRepository.save(ajudante);
	}

	@Override
	public List<Ajudante> buscarTodosOsAjudantes() {
		return ajudanteRepository.findAll();
	}

	@Override
	public Ajudante pesquisarAjudantePorNome(String nome) {
		return ajudanteRepository.findByNome(nome);
	}

}
