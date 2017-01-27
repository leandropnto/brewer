package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.controller.page.PageWrapper;
import br.com.leandro.brewer.model.Estilo;
import br.com.leandro.brewer.model.Origem;
import br.com.leandro.brewer.repository.Estilos;
import br.com.leandro.brewer.repository.filter.EstiloFilter;
import br.com.leandro.brewer.service.CadastroEstiloService;
import br.com.leandro.brewer.service.exception.NomeEstiloJaCadastradoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Leandro on 01/09/2016.
 */
@Controller
@RequestMapping("/estilos")
public class EstilosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstilosController.class);
    private final CadastroEstiloService servico;
    private Estilos estilos;

    @Autowired
    public EstilosController(CadastroEstiloService servico, Estilos estilos) {
        this.servico = servico;
        this.estilos = estilos;
    }


    @GetMapping
    public ModelAndView pesquisar(EstiloFilter estiloFilter, BindingResult result,
                                  @PageableDefault(size = 2) Pageable pageable,
                                  HttpServletRequest request){
        ModelAndView view = new ModelAndView("estilo/PesquisaEstilos");

        view.addObject("pagina", new PageWrapper<>(estilos.filtrar(estiloFilter, pageable),request));

        return view;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/novo")
    public ModelAndView novo(Estilo estilo) {
        final ModelAndView view = new ModelAndView("estilo/CadastroEstilo");
        if (LOGGER.isDebugEnabled()) {
            servico.getEstilos().findAll().stream().forEach(e -> LOGGER.debug(e.getNome()));
        }
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/novo")
    public ModelAndView salvar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(estilo);
        }

        try {
            servico.salvar(estilo);
        } catch (NomeEstiloJaCadastradoException e) {
            result.rejectValue("nome", e.getMessage(), e.getMessage());
            return novo(estilo);
        }
        attributes.addFlashAttribute("mensagem", "Estilo cadastrado com sucesso.");
        return new ModelAndView("redirect:/estilos");

    }

    @RequestMapping(value = "/salvarrapido", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    ResponseEntity<?> salvarRapido(@RequestBody @Valid Estilo estilo, BindingResult result) {
        LOGGER.info("Estilo: " + estilo.getNome());
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
        }

        estilo = servico.salvar(estilo);

        return ResponseEntity.ok(estilo);
    }


}
