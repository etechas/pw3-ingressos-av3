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

    @GetMapping
    public List<SalaResponseDTO> findBySalaAtiva() {
        return salaService.findBySalaAtiva();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> findById(@PathVariable Long id) {
        var result = salaService.findBySalaAtivaId(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<SalaResponseDTO> postSala(@RequestBody SalaRequestDTO requestDTO) {
        SalaResponseDTO salaCriada = salaService.postSala(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(salaCriada);
    }
}
