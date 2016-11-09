package br.com.leandro.brewer.repository.helper.cerveja;

import br.com.leandro.brewer.model.Cerveja;
import br.com.leandro.brewer.repository.filter.CervejaFilter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by lpinto on 13/09/2016.
 */
public class CervejasImpl implements CervejasQueries {

    @PersistenceContext
    EntityManager manager;

    @Override
    @Transactional(readOnly = true)
    public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable) {
        final Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class);

        int totalRegistrosPorPagina = pageable.getPageSize();
        int paginaAtual = pageable.getPageNumber();

        criteria.setFirstResult(paginaAtual * totalRegistrosPorPagina);
        criteria.setMaxResults(totalRegistrosPorPagina);

        Sort sort = pageable.getSort();
        if (sort != null){
            final Sort.Order order = sort.iterator().next();
            final String property = order.getProperty();
            criteria.addOrder(order.isAscending() ? Order.asc(property) : Order.desc(property));
        }

        adicionarFiltro(filtro, criteria);


        return new PageImpl<>( criteria.list(),pageable, total(filtro));
    }

    private Long total(CervejaFilter filtro) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class);
        adicionarFiltro(filtro, criteria);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    private void adicionarFiltro(CervejaFilter filtro, Criteria criteria) {
        if (filtro != null) {
            if (!StringUtils.isEmpty(filtro.getSku())) {
                criteria.add(Restrictions.eq("sku", filtro.getSku()));
            }

            if (!StringUtils.isEmpty(filtro.getNome())) {
                criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
            }

            if (isEstiloPresente(filtro)) {
                criteria.add(Restrictions.eq("estilo", filtro.getEstilo()));
            }

            if (filtro.getSabor() != null) {
                criteria.add(Restrictions.eq("sabor", filtro.getSabor()));
            }

            if (filtro.getOrigem() != null) {
                criteria.add(Restrictions.eq("origem", filtro.getOrigem()));
            }

            if (filtro.getValorDe() != null) {
                criteria.add(Restrictions.ge("valor", filtro.getValorDe()));
            }

            if (filtro.getValorAte() != null) {
                criteria.add(Restrictions.le("valor", filtro.getValorAte()));
            }
        }
    }

    private boolean isEstiloPresente(CervejaFilter filtro) {
        return  filtro.getEstilo() != null && filtro.getEstilo().getCodigo() != null;
    }
}