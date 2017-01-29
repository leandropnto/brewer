package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.model.TipoPessoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lpinto on 01/09/2016.
 */
@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView view = new ModelAndView("cliente/CadastroCliente");
        view.addObject("tipos", TipoPessoa.values());
        return view;
    }
}
