package br.com.fiap.apicredmail.dto;

public record UsuarioResponseDTO(Integer status, String mensagem,Long id, String email, String nome) {
}
