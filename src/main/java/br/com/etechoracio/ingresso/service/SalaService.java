package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.SalaRequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
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

    public List<SalaResponseDTO> listarAtivas() {
        var salas = salaRepository.findByDataExclusaoIsNull();
        return salaMapper.toRespostaDTOList(salas);
    }

    public Optional<SalaResponseDTO> findById(Long id) {
        var sala = salaRepository.findByIdAndDataExclusaoIsNull(id);

        if(sala.isPresent()){
            return Optional.of(salaMapper.toResponseDTO(sala.get()));
        }
        else{
            return Optional.empty();
        }
    }

    public SalaResponseDTO cadastrar(SalaRequestDTO dto) {
        var sala = salaMapper.toEntity(dto);
        var salaSalva = salaRepository.save(sala);
        return salaMapper.toResponseDTO(salaSalva);
    }

}