package br.com.etechoracio.ingresso.controller;


import br.com.etechoracio.ingresso.dto.SalaRequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@CrossOrigin("*")
public class SalaController {

    @Autowired
    private SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }


    // ETAPA 1
    // GET /salas

    @GetMapping
    public List<SalaResponseDTO> listar() {

        return salaService.listarSalasAtivas();
    }
//Etapa 2
    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> buscarPorId(
            @PathVariable Long id) {

        return salaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );

    }
    //Etapa 3
    @PostMapping
    public ResponseEntity<SalaResponseDTO> criar(
            @RequestBody SalaRequestDTO requestDTO
    ) {

        SalaResponseDTO salaCriada = salaService.criar(requestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salaCriada);
    }
}