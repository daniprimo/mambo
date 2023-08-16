package br.com.mambo.transporte.persistencia.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Viagem;
import br.com.mambo.transporte.persistencia.repository.ViagemRepository;
import br.com.mambo.transporte.persistencia.service.AcoesServices;
import br.com.mambo.transporte.persistencia.service.ViagemService;

@Service
public class ViagemAcoesImpl implements AcoesServices {

	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private ViagemService viagemService;

	@Override
	public Viagem consolidarHorarioProgramado(Long id) {
		return null;
	}

	@Override
	public Viagem consolidarHorarioInicioCarregamento(Long id) {
		Viagem viagemParaAtualziar = buscarViagemParaAtualziar(id);
		if (isContain(viagemParaAtualziar
				.getHorarios().getInicioDescarregamento())) {			
			viagemParaAtualziar.consolidarInicioDoCarregamento();
		}
		return viagemRepository.save(viagemParaAtualziar);
	}
	
	private boolean isContain(String horario) {
		if (horario.equals("")) {
			return true;
		}else {
			return false;
		}
	}

	private Viagem buscarViagemParaAtualziar(Long id) {
		return viagemService.buscarPorId(id);
	}

	@Override
	public Viagem consolidarHorarioFinalDeCarregamento(Long id) {
		Viagem viagemParaAtualziar = buscarViagemParaAtualziar(id);
		if (isContain(viagemParaAtualziar.getHorarios().getFimDoCarregamento())) {			
			viagemParaAtualziar.consolidarFinalDeCarregamento();
		}
		return viagemRepository.save(viagemParaAtualziar);
	}

	@Override
	public Viagem consolidarHorarioSaidaCD(Long id) {
		Viagem viagemParaAtualziar = buscarViagemParaAtualziar(id);
		if (isContain(viagemParaAtualziar
				.getHorarios().getSaidaCD())) {			
			viagemParaAtualziar.consolidarSaidaCD();
		}
		return viagemRepository.save(viagemParaAtualziar);	
	}

	@Override
	public Viagem consolidarHorarioChegadaLoja(Long id) {
		Viagem viagemParaAtualziar = buscarViagemParaAtualziar(id);
		if (isContain(viagemParaAtualziar
				.getHorarios().getChegadaLoja())) {			
			viagemParaAtualziar.consolidarChegadaLoja();
		}
		return viagemRepository.save(viagemParaAtualziar);	
	}

	@Override
	public Viagem consolidarHorarioSaidaLoja(Long id) {
		Viagem viagemParaAtualziar = buscarViagemParaAtualziar(id);
		if (isContain(viagemParaAtualziar
				.getHorarios().getSaidaLoja())) {			
			viagemParaAtualziar.consolidarSaidaLoja();
		}
		return viagemRepository.save(viagemParaAtualziar);
	}

	@Override
	public Viagem consolidarHorarioChegadaCD(Long id) {
		Viagem viagemParaAtualziar = buscarViagemParaAtualziar(id);
		if (isContain(viagemParaAtualziar
				.getHorarios().getChegadaCD())) {			
			viagemParaAtualziar.consolidarChegadaCD();
		}
		return viagemRepository.save(viagemParaAtualziar);	
	}

	

}
