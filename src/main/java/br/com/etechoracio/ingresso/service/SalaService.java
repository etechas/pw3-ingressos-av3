package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private SalaMapper salaMapper;



    public List<SalaResponseDTO> listarSalaAtiva() {
        var result = salaRepository.listarSalaAtiva();
        return  salaMapper.toRespostaDTOList(result);
    }

    public SalaResponseDTO findById(Long id){
        var result = salaRepository.findByIdAndDataExclusaoIsNull(id).orElseThrow(() -> new RuntimeException("A sala nao foi encontrada!"));
        return salaMapper.toRespostaDTO(result);
    }
    
}
