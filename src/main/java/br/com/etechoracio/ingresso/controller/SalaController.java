package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.SalaRequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public List<SalaResponseDTO> findSalas(){
        return salaService.findSalas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> findById(@PathVariable Long id){
        var result = salaService.findById(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> createSala(@RequestBody SalaRequestDTO salaRequestDTO){
        var result = salaService.postSala(salaRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
