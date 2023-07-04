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

import br.com.mambo.transporte.model.Veiculo;
import br.com.mambo.transporte.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	public VeiculoService veiculoService;
	
	@Operation(summary = "Adicionar novo (veiculo, caminhão).")
	@PostMapping
	public ResponseEntity<Veiculo> addVeiculo(@RequestBody Veiculo veiculo) {
		return ResponseEntity.ok(veiculoService.addVeiculo(veiculo));
	}
	
	@Operation(summary = "Obter todos os veiculos registrados.")
	@GetMapping
	public ResponseEntity<List<Veiculo>> buscarTodosOsVeiculos (){
		return ResponseEntity.ok(veiculoService.listaDeTodosVeiculo());
	}
	
	@Operation(summary = "Obter Veiculo por placa.")
	@GetMapping("placa={placa}")
	public ResponseEntity<Veiculo> pesquisarVeiculoPorPlaca(@PathVariable String placa) {
		return ResponseEntity.ok(veiculoService.pesquisarPorPlaca(placa));
	}
}
