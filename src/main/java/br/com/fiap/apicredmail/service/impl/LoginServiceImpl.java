package br.com.fiap.apicredmail.service.impl;

import br.com.fiap.apicredmail.dto.LoginRequestDto;
import br.com.fiap.apicredmail.dto.UsuarioResponseDTO;
import br.com.fiap.apicredmail.dto.enums.LoginEnum;
import br.com.fiap.apicredmail.model.UsuarioModel;
import br.com.fiap.apicredmail.service.LoginService;
import br.com.fiap.apicredmail.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    UsuarioService usuarioService;

    @Autowired
    private LoginServiceImpl(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @Override
    public UsuarioResponseDTO buscarUsuario(LoginRequestDto loginRequestDto) {
        Optional<UsuarioModel> usuarioModel = usuarioService.buscarUsuarioPorEmail(loginRequestDto.usuario());
        if(!usuarioModel.isPresent())
            return new UsuarioResponseDTO(LoginEnum.INEXISTENTE.getId(),LoginEnum.INEXISTENTE.getTexto(),null,null,null);
        if(!usuarioModel.get().getSenha().equals(loginRequestDto.password()))
            return new UsuarioResponseDTO(LoginEnum.INCORRETO.getId(),LoginEnum.INCORRETO.getTexto(),null,null,null);
        return new UsuarioResponseDTO(LoginEnum.SUCESSO.getId(),LoginEnum.SUCESSO.getTexto(),usuarioModel.get().getId(),usuarioModel.get().getEmail(),usuarioModel.get().getNome());
    }

    public UsuarioResponseDTO findUsuarioLogado(Long id){
        UsuarioModel usuarioModel = usuarioService.buscarPorId(id);
        return new UsuarioResponseDTO(null,null,usuarioModel.getId(),usuarioModel.getEmail(),usuarioModel.getNome());
    }
}
