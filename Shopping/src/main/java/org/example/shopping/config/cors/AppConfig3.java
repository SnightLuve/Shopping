package org.example.shopping.config.cors;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class AppConfig3 {
//    @Bean
//    public FilterRegistrationBean<CorsFilter> corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        //config.addAllowedOrigin("http://localhost:8080");
//        config.addAllowedOrigin(List.of("http://localhost:8080").toString());
//        config.addAllowedMethod("*");
//        config.addAllowedHeader("*");
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
//        //bean.setOrder(0);
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return bean;
//    }
}
