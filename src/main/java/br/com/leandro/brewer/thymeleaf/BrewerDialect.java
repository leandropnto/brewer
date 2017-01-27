package br.com.leandro.brewer.thymeleaf;

import br.com.leandro.brewer.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.com.leandro.brewer.thymeleaf.processor.MessageElementTagProcessor;
import br.com.leandro.brewer.thymeleaf.processor.OrderElementTagProcessor;
import br.com.leandro.brewer.thymeleaf.processor.PaginationElementTagProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Leandro on 06/09/2016.
 */
public class BrewerDialect extends AbstractProcessorDialect {


    public BrewerDialect() {
        super("AlgaWorks Brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processadores = new HashSet<>(1);
        processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
        processadores.add(new MessageElementTagProcessor(dialectPrefix));
        processadores.add(new OrderElementTagProcessor(dialectPrefix));
        processadores.add(new PaginationElementTagProcessor(dialectPrefix));
        return processadores;
    }
}
