package br.com.leandro.brewer.service;

import br.com.leandro.brewer.model.Estilo;
import br.com.leandro.brewer.repository.Estilos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Leandro on 05/09/2016.
 */
@Service
public class CadastroEstiloService {


    private final Estilos estilos;

    @Autowired
    public CadastroEstiloService(Estilos estilos) {
        this.estilos = estilos;
    }

    @Transactional
    public void salvar(Estilo estilo){
        estilos.save(estilo);
    }

    public Estilos getEstilos() {
        return estilos;
    }
}
