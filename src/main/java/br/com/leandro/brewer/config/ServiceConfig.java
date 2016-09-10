package br.com.leandro.brewer.config;

import br.com.leandro.brewer.service.CadastroCervejaService;
import br.com.leandro.brewer.storage.FotoStorage;
import br.com.leandro.brewer.storage.local.FotoStorageLocal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Leandro on 03/09/2016.
 */
@Configuration
@ComponentScan(basePackageClasses = {CadastroCervejaService.class})
public class ServiceConfig {

    @Bean
    public FotoStorage fotoStorage(){
        return new FotoStorageLocal();
    }
}
