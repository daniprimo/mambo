package br.com.mambo.transporte.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	private String logradouro;
	private String numero;
	private String cep;
	private String uf;
	private String localidade;
	private String bairro;
	
}
