package br.com.leandro.brewer.controller.converter;

import br.com.leandro.brewer.model.Estilo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * Created by Leandro on 03/09/2016.
 */
public class EstiloConverter implements Converter<String, Estilo> {


    @Override
    public Estilo convert(String codigo) {
        if (!StringUtils.isEmpty(codigo)) {
            final Estilo estilo = new Estilo();
            estilo.setCodigo(Long.valueOf(codigo));
            return estilo;

        }

        return null;
    }
}
