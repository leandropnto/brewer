package br.com.leandro.brewer.service.event.cerveja;

import br.com.leandro.brewer.model.Cerveja;
import org.springframework.util.StringUtils;

/**
 * Created by Leandro on 12/09/2016.
 */
public class CervejaSalvaEvent {

    private final Cerveja cerveja;

    public CervejaSalvaEvent(Cerveja cerveja) {
        this.cerveja = cerveja;
    }

    public Cerveja getCerveja() {
        return cerveja;
    }

    public boolean temFoto(){
        return !StringUtils.isEmpty(cerveja.getFoto());
    }
}
