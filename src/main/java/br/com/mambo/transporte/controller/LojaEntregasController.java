package br.com.mambo.transporte.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mambo.transporte.model.LojaEntregas;
import br.com.mambo.transporte.service.LojasEntregasService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/entregas")
public class LojaEntregasController {

	@Autowired
	public LojasEntregasService entregasService;
	
	@Operation(summary = "Listar todas as entregas")
	@GetMapping
	public ResponseEntity<List<LojaEntregas>> listarTodasAsEntregas(){
		return ResponseEntity.ok(entregasService.buscarTodasEntregas());
	}
	
	
	@Operation(summary = "Listar Entregas por data")
	@GetMapping("data={data}")
	public ResponseEntity<List<LojaEntregas>> listarEntregasPorData(@PathVariable LocalDate data){
		return ResponseEntity.ok(entregasService.listarEntregasPorData(data));
	}
	
	@Operation(summary = "Buscar Entregas por codigo")
	@GetMapping("codigo={id}")
	public ResponseEntity<LojaEntregas> listarEntregasPorData(@PathVariable String id){
		return ResponseEntity.ok(entregasService.buscarEntregasPorCodigo(id));
	}
	
	
}
