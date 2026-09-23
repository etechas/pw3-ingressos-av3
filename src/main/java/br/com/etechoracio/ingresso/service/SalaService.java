package br.com.etechoracio.ingresso.service;


import br.com.etechoracio.ingresso.dto.SalaRequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private SalaMapper salaMapper;


    public List<SalaResponseDTO> findBySalaAtiva() {
        var result = salaRepository.findByDataExclusaoIsNull(null);
        return salaMapper.toRespostaDTOList(result);
    }

    public Optional<SalaResponseDTO> findBySalaAtivaId(Long id) {
        return salaRepository.findByIdAndExclusaoIsNull(id)
                .map(salaMapper::toResponseDTO);
    }

    public SalaResponseDTO postSala(SalaRequestDTO requestDTO) {
        Sala sala = salaMapper.toEntity(requestDTO);
        Sala salaSave = salaRepository.save(sala);
        return salaMapper.toResponseDTO(salaSave);
    }
}
