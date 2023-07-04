package br.com.mambo.transporte.model;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("entregas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LojaEntregas {
	
	@Id
	private String id;
	
	@DBRef
	private Loja loja;
	
	private String quantidadeDePalletFlv;
	
	private String quantidadeDePalletMercearia;
	
	private String quantidadeDePalletFriozem;
	
	private LocalDate data = LocalDate.now();

	public LojaEntregas(Loja loja, String quantidadeDePalletFlv, String quantidadeDePalletMercearia,
			String quantidadeDePalletFriozem) {
		super();
		this.loja = loja;
		this.quantidadeDePalletFlv = quantidadeDePalletFlv;
		this.quantidadeDePalletMercearia = quantidadeDePalletMercearia;
		this.quantidadeDePalletFriozem = quantidadeDePalletFriozem;
	}
	
	
}
