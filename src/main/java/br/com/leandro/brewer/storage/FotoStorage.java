package br.com.leandro.brewer.storage;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Leandro on 10/09/2016.
 */
public interface FotoStorage {

    String salvarTemporariamente(MultipartFile[] files);
}
