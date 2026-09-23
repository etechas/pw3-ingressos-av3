package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    List<Sala> findByDataExclusaoIsNull(LocalDateTime dataExclusao);

    Optional<Sala> findByIdAndExclusaoIsNull(Long id);
}
