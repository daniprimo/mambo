package br.com.mambo.transporte.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "veiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Veiculo {

	@Id
	private String placa;
	
	private String modelo;
	
	private String tipoDoVeiculo;
	
	private Integer capacidadeDePallets;
	
}
