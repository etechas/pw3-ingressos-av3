package br.com.etechoracio.ingresso.dto;

import java.time.LocalDateTime;

public record SalaResponseDTO(
        Long id,
        String nome,
        Double preco
) {
}

