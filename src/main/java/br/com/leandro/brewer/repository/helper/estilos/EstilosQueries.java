package br.com.leandro.brewer.repository.helper.estilos;

import br.com.leandro.brewer.model.Estilo;
import br.com.leandro.brewer.repository.filter.EstiloFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Leandro on 27/01/2017.
 */
public interface EstilosQueries {

    Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);
}
