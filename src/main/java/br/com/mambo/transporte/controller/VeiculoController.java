package br.com.mambo.transporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mambo.transporte.model.Veiculo;
import br.com.mambo.transporte.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	
	@Operation(summary = "Adicionando um novo veiculo.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Veiculo foi adicionado com sucesso."),
			@ApiResponse(responseCode = "403", description = "Entre em contato com a equipe de T.I para obter o acesso."),
			@ApiResponse(responseCode = "500", description = "Falha no código fonte, reporte a equipe de T.I para dar a devida manutenção.")
	})
	@PostMapping
	public ResponseEntity<Veiculo> addNovoVeiculo(Veiculo veiculo) {
		return ResponseEntity.ok(veiculoService.criar(veiculo));
	}

	@Operation(summary = "Buscar todos os veiculos.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Todos veiculos carregados com sucesso."),
			@ApiResponse(responseCode = "403", description = "Entre em contato com a equipe de T.I para obter o acesso."),
			@ApiResponse(responseCode = "500", description = "Falha no código fonte, reporte a equipe de T.I para dar a devida manutenção.")
	})
	@GetMapping
	public ResponseEntity<List<Veiculo>> obterTodosOsVeiculos(){
		return ResponseEntity.ok(veiculoService.todosOsVeiculos());
	}
	
	@Operation(summary = "Buscar veiculo por placa.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Veiculo com placa informada carregada com sucesso."),
			@ApiResponse(responseCode = "403", description = "Entre em contato com a equipe de T.I para obter o acesso."),
			@ApiResponse(responseCode = "500", description = "Falha no código fonte, reporte a equipe de T.I para dar a devida manutenção.")
	})
	@GetMapping("placa={placa}")
	public ResponseEntity<Veiculo> obterPorPlaca (@PathVariable String placa) {
		return ResponseEntity.ok(veiculoService.obterPorPlaca(placa));
	}

	@Operation(summary = "Buscar veiculo por capacidade de pallet.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Veiculo com capacidade de pallet informada ´carregado com sucesso."),
			@ApiResponse(responseCode = "403", description = "Entre em contato com a equipe de T.I para obter o acesso."),
			@ApiResponse(responseCode = "500", description = "Falha no código fonte, reporte a equipe de T.I para dar a devida manutenção.")
	})
	@GetMapping("capacidadeDePallets={capacidadeDePallets}")
	public ResponseEntity<List<Veiculo>> buscarPorQuantidadeDePallet(@PathVariable Integer capacidadeDePallet){
		return ResponseEntity.ok(veiculoService.obterTodosVeiculosApartirDaQuantidadeDePallets(capacidadeDePallet));
	}
	
	
	
}
