package br.com.mambo.transporte.model;

import java.time.LocalDate;

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
public class Horarios {
	
	private LocalDate data;

	private String saidaCD;

	private String chegadaLoja;

	private String inicioDescarregamento;

	private String fimDoCarregamento;

	private String saidaLoja;

	private String chegadaCD;
	
	

	public void setData() {
		this.data = LocalDate.now();
	}



	public Horarios(String saidaCD, String chegadaLoja, String inicioDescarregamento, String fimDoCarregamento,
			String saidaLoja, String chegadaCD) {
		super();
		setData();
		this.saidaCD = saidaCD;
		this.chegadaLoja = chegadaLoja;
		this.inicioDescarregamento = inicioDescarregamento;
		this.fimDoCarregamento = fimDoCarregamento;
		this.saidaLoja = saidaLoja;
		this.chegadaCD = chegadaCD;
	}
}
