package br.com.leandro.brewer.service;

import br.com.leandro.brewer.model.Cerveja;
import br.com.leandro.brewer.repository.Cervejas;
import br.com.leandro.brewer.service.event.cerveja.CervejaSalvaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Leandro on 03/09/2016.
 */
@Service
public class CadastroCervejaService {

    private final Cervejas cervejas;
    private final ApplicationEventPublisher publisher;

    @Autowired
    public CadastroCervejaService(Cervejas cervejas,
                                  ApplicationEventPublisher publisher) {
        this.cervejas = cervejas;
        this.publisher = publisher;
    }

    @Transactional
    public void salvar(Cerveja cerveja) {
        cervejas.save(cerveja);
        publisher.publishEvent(new CervejaSalvaEvent(cerveja));
    }
}
