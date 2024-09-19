package br.com.fiap.apicredmail.repository;

import br.com.fiap.apicredmail.model.EntradaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailEntradaRepository extends JpaRepository<EntradaModel, Long> {
    public List<EntradaModel> findByUsuarioModelId(Long id);
}
