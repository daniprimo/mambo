package br.com.mambo.transporte.model;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "motorista")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Motorista {

	@Id
	private String nome;
	
	@Embedded
	private DadosPessoais nomeCompleto;
	
	@Embedded
	private CNH numeroDaCnh;
	
	
	
}
