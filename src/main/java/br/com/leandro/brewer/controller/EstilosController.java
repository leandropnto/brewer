package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.model.Estilo;
import br.com.leandro.brewer.service.CadastroEstiloService;
import br.com.leandro.brewer.service.exception.NomeEstiloJaCadastradoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Leandro on 01/09/2016.
 */
@Controller
@RequestMapping("/estilos")
public class EstilosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstilosController.class);
    private final CadastroEstiloService estilos;

    @Autowired
    public EstilosController(CadastroEstiloService estilos) {
        this.estilos = estilos;
    }

    @RequestMapping()
    public ModelAndView novo(Estilo estilo) {
        final ModelAndView view = new ModelAndView("estilo/CadastroEstilo");
        if (LOGGER.isDebugEnabled()) {
            estilos.getEstilos().findAll().stream().forEach(e -> LOGGER.debug(e.getNome()));
        }
        return view;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(estilo);
        }

        try {
            estilos.salvar(estilo);
        } catch (NomeEstiloJaCadastradoException e) {
            result.rejectValue("nome", e.getMessage(), e.getMessage());
            return novo(estilo);
        }
        attributes.addFlashAttribute("mensagem", "Estilo cadastrado com sucesso.");
        return new ModelAndView("redirect:/estilos");

    }


}
