package br.com.mambo.transporte.model;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import br.com.mambo.transporte.utils.enuns.StatusEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_viagem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Viagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String status;
	
	@ManyToOne
	private Motorista motorista;
	
	@ManyToOne
	private Veiculo veiculo;
	
	@ManyToOne
	private Origem origem;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_entregas")
	private List<LojaEntregas> lojas;
	
	@Embedded
	private Horarios horarios;
	
	private String horaDoRegistro;
	
	public void horarioStam() {
		
	}
	
	public void consolidarInicioDoCarregamento() {
		String horaAtual = horaAtual();
		horarios.setInicioDescarregamento(horaAtual);
		setStatus(StatusEnum.STATUS_VIAGEM_EM_CARREGAMENTO.getDescricao());	
		
	}

	private String horaAtual() {
		DateTimeFormatter horaAtual = DateTimeFormatter.ofPattern("HH:mm");
		return horaAtual.format(ZonedDateTime.now());
	}


}
