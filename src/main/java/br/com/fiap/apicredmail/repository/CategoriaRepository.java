package br.com.fiap.apicredmail.repository;

import br.com.fiap.apicredmail.model.CategoriaCardsModel;
import br.com.fiap.apicredmail.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<CategoriaCardsModel, Long> {
    public List<CategoriaCardsModel> findByUsuarioModelId(Long id);
}
