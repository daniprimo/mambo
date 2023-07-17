package br.com.mambo.transporte.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entregas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LojaEntregas {

	@Id
	private Long id;
	
	@ManyToOne
	private Loja loja;
		
	private Integer quantidadeDePalletMercearia;
	
	private Integer quantidadeDePalletFlv;
	
	private Integer quantidadeDePalletFriozem;
	
	
	
}
