package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SalaService {
    private final SalaRepository salaRepository;
    private final SalaMapper salaMapper;

    public SalaService(SalaRepository salaRepository, SalaMapper salaMapper) {
        this.salaRepository = salaRepository;
        this.salaMapper = salaMapper;
    }

    public List<SalaResponseDTO> listarSalasAtivas() {
        List<Sala> salas = salaRepository.findByDataExclusaoIsNull();

        return salaMapper.toResponseDTO(salas);
    }
}
