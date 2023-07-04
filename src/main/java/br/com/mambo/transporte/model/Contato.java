package br.com.mambo.transporte.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
	
	private String nome;
	private String cargo;
	private String numeroDeWhatsApp;

}
