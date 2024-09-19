package br.com.fiap.apicredmail.dto;

import br.com.fiap.apicredmail.model.UsuarioModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CadastroRequestDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String password;
    @NotBlank
    private String confirma;
    @NotBlank
    @Email
    private String email;

    private List<EmailCadastroDTO> emailDTOList;

    private List<CategoriaDTO> categoriaDTOList;
}
