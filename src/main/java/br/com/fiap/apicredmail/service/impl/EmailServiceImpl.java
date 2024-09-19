package br.com.fiap.apicredmail.service.impl;

import br.com.fiap.apicredmail.dto.EmailCadastroDTO;
import br.com.fiap.apicredmail.dto.EmailDTO;
import br.com.fiap.apicredmail.dto.SaidaDTOReq;
import br.com.fiap.apicredmail.model.EntradaModel;
import br.com.fiap.apicredmail.model.SaidaDTORes;
import br.com.fiap.apicredmail.model.SaidaModel;
import br.com.fiap.apicredmail.model.UsuarioModel;
import br.com.fiap.apicredmail.repository.EmailEntradaRepository;
import br.com.fiap.apicredmail.repository.EmailSaidaRepository;
import br.com.fiap.apicredmail.repository.UsuarioRepository;
import br.com.fiap.apicredmail.service.EmailService;
import br.com.fiap.apicredmail.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailEntradaRepository entradaRepository;
    @Autowired
    private EmailSaidaRepository emailSaidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void cadastraEmail(EmailCadastroDTO emailDTO, Long categoria, UsuarioModel usuarioModel) {
        entradaRepository.save(new EntradaModel(null,emailDTO.remetente(),emailDTO.titulo(),categoria,emailDTO.conteudo(),false,usuarioModel, emailDTO.corTexto(), emailDTO.corCard()));
    }

    @Override
    public List<EmailDTO> listEmailHome(Long id) {
        List<EntradaModel> list = entradaRepository.findByUsuarioModelId(id);
        return list.
                stream().
                map(
                        email -> new EmailDTO(
                                email.getId(),
                                email.getRemetente(),
                                email.getTitulo(),
                                email.getCategoria(),
                                email.getConteudo(),
                                email.getCorTexto(),
                                email.getCorCard(),
                                email.getUsuarioModel().getId(),
                                email.getLido())).
                collect(Collectors.toList());
    }

    @Override
    public EmailDTO buscaEmail(Long id) {
        EntradaModel email = entradaRepository.findById(id).orElseThrow();
        email.setLido(true);
        entradaRepository.save(email);
        return new EmailDTO(
                email.getId(),
                email.getRemetente(),
                email.getTitulo(),
                email.getCategoria(),
                email.getConteudo(),
                email.getCorTexto(),
                email.getCorCard(),
                email.getUsuarioModel().getId(),
                email.getLido());
    }

    @Override
    public void salvarEmailSaida(SaidaDTOReq req) {
        UsuarioModel usuarioModel = usuarioRepository.findById(req.idUsuario()).orElseThrow();
        if(emailSaidaRepository.findByUsuarioModelIdAndPara(req.idUsuario(), req.para()).size()>=3)
            emailSaidaRepository.save(new SaidaModel(req.para(), req.titulo(), req.conteudo(), true,usuarioModel));
        emailSaidaRepository.save(new SaidaModel(req.para(), req.titulo(), req.conteudo(), false,usuarioModel));
    }

    @Override
    public List<SaidaDTORes> buscarEmailEnviado(Long id) {
        List<SaidaModel> saidaModels = emailSaidaRepository.findByUsuarioModelIdAndSpam(id,false);

        return saidaModels.stream().map( email -> new SaidaDTORes(email.getId(), email.getPara(), email.getTitulo(), email.getConteudo())).collect(Collectors.toList());
    }


}
