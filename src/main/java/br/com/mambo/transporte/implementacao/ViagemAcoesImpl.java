package br.com.mambo.transporte.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Viagem;
import br.com.mambo.transporte.repository.ViagemRepository;
import br.com.mambo.transporte.service.AcoesServices;
import br.com.mambo.transporte.service.ViagemService;

@Service
public class ViagemAcoesImpl implements AcoesServices {

	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private ViagemService viagemService;

	@Override
	public Viagem consolidarHorarioProgramado(Long id) {
		Viagem viagemAtualizada = viagemService.buscarPorId(id);
		viagemAtualizada.consolidarInicioDoCarregamento();
		return null;
	}

	@Override
	public Viagem consolidarHorarioInicioCarregamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viagem consolidarHorarioFinalDeCarregamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viagem consolidarHorarioSaidaCD(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viagem consolidarHorarioChegadaLoja(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viagem consolidarHorarioSaidaLoja(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viagem consolidarHorarioChegadaCD(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
