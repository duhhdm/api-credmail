package br.com.fiap.apicredmail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public record EmailCadastroDTO(String remetente, String titulo,String conteudo,Integer corTexto,Integer corCard) {
}
