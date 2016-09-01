package br.com.leandro.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lpinto on 01/09/2016.
 */
@Controller
@RequestMapping("/cidades")
public class CidadesController {

    @RequestMapping("/novo")
    public String novo(){
        return "cidade/CadastroCidade";
    }
}
