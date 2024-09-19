package br.com.fiap.apicredmail.repository;

import br.com.fiap.apicredmail.model.SaidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailSaidaRepository extends JpaRepository<SaidaModel,Long> {
    public List<SaidaModel> findByUsuarioModelIdAndSpam(Long aLong, Boolean spam);
    public List<SaidaModel> findByUsuarioModelIdAndPara(Long id, String para);
}
