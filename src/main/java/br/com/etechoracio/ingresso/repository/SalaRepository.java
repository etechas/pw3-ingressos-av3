package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Filme;
import br.com.etechoracio.ingresso.entity.Sala;
import br.com.etechoracio.ingresso.entity.Sessao;
import br.com.etechoracio.ingresso.enums.SimNaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SalaRepository extends JpaRepository <Sala, Long> {
    List<Sala> findByIdAndDataExclusaoIsNull(SimNaoEnum id);

    @Query("SELECT s FROM Sala s WHERE s.dataExclusao IS NULL")
     List<SalaResponseDTO> findAllSala(Long id);
}
