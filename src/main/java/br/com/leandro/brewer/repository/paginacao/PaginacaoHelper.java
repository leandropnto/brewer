package br.com.leandro.brewer.repository.paginacao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * Created by Leandro on 27/01/2017.
 */
@Component
public class PaginacaoHelper {


    public void preparar(Criteria criteria, Pageable pageable) {
        int totalRegistrosPorPagina = pageable.getPageSize();
        int paginaAtual = pageable.getPageNumber();

        criteria.setFirstResult(paginaAtual * totalRegistrosPorPagina);
        criteria.setMaxResults(totalRegistrosPorPagina);

        Sort sort = pageable.getSort();
        if (sort != null) {
            final Sort.Order order = sort.iterator().next();
            final String property = order.getProperty();
            criteria.addOrder(order.isAscending() ? Order.asc(property) : Order.desc(property));
        }
    }
}
