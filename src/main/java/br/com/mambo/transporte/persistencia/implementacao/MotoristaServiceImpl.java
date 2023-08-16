package br.com.mambo.transporte.persistencia.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Motorista;
import br.com.mambo.transporte.persistencia.repository.MotoristaRepository;
import br.com.mambo.transporte.persistencia.service.MotoristaService;

@Service
public class MotoristaServiceImpl implements MotoristaService{

	@Autowired
	public MotoristaRepository motoristaRepository;	
	
	@Override
	public List<Motorista> obterTodosMotoristas() {
		return motoristaRepository.findAll();
	}

	@Override
	public Motorista obterPorCodigo(String codigo) {
		return motoristaRepository.findById(codigo).get();
	}

	@Override
	public Motorista criar(Motorista motorista) {
		return motoristaRepository.save(motorista);
	}

	@Override
	public Motorista obterPorNome(String nome) {
		return motoristaRepository.findByNome(nome);
	}
	

}
