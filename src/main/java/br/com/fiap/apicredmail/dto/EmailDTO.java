package br.com.fiap.apicredmail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailDTO {
        Long id;
        String remetente;
        String titulo;
        Long categoria;
        String conteudo;
        Integer corTexto;
        Integer corCard;
        Long idUsuario;
        Boolean flagLido;

    public EmailDTO(String remetente, String titulo, Long categoria, String conteudo, Boolean lido) {
        this.remetente = remetente;
        this.titulo = titulo;
        this.categoria = categoria;
        this.conteudo = conteudo;
        this.flagLido = lido;

    }
}
