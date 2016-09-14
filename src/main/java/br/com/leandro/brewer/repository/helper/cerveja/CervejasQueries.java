package br.com.leandro.brewer.repository.helper.cerveja;

import br.com.leandro.brewer.model.Cerveja;
import br.com.leandro.brewer.repository.filter.CervejaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by lpinto on 13/09/2016.
 */
public interface CervejasQueries {

    Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);
}
