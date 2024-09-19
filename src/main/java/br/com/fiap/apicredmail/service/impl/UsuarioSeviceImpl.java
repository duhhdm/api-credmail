package br.com.fiap.apicredmail.service.impl;

import br.com.fiap.apicredmail.dto.CadastroRequestDto;
import br.com.fiap.apicredmail.dto.CadastroResponseDto;
import br.com.fiap.apicredmail.dto.UsuarioResponseDTO;
import br.com.fiap.apicredmail.dto.enums.CadastroUsuarioEnum;
import br.com.fiap.apicredmail.model.CategoriaCardsModel;
import br.com.fiap.apicredmail.model.UsuarioModel;
import br.com.fiap.apicredmail.repository.UsuarioRepository;
import br.com.fiap.apicredmail.service.CategoriaService;
import br.com.fiap.apicredmail.service.EmailService;
import br.com.fiap.apicredmail.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioSeviceImpl implements UsuarioService {

    UsuarioRepository usuarioRepository;

    EmailService emailService;

    CategoriaService categoriaService;

    @Autowired
    private UsuarioSeviceImpl(UsuarioRepository usuarioRepository,
                              CategoriaService categoriaService,
                              EmailService emailService){
        this.usuarioRepository = usuarioRepository;
        this.categoriaService = categoriaService;
        this.emailService = emailService;
    }
    @Override
    public CadastroResponseDto cadastroUsuario(CadastroRequestDto usuario) {
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
            return new CadastroResponseDto(CadastroUsuarioEnum.EXISTE.getId(),CadastroUsuarioEnum.EXISTE.getTexto());
        if(!usuario.getPassword().equals(usuario.getConfirma()))
            return new CadastroResponseDto(CadastroUsuarioEnum.INCORRETO.getId(),CadastroUsuarioEnum.INCORRETO.getTexto());
        UsuarioModel usuarioModel = usuarioRepository.save(new UsuarioModel(usuario.getNome(),usuario.getEmail(),usuario.getPassword()));
        for(int i=0; i<usuario.getCategoriaDTOList().size(); i++){
            CategoriaCardsModel categoriaCardsModel = categoriaService.salvarCategoria(usuario.getCategoriaDTOList().get(i), usuarioModel);
            emailService.cadastraEmail(usuario.getEmailDTOList().get(i),categoriaCardsModel.getId(), usuarioModel);
        }
        return new CadastroResponseDto(CadastroUsuarioEnum.SUCESSO.getId(),CadastroUsuarioEnum.SUCESSO.getTexto());
    }

    @Override
    public Optional<UsuarioModel> buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public UsuarioModel buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

}
