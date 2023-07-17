package br.com.mambo.transporte.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LojasEntregasDTO {
	
	private String lojas;
	private Integer palletFlv;
	private Integer palletMercearia;
	private Integer palletFriozem;


}
