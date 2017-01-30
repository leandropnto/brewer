package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.model.Cidade;
import br.com.leandro.brewer.repository.Cidades;
import br.com.leandro.brewer.repository.Estados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lpinto on 01/09/2016.
 */
@Controller
@RequestMapping("/cidades")
public class CidadesController {

    private Estados estados;
    private Cidades cidades;

    @Autowired
    public CidadesController(Estados estados, Cidades cidades) {
        this.estados = estados;
        this.cidades = cidades;
    }

    @RequestMapping("/novo")
    public String novo() {
        return "cidade/CadastroCidade";
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    List<Cidade> pesquisarPorCodigoEstado(
            @RequestParam(name = "estado", defaultValue = "-1") Integer codigo) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        return cidades.findByEstadoCodigo(codigo);
    }
}
