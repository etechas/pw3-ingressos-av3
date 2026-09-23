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
    private SalaRepository repository;
    @Autowired
    private SalaMapper mapper;

    public List<SalaResponseDTO> listarAtivas() {
        return mapper.toDTOList(repository.findByDataExclusaoIsNull());
    }

    public Optional<SalaResponseDTO> buscarPorId(Long id) {
        return repository.findByIdAndDataExclusaoIsNull(id).map(mapper::toDTO);
    }

    public SalaResponseDTO cadastrar(SalaRequestDTO dto) {
        Sala salva = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(salva);
    }
}
