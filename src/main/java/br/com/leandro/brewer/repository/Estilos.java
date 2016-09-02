package br.com.leandro.brewer.repository;

import br.com.leandro.brewer.model.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lpinto on 02/09/2016.
 */
@Repository
public interface Estilos extends JpaRepository<Estilo,Long> {
}
