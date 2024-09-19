package br.com.fiap.apicredmail.dto;

import java.util.List;

public record HomeDTO(List<CategoriaDTO> categoriaDTOList, List<EmailDTO> emailDTOList) {
}
