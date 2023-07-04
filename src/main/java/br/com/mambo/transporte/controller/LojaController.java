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
import br.com.mambo.transporte.service.LojaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/loja")
public class LojaController {

	@Autowired
	public LojaService lojaService;
	
	@Operation(summary = "Adicionar nova loja")
	@PostMapping
	public ResponseEntity<Loja> addLoja(@RequestBody Loja loja){
		return ResponseEntity.ok(lojaService.addLoja(loja));
	}
	
	@Operation(summary = "Listar todas as lojas")
	@GetMapping
	public ResponseEntity<List<Loja>> listarTodasAsLojas(){
		return ResponseEntity.ok(lojaService.listarTodasLojas());
	}
	
	@Operation(summary = "Buscar loja pelo nome")
	@GetMapping("loja={nome}")
	public ResponseEntity<Loja> addLoja(@PathVariable String nome){
		return ResponseEntity.ok(lojaService.buscarLojaPeloNome(nome));
	}


	
 	
}
