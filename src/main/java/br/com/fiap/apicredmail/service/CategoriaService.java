package br.com.fiap.apicredmail.service;

import br.com.fiap.apicredmail.dto.CategoriaDTO;
import br.com.fiap.apicredmail.model.CategoriaCardsModel;
import br.com.fiap.apicredmail.model.UsuarioModel;

import java.util.List;

public interface CategoriaService {
    public CategoriaCardsModel salvarCategoria(CategoriaDTO categoriaDTO, UsuarioModel usuarioModel);
    public List<CategoriaDTO> listarCategoriaHome(Long id);
}
