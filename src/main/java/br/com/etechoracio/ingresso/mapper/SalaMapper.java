package br.com.etechoracio.ingresso.mapper;

import br.com.etechoracio.ingresso.dto.SalaRequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SalaMapper.class)
public interface SalaMapper {

    List<SalaResponseDTO> toResponseDTO(List<Sala> salas);

    // Etapa 2  - converte uma Sala para DTO
    SalaResponseDTO toResponseDTO(Sala sala);

    // Etapa 3 - converte Request DTO para entidade
    Sala toEntity(SalaRequestDTO requestDTO);
}