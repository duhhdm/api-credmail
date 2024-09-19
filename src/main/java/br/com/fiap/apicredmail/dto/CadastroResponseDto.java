package br.com.fiap.apicredmail.dto;

import br.com.fiap.apicredmail.dto.enums.CadastroUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CadastroResponseDto {
    private Integer id;
    private String mensagem;
}
