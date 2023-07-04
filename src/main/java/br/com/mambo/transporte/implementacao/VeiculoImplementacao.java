package br.com.mambo.transporte.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Veiculo;
import br.com.mambo.transporte.repository.VeiculoRepository;
import br.com.mambo.transporte.service.VeiculoService;

@Service
public class VeiculoImplementacao implements VeiculoService{

	@Autowired
	public VeiculoRepository veiculoRepository;
	
	@Override
	public Veiculo addVeiculo(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public List<Veiculo> listaDeTodosVeiculo() {
		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo pesquisarPorPlaca(String placa) {
		return veiculoRepository.findByPlaca(placa);
	}

}
