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
@Table(name = "loja")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Loja {
	
	@Id
	private String nomeLoja;
	
	private String descricaoLoja;
	
	@Embedded
	private Endereco endereco;
	
	@Embedded
	private Contato contatoDaLoja;

}
