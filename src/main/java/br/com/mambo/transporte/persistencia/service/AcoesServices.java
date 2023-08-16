package br.com.mambo.transporte.persistencia.service;

import org.springframework.stereotype.Service;

import br.com.mambo.transporte.model.Viagem;

@Service
public interface AcoesServices {
	
	public Viagem consolidarHorarioProgramado(Long id);
	public Viagem consolidarHorarioInicioCarregamento(Long id);
	public Viagem consolidarHorarioFinalDeCarregamento(Long id);
	public Viagem consolidarHorarioSaidaCD(Long id);
	public Viagem consolidarHorarioChegadaLoja(Long id);
	public Viagem consolidarHorarioSaidaLoja(Long id);
	public Viagem consolidarHorarioChegadaCD(Long id);
	
	
}
