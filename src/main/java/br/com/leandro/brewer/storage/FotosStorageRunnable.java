package br.com.leandro.brewer.storage;

import br.com.leandro.brewer.controller.FotosController;
import br.com.leandro.brewer.dto.FotoDTO;
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
    private final DeferredResult<FotoDTO> resultado;
    private final FotoStorage storage;

    public FotosStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> resultado, FotoStorage storage) {
        this.files = files;
        this.resultado = resultado;
        this.storage = storage;
    }

    @Override
    public void run() {
        final String nomeArquivo = storage.salvarTemporariamente(files);
        final String contentType = files[0].getContentType();

        resultado.setResult(new FotoDTO(nomeArquivo, contentType));
    }
}
