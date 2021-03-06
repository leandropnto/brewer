package br.com.leandro.brewer.config;

import br.com.leandro.brewer.controller.CervejasController;
import br.com.leandro.brewer.controller.converter.EstiloConverter;
import br.com.leandro.brewer.thymeleaf.BrewerDialect;
import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.math.BigDecimal;

/**
 * Created by Leandro on 31/08/2016.
 */
@Configuration
@ComponentScan(basePackageClasses = {CervejasController.class})
@EnableWebMvc
@EnableSpringDataWebSupport
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * Spring chama esse método após terminar de carregar o contexto! Assim, fica disponível o applicationContext
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * Método que configura o viewResolver, ou seja, ensisa ao spring qual tecnologia de view utilizar
     *
     * @return ViewResolver
     */
    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    /**
     * Método que configura a tecnologia de template
     *
     * @return TemplateEngine
     */
    @Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        engine.addDialect(new LayoutDialect());
        engine.addDialect(new BrewerDialect());
        engine.addDialect(new DataAttributeDialect());
        return engine;
    }

    /**
     * Método que configura o resolver de templates, ou seja, aonde os arquivos HTML vão ficar.
     *
     * @return ITemplateResolver
     */
    private ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCacheTTLMs(0L);//desliga o cache do thymeleaf! da tilt com o intelliJ em desenv
        return resolver;
    }

    /**
     * Método que configura o spring para procurar os arquivos estáticos da aplicação
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public FormattingConversionService mvcConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new EstiloConverter());

        NumberStyleFormatter bigDecimalFormatter = new NumberStyleFormatter("#,##0.00");
        conversionService.addFormatterForFieldType(BigDecimal.class, bigDecimalFormatter);

        NumberStyleFormatter integerFormatter = new NumberStyleFormatter("#,##0");
        conversionService.addFormatterForFieldType(Integer.class, integerFormatter);

        return conversionService;
    }
}
