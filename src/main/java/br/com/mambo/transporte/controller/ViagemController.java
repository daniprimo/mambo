package br.com.mambo.transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mambo.transporte.model.Viagem;
import br.com.mambo.transporte.service.ViagemService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

	@Autowired
	public ViagemService viagemService;
	
	
	@Operation(summary = "Adicionar nova viagem")
	@PostMapping
	public ResponseEntity<Viagem> addNovaViagem(@RequestBody Viagem viagem){
		return ResponseEntity.ok(viagemService.addNovaViagem(viagem));
	}
	
	
}
