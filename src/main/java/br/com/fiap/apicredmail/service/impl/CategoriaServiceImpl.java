package br.com.fiap.apicredmail.service.impl;

import br.com.fiap.apicredmail.dto.CategoriaDTO;
import br.com.fiap.apicredmail.model.CategoriaCardsModel;
import br.com.fiap.apicredmail.model.UsuarioModel;
import br.com.fiap.apicredmail.repository.CategoriaRepository;
import br.com.fiap.apicredmail.service.CategoriaService;
import br.com.fiap.apicredmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    EmailService emailService;
    @Override
    public CategoriaCardsModel salvarCategoria(CategoriaDTO categoriaDTO, UsuarioModel usuarioModel) {
        return categoriaRepository.save(new CategoriaCardsModel(null,categoriaDTO.categoria(),categoriaDTO.imagem(),categoriaDTO.corImagem(),categoriaDTO.corTexto(), usuarioModel));
    }

    @Override
    public List<CategoriaDTO> listarCategoriaHome(Long id) {
        List<CategoriaCardsModel> categoriaDTOList = categoriaRepository.findByUsuarioModelId(id);
        return categoriaDTOList.
                stream().
                map(categoria -> new CategoriaDTO(
                        categoria.getId(),
                        categoria.getCategoria(),
                        categoria.getImagem(),
                        categoria.getCorimagem(),
                        categoria.getCorTexto())).
                collect(Collectors.toList());

    }
}
