package br.com.mambo.transporte.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lojaEntregas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LojaEntregas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Loja loja;
		
	private Integer quantidadeDePalletMercearia;
	
	private Integer quantidadeDePalletFlv;
	
	private Integer quantidadeDePalletFriozem;
	
	
	
	
	
}
