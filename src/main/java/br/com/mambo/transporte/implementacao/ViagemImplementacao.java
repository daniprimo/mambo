package br.com.mambo.transporte.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Viagem;
import br.com.mambo.transporte.repository.ViagemRepository;
import br.com.mambo.transporte.service.MotoristaService;
import br.com.mambo.transporte.service.ViagemService;

@Service
public class ViagemImplementacao implements ViagemService {

	@Autowired
	public ViagemRepository viagemRepository;
	
	@Autowired
	public MotoristaService motoristaService;
	
	
	
	
	@Override
	public Viagem addNovaViagem(Viagem viagem) {
		
		
		viagem.setMotorista(motoristaService.obterPorCodigo(viagem.getMotorista().getId()));
		
		
		return viagemRepository.save(viagem);
	}

	
	
}
