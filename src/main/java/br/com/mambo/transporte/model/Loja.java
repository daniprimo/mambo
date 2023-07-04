package br.com.mambo.transporte.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("loja")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loja {
	
	@Id
	private String nomeLoja;
	
	private String descricaoLoja;
	
	private Endereco enderecoDaLoja;
	
	private List<Contato> contatosDaLoja;
	
	

}
