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
@Table(name = "origem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Origem {
	
	@Id
	private String nome;
	
	private String descricao;
	
	@Embedded
	private Endereco endereco;

}
