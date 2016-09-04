package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.model.Cerveja;
import br.com.leandro.brewer.model.Origem;
import br.com.leandro.brewer.model.Sabor;
import br.com.leandro.brewer.repository.Cervejas;
import br.com.leandro.brewer.repository.Estilos;
import br.com.leandro.brewer.service.CadastroCervejaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Classe responsável por controlar as requisições para o resource cervejas
 * Created by leandro on 31/08/2016.
 */
@Controller
public class CervejasController {

    private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);
    private final CadastroCervejaService cadastroCervejaService;
    private final Cervejas cervejas;
    private final Estilos estilos;

    @Autowired
    public CervejasController(CadastroCervejaService cadastroCervejaService, Cervejas cervejas, Estilos estilos) {
        this.cadastroCervejaService = cadastroCervejaService;
        this.cervejas = cervejas;
        this.estilos = estilos;
    }

    @RequestMapping("/cervejas/novo")
    public ModelAndView novo(Cerveja cerveja) {
        final ModelAndView view = new ModelAndView("cerveja/CadastroCerveja");
        view.addObject("sabores", Sabor.values());
        view.addObject("estilos", estilos.findAll());
        view.addObject("origens", Origem.values());

        return view;
    }

    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(cerveja);
        }

        cadastroCervejaService.salvar(cerveja);
        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
        return new ModelAndView("redirect:/cervejas/novo");
    }


}
