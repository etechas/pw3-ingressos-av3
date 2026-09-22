package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.SalaRequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import org.springframework.stereotype.Service;
import java.lang.Long;

import java.util.List;
import java.util.Optional;

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
        return salaMapper.toResponseDTOList(salas);
    }


    public Optional<SalaResponseDTO> buscarSalaAtivaPorId(Long id) {
        return salaRepository.findByIdAndDataExclusaoIsNull(id)
                .map(salaMapper::toResponseDTO);
    }

    public SalaResponseDTO cadastrarSala(SalaRequestDTO requestDTO) {
        Sala sala = salaMapper.toEntity(requestDTO);
        Sala salaSalva = salaRepository.save(sala);
        return salaMapper.toResponseDTO(salaSalva);

    }
}
