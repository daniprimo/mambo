package br.com.mambo.transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mambo.transporte.model.Viagem;
import br.com.mambo.transporte.persistencia.service.AcoesServices;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/acoes")
public class AcoesController {
	
	@Autowired
	private AcoesServices acoesServices;

	@Operation(description = "Setar inicio de carregamento")
	@PostMapping("/inicioCarregamento/{id}")
	public ResponseEntity<Viagem> setInicioDeCarregamento(@RequestParam Long id){
		return ResponseEntity.ok(acoesServices
				.consolidarHorarioInicioCarregamento(id));
	}	
	@Operation(description = "Setar fim de carregamento")
	@PostMapping("/fimCarregamento/{id}")
	public ResponseEntity<Viagem> setFimDeCarregamento(@RequestParam Long id){
		return ResponseEntity.ok(acoesServices
				.consolidarHorarioFinalDeCarregamento(id));
	}	

	@Operation(description = "Setar Saida do cd")
	@PostMapping("/saidaCD/{id}")
	public ResponseEntity<Viagem> setSaidaDoCD(@RequestParam Long id){
		return ResponseEntity.ok(acoesServices
				.consolidarHorarioSaidaCD(id));
	}	

	@Operation(description = "Setar chegada loja")
	@PostMapping("/chegadaLoja/{id}")
	public ResponseEntity<Viagem> setChegadaLoja(@RequestParam Long id){
		return ResponseEntity.ok(acoesServices
				.consolidarHorarioChegadaLoja(id));
	}

	@Operation(description = "Setar saida loja")
	@PostMapping("/saidaLoja/{id}")
	public ResponseEntity<Viagem> setSaidaLoja(@RequestParam Long id){
		return ResponseEntity.ok(acoesServices
				.consolidarHorarioSaidaLoja(id));
	}	

	@Operation(description = "Setar chegada CD")
	@PostMapping("/chegadaCD/{id}")
	public ResponseEntity<Viagem> setChegadaCD(@RequestParam Long id){
		return ResponseEntity.ok(acoesServices
				.consolidarHorarioChegadaCD(id));
	}	
	/*

	*/
	
}
