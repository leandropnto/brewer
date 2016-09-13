package br.com.leandro.brewer.repository.helper.cerveja;

import br.com.leandro.brewer.model.Cerveja;
import br.com.leandro.brewer.repository.filter.CervejaFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by lpinto on 13/09/2016.
 */
public interface CervejasQueries {

    List<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);
}
