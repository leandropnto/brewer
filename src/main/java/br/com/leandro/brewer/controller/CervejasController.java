package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.model.Cerveja;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Classe responsável por controlar as requisições para o resource cervejas
 * Created by leandro on 31/08/2016.
 */
@Controller
public class CervejasController {

    private final String formulario = "cerveja/CadastroCerveja";

    @RequestMapping("/cervejas/novo")
    public String novo() {

        return formulario;
    }

    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
    public String cadastrar(Cerveja cerveja) {
        System.out.println(">>> sku: " + cerveja.getSku());
        return formulario;
    }
}
