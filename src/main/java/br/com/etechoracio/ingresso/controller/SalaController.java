package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.SalaRequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
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

    @GetMapping("/ativas")
    public List<SalaResponseDTO> findByEmCartaz() {
        return salaService.getAtivas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> findById(@PathVariable Long id){
        var result = salaService.findById(id);
        if(result != null){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> criarSala(@RequestBody SalaRequestDTO dto){
        var result = salaService.criarsala(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
