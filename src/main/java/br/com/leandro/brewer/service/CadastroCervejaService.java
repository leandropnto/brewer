package br.com.leandro.brewer.service;

import br.com.leandro.brewer.model.Cerveja;
import br.com.leandro.brewer.repository.Cervejas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Leandro on 03/09/2016.
 */
@Service
public class CadastroCervejaService {

    private final Cervejas cervejas;

    @Autowired
    public CadastroCervejaService(Cervejas cervejas) {
        this.cervejas = cervejas;
    }

    @Transactional
    public void salvar(Cerveja cerveja){
        cervejas.save(cerveja);
    }
}
