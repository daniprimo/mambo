package br.com.mambo.transporte.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("viagem-expedicao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Viagem {
	
	@Id
	private String id;
	
	private String status;
	
	@DBRef
	private Motorista motorista;
	
	@DBRef
	private Veiculo veiculo;
	
	@DBRef
	private Origem origem;
	
	@DBRef
	private Ajudante ajudante;
	
	private List<LojaEntregas> lojas;
	
	private Horarios horarios;
	
	
	public Viagem ProgramarViagem (String id, Motorista motorista, Origem origem, LojaEntregas lojas) {
		Viagem viagemProgramada = new Viagem();
		viagemProgramada.id = id;
		viagemProgramada.motorista = motorista;
		viagemProgramada.origem = origem;
		viagemProgramada.lojas.add(lojas);		
		viagemProgramada.horarios.setData();
		return viagemProgramada;
	}

	public Viagem ProgramarViagem (Motorista motorista, Origem origem, List<LojaEntregas> lojas) {
		Viagem viagemProgramada = new Viagem();
		viagemProgramada.motorista = motorista;
		viagemProgramada.origem = origem;
		viagemProgramada.lojas.addAll(lojas);
		viagemProgramada.horarios.setData();
		return viagemProgramada;
	}


}
