package com.braimatics.training;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
public class KonfigurasiWeb  extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
    
    @Bean
    public JasperReportsViewResolver jasperResolver(){
        JasperReportsViewResolver resolver = new JasperReportsViewResolver();
        
        resolver.setViewClass(JasperReportsMultiFormatView.class);
        resolver.setOrder(0); // cari template jasper dulu, kalau tidak ketemu, baru cari template thymeleaf
        resolver.setViewNames("report/*");
        resolver.setPrefix("classpath:/");
        resolver.setSuffix(".jrxml");
        resolver.setReportDataKey("dataDalamReport");
        
        return resolver;
    }
}
