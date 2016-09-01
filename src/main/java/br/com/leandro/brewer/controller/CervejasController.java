package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.model.Cerveja;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Classe responsável por controlar as requisições para o resource cervejas
 * Created by leandro on 31/08/2016.
 */
@Controller
public class CervejasController {

    private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);

    @RequestMapping("/cervejas/novo")
    public String novo(Cerveja cerveja) {
        logger.error("cerveja/CadastroCerveja");
        String formulario = "cerveja/CadastroCerveja";
        return formulario;
    }

    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
    public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(cerveja);
        }

        System.out.println(">>> sku: " + cerveja.getSku());
        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso.");
        return "redirect:/cervejas/novo";
    }


}
