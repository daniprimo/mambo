package br.com.mambo.transporte.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ajudante {
	
	@Id
	private String nome;
	
	private String nomeCompleto;
	
	private String telefone;	
	

}
