package br.com.fiap.apicredmail.service.impl;

import br.com.fiap.apicredmail.dto.HomeDTO;
import br.com.fiap.apicredmail.service.CategoriaService;
import br.com.fiap.apicredmail.service.EmailService;
import br.com.fiap.apicredmail.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    EmailService emailService;

    @Override
    public HomeDTO abrirHome(Long id) {
        return new HomeDTO(categoriaService.listarCategoriaHome(id),emailService.listEmailHome(id));
    }
}
