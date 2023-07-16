package br.com.mambo.transporte.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Loja;
import br.com.mambo.transporte.repository.LojaRepository;
import br.com.mambo.transporte.service.LojaService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LojaServiceImpl implements LojaService {

	@Autowired
	private LojaRepository lojaRepository;
	
	@Override
	public Loja addNovaLoja(Loja loja) {
		return lojaRepository.save(loja);
	}

	@Override
	public List<Loja> buscarTodasLojasCadastradas() {
		return lojaRepository.findAll();
	}

	@Override
	public Loja buscarLojaPorNome(String nome) {
	return lojaRepository.findById(nome).orElseThrow(() -> new EntityNotFoundException("Loja "+nome+" inexistente."));
	}

}
