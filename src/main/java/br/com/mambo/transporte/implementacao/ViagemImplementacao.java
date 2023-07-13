package br.com.mambo.transporte.implementacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Loja;
import br.com.mambo.transporte.model.LojaEntregas;
import br.com.mambo.transporte.model.Viagem;
import br.com.mambo.transporte.repository.ViagemRepository;
import br.com.mambo.transporte.service.LojaService;
import br.com.mambo.transporte.service.LojasEntregasService;
import br.com.mambo.transporte.service.MotoristaService;
import br.com.mambo.transporte.service.ViagemService;

@Service
public class ViagemImplementacao implements ViagemService {

	@Autowired
	public ViagemRepository viagemRepository;
	
	@Autowired
	public MotoristaService motoristaService;
	
	@Autowired
	public LojasEntregasService entregasService;
	
	@Autowired
	public LojaService lojaService;
	
	@Override
	public Viagem addNovaViagem(Viagem viagem) {
		List<LojaEntregas> listas = new ArrayList<>();
		
		
		viagem.getLojas().stream().forEach(entregas -> entregasService.addLojaEntregas(new LojaEntregas(lojaService.buscarLojaPeloNome(entregas.getLoja().getNomeLoja()),
				entregas.getQuantidadeDePalletFlv(), entregas.getQuantidadeDePalletMercearia(), entregas.getQuantidadeDePalletFriozem())));
		
		
		
		viagem.setMotorista(motoristaService.obterPorCodigo(viagem.getMotorista().getId()));
		
		return viagemRepository.save(viagem);
	}




	@Override
	public List<Viagem> listaViagens() {
		return viagemRepository.findAll();
	}

	
	
}
