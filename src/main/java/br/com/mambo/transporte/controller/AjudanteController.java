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

import br.com.mambo.transporte.model.Ajudante;
import br.com.mambo.transporte.service.AjudanteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ajudante")
public class AjudanteController {

	@Autowired
	public AjudanteService ajudanteService;
	
	@Operation(summary = "Adicionar um novo ajudante.")
	@PostMapping
	public ResponseEntity<Ajudante> addAjudante(@RequestBody Ajudante ajudante){
		return ResponseEntity.ok(ajudanteService.addAjudante(ajudante));
	}
	
	@Operation(summary = "Listar todos os ajudantes")
	@GetMapping
	public ResponseEntity<List<Ajudante>> listarTodosOsAjudantes() {
		return ResponseEntity.ok(ajudanteService.buscarTodosOsAjudantes());
	}
	
	@Operation(summary = "Buscar ajudante pelo nome")
	@GetMapping("nome={nome}")
	public ResponseEntity<Ajudante> buscarPorAjudantePorNome(@PathVariable String nome){
		return ResponseEntity.ok(ajudanteService.pesquisarAjudantePorNome(nome));
	}
	
	
}
