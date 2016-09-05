package br.com.leandro.brewer.service.exception;

/**
 * Created by lpinto on 05/09/2016.
 */
public class NomeEstiloJaCadastradoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NomeEstiloJaCadastradoException(String message) {
        super(message);
    }
}
