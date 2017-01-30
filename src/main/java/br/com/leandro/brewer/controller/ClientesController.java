package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.model.TipoPessoa;
import br.com.leandro.brewer.repository.Estados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lpinto on 01/09/2016.
 */
@Controller
@RequestMapping("/clientes")
public class ClientesController {


    private Estados estados;

    @Autowired
    public ClientesController(Estados estados) {
        this.estados = estados;
    }

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView view = new ModelAndView("cliente/CadastroCliente");
        view.addObject("tipos", TipoPessoa.values());
        view.addObject("estados", estados.findAll());
        return view;
    }
}
