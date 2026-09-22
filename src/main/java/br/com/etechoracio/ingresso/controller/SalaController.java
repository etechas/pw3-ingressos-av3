package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
