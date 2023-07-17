package br.com.mambo.transporte.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Veiculo;
import br.com.mambo.transporte.repository.VeiculoRepository;
import br.com.mambo.transporte.service.VeiculoService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@Override
	public List<Veiculo> todosOsVeiculos() {
		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo obterPorPlaca(String placa) {
		return retornaPlacaSeExistente(placa);
	}

	private Veiculo retornaPlacaSeExistente(String placa) {
		validarSeAplacaEValidaOuExistente(placa);
		return veiculoRepository.findById(placa).get();
	}

	private void validarSeAplacaEValidaOuExistente(String placa) {
		try {
			veiculoRepository.findById(placa);			
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Placa "+ placa + " não encontrada");
		}
	}

	@Override
	public Veiculo criar(Veiculo veiculo) {
		try {
			return veiculoRepository.save(veiculo);
		} catch (IllegalArgumentException e) {
			throw new IllegalAccessError("Veiculo com dados inválidos, por gentileza revise e tente novamente.");
		}
	}

	@Override
	public List<Veiculo> obterTodosVeiculosApartirDaQuantidadeDePallets(Integer quantidade) {
		return veiculoRepository.findAll();
	}

}
