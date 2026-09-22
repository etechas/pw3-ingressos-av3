package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@CrossOrigin("*")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public List<SalaResponseDTO> listarSalaAtiva() {
        return salaService.listarSalaAtiva();
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
