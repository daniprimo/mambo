package br.com.mambo.transporte.persistencia.implementacao;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
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
import br.com.mambo.transporte.persistencia.repository.ViagemRepository;
import br.com.mambo.transporte.persistencia.service.LojaEntregasService;
import br.com.mambo.transporte.persistencia.service.LojaService;
import br.com.mambo.transporte.persistencia.service.MotoristaService;
import br.com.mambo.transporte.persistencia.service.OrigemService;
import br.com.mambo.transporte.persistencia.service.VeiculoService;
import br.com.mambo.transporte.persistencia.service.ViagemService;
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
		Motorista motorista = 
				buscandoInfosDoMotoristaPeloNome(dto.getMotorista());
		Veiculo veiculo = buscandoVeiculoPelaPlaca(dto.getPlaca());
		Origem origem = buscandoOrigemPeloNome(dto.getOrigem());
		List<LojaEntregas> lojas = obterLojasEbtrefas(dto.getLojas());
		String registro = new SimpleDateFormat("HH:mm")
				.format(Calendar.getInstance().getTime());
		Viagem viagem = new Viagem(null, null, motorista,
				veiculo, origem, lojas, new Horarios(), registro);
		viagem
			.consolidarProgramado();
		viagem
			.setarAsStringsVaziasNosHorários();
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
		return new Horarios("00:00",
				"00:00", "00:00", "00:00", "00:00", "00:00");
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
		return horarios;
	}

	@Override
	public List<Viagem> findByData(String data) {
		LocalDate dataAtual = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate inputData = data.equals("") ? dataAtual  : LocalDate.parse(data);
		return viagemRepository.findAllData(inputData);
	}


}
