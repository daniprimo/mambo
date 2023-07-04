package br.com.mambo.transporte.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("veiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

	@Id
	private String placa;
	
	private String tipoVeiculo;
	
	private int limiteDePallets;
	
	
}
