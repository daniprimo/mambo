package br.com.mambo.transporte.implementacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.dto.LojasEntregasDTO;
import br.com.mambo.transporte.dto.ViagemDTO;
import br.com.mambo.transporte.model.Horarios;
import br.com.mambo.transporte.model.Loja;
import br.com.mambo.transporte.model.LojaEntregas;
import br.com.mambo.transporte.model.Motorista;
import br.com.mambo.transporte.model.Origem;
import br.com.mambo.transporte.model.Veiculo;
import br.com.mambo.transporte.model.Viagem;
import br.com.mambo.transporte.repository.ViagemRepository;
import br.com.mambo.transporte.service.LojaEntregasService;
import br.com.mambo.transporte.service.LojaService;
import br.com.mambo.transporte.service.MotoristaService;
import br.com.mambo.transporte.service.OrigemService;
import br.com.mambo.transporte.service.VeiculoService;
import br.com.mambo.transporte.service.ViagemService;
import br.com.mambo.transporte.utils.enuns.StatusEnum;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ViagemServiceImpl implements ViagemService {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private MotoristaService motoristaService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private OrigemService origemService;
	
	@Autowired
	private LojaService lojaService;
	
	@Autowired
	private LojaEntregasService lojaEntregasService;

	@Override
	public Viagem programarNovaViagem(ViagemDTO dto) {
		Horarios horario = setandoHorariosPadrao();
		Motorista motorista = buscandoInfosDoMotoristaPeloNome(dto.getMotorista());
		Veiculo veiculo = buscandoVeiculoPelaPlaca(dto.getPlaca());
		Origem origem = buscandoOrigemPeloNome(dto.getOrigem());
		List<LojaEntregas> lojas = obterLojasEbtrefas(dto.getLojas());
		Viagem viagem = new Viagem(null, null, motorista, veiculo, origem, lojas, horario);
		viagem.setStatus(StatusEnum.STATUS_VIAGEM_PROGRAMADA.getDescricao());
		return viagemRepository.save(viagem);
	}

	private List<LojaEntregas> obterLojasEbtrefas(List<LojasEntregasDTO> lojas) {
		List<LojaEntregas> lojasEntregas = new ArrayList<>();
		lojas.forEach(entregas -> {
			Loja loja = lojaService.buscarLojaPorNome(entregas.getLojas());
			LojaEntregas entrega = new LojaEntregas();
			entrega.setLoja(loja);
			entrega.setQuantidadeDePalletFlv(entregas.getPalletFlv());
			entrega.setQuantidadeDePalletFriozem(entregas.getPalletFriozem());
			entrega.setQuantidadeDePalletMercearia(entregas.getPalletMercearia());
			LojaEntregas lojaEntregaSalva = salvarEntrega(entrega);
			lojasEntregas.add(lojaEntregaSalva);
		});
		
		return lojasEntregas;
	}

	private LojaEntregas salvarEntrega(LojaEntregas entrega) {
		return lojaEntregasService.addNovaEntrega(entrega);
	}


	private Origem buscandoOrigemPeloNome(String origem) {
		return origemService.buscarLojaPorNomeDaOrigem(origem);
	}

	private Veiculo buscandoVeiculoPelaPlaca(String placa) {
		return veiculoService.obterPorPlaca(placa);
	}

	private Horarios setandoHorariosPadrao() {
		return new Horarios(new SimpleDateFormat("hh:mm").format(new Date()).toString(),
				null, null, null, null, null);
	}

	private Motorista buscandoInfosDoMotoristaPeloNome(String  nomeDoMotorista) {
		return motoristaService.obterPorNome(nomeDoMotorista);
	}

	@Override
	public List<Viagem> listarViagensProgramadas() {
		return viagemRepository.findAll();
	}

	@Override
	public Viagem buscarPorId(Long id) {
		return viagemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro nao encontrado"));
	}

	@Override
	public Horarios buscarHorarioPorId(Long id) {
		Viagem viagem = buscarPorId(id);
		Horarios horarios = viagem.getHorarios();
		horarios.setChegadaLoja("00:00");
		horarios.setInicioDescarregamento("00:00");
		horarios.setFimDoCarregamento("00:00");
		horarios.setSaidaLoja("00:00");
		horarios.setChegadaCD("00:00");
		return horarios;
	}

}
