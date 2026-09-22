package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long>
{
    @Query("SELECT s FROM Sala s join fetch s.sessao WHERE s.filme.id = :idFilme" +
            " AND s.data >= :date AND s.dataExclusao IS NULL")
    List<Sala> listarSalaAtiva();

}