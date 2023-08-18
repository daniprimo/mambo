package br.com.mambo.transporte.persistencia.implementacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.log.LogMamboService;
import br.com.mambo.transporte.model.Veiculo;
import br.com.mambo.transporte.persistencia.repository.VeiculoRepository;
import br.com.mambo.transporte.persistencia.service.VeiculoService;
import br.com.mambo.transporte.utils.exceptions.ErroAoRealizarUmaBuscaNoBD;
import br.com.mambo.transporte.utils.exceptions.ErroAoSalvarEntidadeNoBD;
import br.com.mambo.transporte.utils.exceptions.ErroQuandoORetornoForNull;
import br.com.mambo.transporte.utils.exceptions.handle.MamboExceptions;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	//private static final Logger log = LoggerFactory.getLogger(VeiculoServiceImpl.class);
	private static final LogMamboService log = new LogMamboService("VEICULO SERVICE", VeiculoServiceImpl.class);
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@Override
	public List<Veiculo> todosOsVeiculos() {
		log.info("Requisição retorna todos veiculos cadastrados.");
		return listaDeRetornaTodosOsVeiculos();
	}

	
	@Override
	public Veiculo obterPorPlaca(String placa) {
		log.info("Requisição retorna dados pela placa");
		return retornaPlacaSeExistente(placa);
	}

	@Override
	public Veiculo criar(Veiculo veiculo) {
		log.info("Iniciando requisição de add veiculo.");
		return adicionarVeiculoNoBancoDeDados(veiculo);
	}


	@Override
	public List<Veiculo> obterTodosVeiculosApartirDaQuantidadeDePallets(Integer quantidade) {
		throw new ErroQuandoORetornoForNull("Em desenvolvimento");
	}

	private List<Veiculo> listaDeRetornaTodosOsVeiculos() {
		try {			
			List<Veiculo> listaDeVeiculos = null;
			verificarSeAlistaENull(listaDeVeiculos);
			log.info("Sucesso ao retornar veiculos.");
			return listaDeVeiculos;
		} catch (Exception e) {
			log.error("Erro ao buscar todos os veiculos. "+ e.getMessage());
			throw new ErroAoRealizarUmaBuscaNoBD("Nenhum veiculo registrado - "+ e.getMessage());
		}
		
	}

	private void verificarSeAlistaENull(List<Veiculo> listaDeVeiculos) {
		if (listaDeVeiculos.isEmpty()) {
			throw new RuntimeException();
		}
	}
	
	private Veiculo retornaPlacaSeExistente(String placa) {
		try {			
			validarSeAplacaEValidaOuExistente(placa);
			Optional<Veiculo> veiculo = veiculoRepository.findById(placa);
			log.info("Sucesso ao realizar a busca por placa.");
			return veiculo.get();
		} catch (RuntimeException e) {
			// TODO: handle exception
			log.error("Placa não existente no banco de dados. - "+ e.getMessage());
			throw new ErroAoRealizarUmaBuscaNoBD(log.getLocal() + "- Placa não existente no banco de dados.");
		}
		
		
		
	}

	private void validarSeAplacaEValidaOuExistente(String placa) {
		if (!veiculoRepository.existsById(placa)) {			
			throw new RuntimeException(placa);
		}
	}
	

	private Veiculo adicionarVeiculoNoBancoDeDados(Veiculo veiculo) {
		try {
			verificarSeJaExisteVeiculo(veiculo);
			Veiculo save = veiculoRepository.save(veiculo);
			log.info("Veiculo salvo com sucesso.");
			return save;
		} catch (MamboExceptions e) {
			log.error("Veiculo existente.");
			throw new ErroAoSalvarEntidadeNoBD("Veiculo já existente.");
		} catch (Exception e) {
			log.error("Erro nos argumentos da requisição.");
			throw new ErroAoSalvarEntidadeNoBD("Argumentos da requisição estão incorretos	.");
		}
	}

	private void verificarSeJaExisteVeiculo(Veiculo veiculo) {
		if (veiculoRepository.existsById(veiculo.getPlaca())) {
			throw new MamboExceptions();
		}
	}



}
