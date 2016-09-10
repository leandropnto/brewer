package br.com.leandro.brewer.storage.local;

import br.com.leandro.brewer.storage.FotoStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Leandro on 10/09/2016.
 */
public class FotoStorageLocal implements FotoStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(FotoStorageLocal.class);

    private Path local;
    private Path localTemporario;
    private static final String HOME = System.getenv("HOME") != null ? System.getenv("HOME") : System.getenv("HOMEPATH");

    public FotoStorageLocal() {
        this(FileSystems.getDefault().getPath(HOME, ".brewerfotos"));
    }

    public FotoStorageLocal(Path local) {
        this.local = local;
        criarPastas();
    }

    private void criarPastas() {
        try {
            Files.createDirectories(local);
            localTemporario = FileSystems.getDefault().getPath(this.local.toString(), "temp");
            Files.createDirectories(localTemporario);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Pastas criadas para salvar fotos.");
                LOGGER.debug("Pasta default: " + local.toAbsolutePath());
                LOGGER.debug("Pasta temporário: " + localTemporario.toAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro criando pastas para salvar fotos", e);
        }


    }

    @Override
    public void salvarTemporariamente(MultipartFile[] files) {
        LOGGER.info("Salvando a foto temporariamente");
    }
}
