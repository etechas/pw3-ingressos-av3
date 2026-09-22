package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private SalaMapper salaMapper;

    public List<SalaResponseDTO> findSalas(){
        var salas = salaRepository.findByDataExclusaoIsNull();
        return salaMapper.toSalasResponseDTO(salas);
    }

    public Optional<SalaResponseDTO> findById(Long id){
        return salaRepository.findByIdAndDataExclusaoIsNull(id).map(sala -> salaMapper.toSalaResponseDTO(sala));

    }

}
