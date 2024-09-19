package br.com.fiap.apicredmail.service;

import br.com.fiap.apicredmail.dto.EmailCadastroDTO;
import br.com.fiap.apicredmail.dto.EmailDTO;
import br.com.fiap.apicredmail.dto.SaidaDTOReq;
import br.com.fiap.apicredmail.model.SaidaDTORes;
import br.com.fiap.apicredmail.model.UsuarioModel;

import java.util.List;

public interface EmailService {
    public void cadastraEmail(EmailCadastroDTO emailDTO, Long categoria, UsuarioModel usuarioModel);
    public List<EmailDTO> listEmailHome(Long id);
    public EmailDTO buscaEmail(Long id);

    public void salvarEmailSaida(SaidaDTOReq req);

    public List<SaidaDTORes> buscarEmailEnviado(Long id);

}
