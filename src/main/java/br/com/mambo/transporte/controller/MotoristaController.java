package br.com.mambo.transporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mambo.transporte.model.Motorista;
import br.com.mambo.transporte.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

	@Autowired
	public MotoristaService motoristaService;
	
	
	@Operation(summary = "Adicionar novo motorista.")
	@PostMapping
	public ResponseEntity<Motorista> criar(@Parameter(description = "Adicionar Motorista")
	@RequestBody Motorista motorista) {
		return ResponseEntity.ok(motoristaService.criar(motorista));
	}
	
	@Operation(summary = "Buscar todos os motoristas")
	@GetMapping
	public ResponseEntity<List<Motorista>> todosMotorista() {
		return ResponseEntity.ok(motoristaService.obterTodosMotoristas());
	}
	
	@Operation(summary = "Buscar motorista pelo nome")
	@GetMapping("nome={nome}")
	public ResponseEntity<Motorista> buscarPorNome(@PathVariable String nome){
		return ResponseEntity.ok(motoristaService.obterPorNome(nome));
	}
}
