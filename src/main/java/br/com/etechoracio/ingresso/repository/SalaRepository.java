package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    // Etapa 1 - busca todas as salas ativas
    List<Sala> findByDataExclusaoIsNull();
    // Etapa 2 - busca uma sala pelo ID somente se estiver ativa
    Optional<Sala> findByIdAndDataExclusaoIsNull(Long id);
}
