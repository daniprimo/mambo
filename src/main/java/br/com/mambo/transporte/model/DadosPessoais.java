package br.com.mambo.transporte.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoais {

	private String nomeCompleto;
	private String rg;
	private String cpf;
	private String numeroParaContato;

}
