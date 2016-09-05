package br.com.leandro.brewer.repository;

import br.com.leandro.brewer.model.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Leandro on 02/09/2016.
 */
@Repository
public interface Estilos extends JpaRepository<Estilo,Long> {

    Optional<Estilo> findByNomeIgnoreCase(String nome);
}
