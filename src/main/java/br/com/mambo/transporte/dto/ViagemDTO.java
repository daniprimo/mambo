package br.com.mambo.transporte.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViagemDTO {
	
	private String motorista;
	private String placa;
	private String origem;
	private List<LojasEntregasDTO> lojas;

}
