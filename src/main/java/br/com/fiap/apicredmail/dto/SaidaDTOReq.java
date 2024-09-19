package br.com.fiap.apicredmail.dto;

import jakarta.persistence.Column;

public record SaidaDTOReq(String para,String titulo,String conteudo, Long idUsuario){
}
