package br.com.leandro.brewer.controller.handler;

import br.com.leandro.brewer.service.exception.NomeEstiloJaCadastradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe responsável por tratar os erros (exceptions) no site.
 * Created by Leandro on 06/09/2016.
 */
@ControllerAdvice
public class ControllerAdviceExceptionHandler {

    @ExceptionHandler(NomeEstiloJaCadastradoException.class)
    public ResponseEntity<String> handleNomeEstiloJaCadastradoException(NomeEstiloJaCadastradoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
