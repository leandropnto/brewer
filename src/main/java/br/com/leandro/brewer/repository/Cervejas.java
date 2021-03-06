package br.com.leandro.brewer.repository;

import br.com.leandro.brewer.model.Cerveja;
import br.com.leandro.brewer.repository.helper.cerveja.CervejasQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Leandro on 02/09/2016.
 */
@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>, CervejasQueries{

    Optional<Cerveja> findBySkuIgnoreCase(String sku);
}
