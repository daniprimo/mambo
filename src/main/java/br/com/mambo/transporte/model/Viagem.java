package br.com.mambo.transporte.model;

import java.util.List;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Viagem {
	
	
	private String id;
	
	private String status;
	
	private Motorista motorista;
	
	private Veiculo veiculo;
	
	private Origem origem;
		
	private List<LojaEntregas> lojas;
	
	@Embedded
	private Horarios horarios;
	


}
