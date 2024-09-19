package br.com.fiap.apicredmail.service;

import br.com.fiap.apicredmail.dto.LoginRequestDto;
import br.com.fiap.apicredmail.dto.UsuarioResponseDTO;

public interface LoginService {
    public UsuarioResponseDTO buscarUsuario(LoginRequestDto loginRequestDto);
    public UsuarioResponseDTO findUsuarioLogado(Long id);
}
