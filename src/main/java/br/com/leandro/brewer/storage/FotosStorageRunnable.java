package br.com.leandro.brewer.storage;

import br.com.leandro.brewer.controller.FotosController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Leandro on 07/09/2016.
 */
public class FotosStorageRunnable implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(FotosController.class);

    private final MultipartFile[] files;
    private final DeferredResult<String> resultado;

    public FotosStorageRunnable(MultipartFile[] files, DeferredResult<String> resultado) {
        this.files = files;
        this.resultado = resultado;
    }

    @Override
    public void run() {
        LOGGER.debug("files>>> " + files[0].getSize());
        //TODO: Salvar a foto no sistema de arquivos
        resultado.setResult("OK! Foto recebida");
    }
}
