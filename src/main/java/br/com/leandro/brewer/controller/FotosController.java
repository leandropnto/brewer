package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.storage.FotosStorageRunnable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Leandro on 07/09/2016.
 */
@RestController
@RequestMapping("/fotos")
public class FotosController {

    @PostMapping
    public DeferredResult<String> upload(@RequestParam("files[]") MultipartFile[] files){
        DeferredResult<String> resultado = new DeferredResult<>();

        Thread thread = new Thread(new FotosStorageRunnable(files, resultado));
        thread.start();

        return resultado;
    }
}
