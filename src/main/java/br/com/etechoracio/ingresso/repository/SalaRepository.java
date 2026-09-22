package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    @Query("SELECT s FROM Sala s WHERE s.dataExclusao IS NULL")
    List<Sala> getAtivas();
    Optional<Sala> findByIdAndDataExclusaoIsNull(Long id);
}
