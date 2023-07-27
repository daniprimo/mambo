package br.com.mambo.transporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mambo.transporte.dto.ViagemDTO;
import br.com.mambo.transporte.model.Horarios;
import br.com.mambo.transporte.model.Viagem;
import br.com.mambo.transporte.service.ViagemService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

	@Autowired
	private ViagemService viagemService;
	
	@Operation(summary = "Programar uma nova viagem.")
	@PostMapping
	public ResponseEntity<Viagem> programarViagem(@RequestBody ViagemDTO dto){
		return ResponseEntity.ok(viagemService.programarNovaViagem(dto));
	}
	
	@Operation(summary = "Listar todas programadas.")
	@GetMapping("/")
	public ResponseEntity<List<Viagem>> listarTodasAsViagens() {
		return ResponseEntity.ok(viagemService.listarViagensProgramadas());
	}

	@Operation(summary = "Listar por Id.")
	@GetMapping("{id}")
	public ResponseEntity<Viagem> listarViagemINPorId(@PathVariable Long id) {
		return ResponseEntity.ok(viagemService.buscarPorId(id));
	}
	
	@Operation(summary = "Pegar horários pelo numero da viagem.")
	@GetMapping("/horario/{id}")
	public ResponseEntity<Horarios> pegarHorario(@PathVariable Long id) {
		return ResponseEntity.ok(viagemService.buscarHorarioPorId(id));
	}
	
	@Operation(summary = "Pegar viagem pela data passada por parametro.")
	@GetMapping
	public List<Viagem> findViagem(@RequestParam(value = "data", defaultValue = "") String data){
		return viagemService.findByData(data);
	}


}
