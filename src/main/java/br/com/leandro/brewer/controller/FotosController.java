package br.com.leandro.brewer.controller;

import br.com.leandro.brewer.dto.FotoDTO;
import br.com.leandro.brewer.storage.FotoStorage;
import br.com.leandro.brewer.storage.FotosStorageRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Leandro on 07/09/2016.
 */
@RestController
@RequestMapping("/fotos")
public class FotosController {

    private final FotoStorage storage;

    @Autowired
    public FotosController(FotoStorage storage) {
        this.storage = storage;
    }

    @PostMapping
    public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files){
        DeferredResult<FotoDTO> resultado = new DeferredResult<>();

        Thread thread = new Thread(new FotosStorageRunnable(files, resultado, storage));
        thread.start();

        return resultado;
    }

    @GetMapping("/temp/{nome:.*}")
    public byte[] recuperarFotoTemporaria(@PathVariable String nome){
        return storage.recuperarFotoTemporaria(nome);
    }


    @GetMapping("/{nome:.*}")
    public byte[] recuperarFoto(@PathVariable String nome){
        return storage.recuperar(nome);
    }
}
