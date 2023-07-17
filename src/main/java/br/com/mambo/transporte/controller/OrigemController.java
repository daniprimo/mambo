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

import br.com.mambo.transporte.model.Origem;
import br.com.mambo.transporte.service.OrigemService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/origem")
public class OrigemController {
	
	@Autowired
	private OrigemService origemService;
	
	@Operation(summary = "Adicionando uma nova origem.")
	@PostMapping
	public ResponseEntity<Origem> addNovaOrigem(@RequestBody Origem origem){
		return ResponseEntity.ok(origemService.addNovaOrigem(origem));
	}

	@Operation(summary = "Buscar todos os veiculo.")
	@GetMapping
	public ResponseEntity<List<Origem>> buscarTodasAsOrigens(){
		return ResponseEntity.ok(origemService.buscarTodasOrigensCadastradas());
	}

	@Operation(summary = "Buscar origem pelo nome.")
	@GetMapping("nome={nome}")
	public ResponseEntity<Origem> buscarOrigemPeloNome(@PathVariable String nome){
		return ResponseEntity.ok(origemService.buscarLojaPorNomeDaOrigem(nome));
	}

}
