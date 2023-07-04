package br.com.mambo.transporte.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Loja;
import br.com.mambo.transporte.repository.LojaRepository;
import br.com.mambo.transporte.service.LojaService;

@Service
public class LojaImplementacao implements LojaService {

	@Autowired
	public LojaRepository lojaRepository;

	@Override
	public Loja addLoja(Loja loja) {
		return lojaRepository.save(loja);
	}

	@Override
	public List<Loja> listarTodasLojas() {
		return lojaRepository.findAll();
	}

	@Override
	public Loja buscarLojaPeloNome(String nome) {
		return lojaRepository.findByNomeLoja(nome);
	}

}
