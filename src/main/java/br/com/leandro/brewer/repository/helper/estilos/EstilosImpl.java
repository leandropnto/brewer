package br.com.leandro.brewer.repository.helper.estilos;

import br.com.leandro.brewer.model.Estilo;
import br.com.leandro.brewer.repository.filter.EstiloFilter;
import br.com.leandro.brewer.repository.paginacao.PaginacaoHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Leandro on 27/01/2017.
 */
public class EstilosImpl implements EstilosQueries {

    @PersistenceContext
    EntityManager manager;

    private final PaginacaoHelper paginacaoHelper;

    @Autowired
    public EstilosImpl(PaginacaoHelper paginacaoHelper) {
        this.paginacaoHelper = paginacaoHelper;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable) {
        final Criteria criteria = manager.unwrap(Session.class).createCriteria(Estilo.class);


        paginacaoHelper.preparar(criteria, pageable);

        adicionarFiltro(filtro, criteria);


        return new PageImpl<>( criteria.list(),pageable, total(filtro));
    }
    private Long total(EstiloFilter filtro) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Estilo.class);
        adicionarFiltro(filtro, criteria);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    private void adicionarFiltro(EstiloFilter filtro, Criteria criteria) {
        if (filtro != null) {
            if (!StringUtils.isEmpty(filtro.getNome())) {
                criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
            }

        }
    }
}
