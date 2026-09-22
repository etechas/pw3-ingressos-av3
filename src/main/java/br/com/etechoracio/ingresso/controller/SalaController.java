package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/salas")
@RestController
@CrossOrigin("*")

public class SalaController {
    private final SalaService service;

    public SalaController(SalaService service){

        this.service = service;
    }
    @GetMapping("/GetAll")
    public List<SalaResponseDTO> ListarSalas(){

        return service.listarSalasAtivas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
