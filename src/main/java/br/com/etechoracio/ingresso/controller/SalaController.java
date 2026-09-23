package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.SalaRequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@CrossOrigin("*")
public class SalaController {
    @Autowired
    private SalaService service;

    @GetMapping
    public List<SalaResponseDTO> listar() {
        return service.listarAtivas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> cadastrar(@RequestBody SalaRequestDTO dto) {
        SalaResponseDTO criado = service.cadastrar(dto);
        return ResponseEntity.status(201).body(criado);
    }

}
