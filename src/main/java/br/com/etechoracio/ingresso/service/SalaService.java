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

    public SalaService(SalaRepository salaRepository, SalaMapper salaMapper) {
        this.salaRepository = salaRepository;
        this.salaMapper = salaMapper;
    }

    // ETAPA 1
    public List<SalaResponseDTO> listarSalasAtivas() {

        List<Sala> salas = salaRepository.findByDataExclusaoIsNull();

        return salaMapper.toResponseDTO(salas);
    }
    // ETAPA 2
    public Optional<SalaResponseDTO> buscarPorId(Long id) {

        return salaRepository
                .findByIdAndDataExclusaoIsNull(id)
                .map(salaMapper::toResponseDTO);
    }
    // ETAPA 3
    public SalaResponseDTO criar(SalaRequestDTO requestDTO) {

        Sala sala = salaMapper.toEntity(requestDTO);

        Sala salaSalva = salaRepository.save(sala);

        return salaMapper.toResponseDTO(salaSalva);
    }
}
