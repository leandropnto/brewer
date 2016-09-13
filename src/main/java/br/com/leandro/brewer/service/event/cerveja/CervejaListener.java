package br.com.leandro.brewer.service.event.cerveja;

import br.com.leandro.brewer.storage.FotoStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Leandro on 12/09/2016.
 */
@Component
public class CervejaListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CervejaListener.class);
    private final FotoStorage storage;

    @Autowired
    public CervejaListener(FotoStorage storage) {
        this.storage = storage;
    }

    @EventListener(condition = "#evento.temFoto() ")
    public void cervejaSalva(CervejaSalvaEvent evento){
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Nova cerveja salva: {}", evento.getCerveja().getNome());
        }

        storage.salvar(evento.getCerveja().getFoto());
    }
}
