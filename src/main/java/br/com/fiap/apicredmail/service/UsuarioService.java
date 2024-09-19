package br.com.fiap.apicredmail.service;

import br.com.fiap.apicredmail.dto.CadastroRequestDto;
import br.com.fiap.apicredmail.dto.CadastroResponseDto;
import br.com.fiap.apicredmail.dto.UsuarioResponseDTO;
import br.com.fiap.apicredmail.model.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UsuarioService {
    public CadastroResponseDto cadastroUsuario(CadastroRequestDto usuario);
    public Optional<UsuarioModel> buscarUsuarioPorEmail(String email);

    public UsuarioModel buscarPorId(Long id);
}
