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

import br.com.mambo.transporte.model.Loja;
import br.com.mambo.transporte.persistencia.service.LojaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/loja")
public class LojaController {
	
	@Autowired
	private LojaService lojaService;

	@Operation(summary = "Adicionando uma nova loja.")
	@PostMapping
	public ResponseEntity<Loja> addNovaLoja(@RequestBody Loja loja){
		return ResponseEntity.ok(lojaService.addNovaLoja(loja));
	}
	
	@Operation(summary = "Buscar todas as lojas.")
	@GetMapping
	public ResponseEntity<List<Loja>> todasLojas(){
		return ResponseEntity.ok(lojaService.buscarTodasLojasCadastradas());
	}
	
	@Operation(summary = "Buscar lojas por nome.")
	@GetMapping("nome={nome}")
	public ResponseEntity<Loja> buscarLojaPorNome(@PathVariable String nome){
		return ResponseEntity.ok(lojaService.buscarLojaPorNome(nome));
	}
	
}
