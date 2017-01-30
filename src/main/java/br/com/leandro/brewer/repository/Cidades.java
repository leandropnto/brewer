package br.com.leandro.brewer.repository;

import br.com.leandro.brewer.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Leandro on 30/01/2017.
 */
public interface Cidades extends JpaRepository<Cidade, Integer> {

    List<Cidade> findByEstadoCodigo(Integer codigo);
}
