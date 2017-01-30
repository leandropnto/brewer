package br.com.leandro.brewer.repository;

import br.com.leandro.brewer.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Leandro on 29/01/2017.
 */
@Repository
public interface Estados extends JpaRepository<Estado, Integer> {
}
