package com.example.assignment1.config;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

//@Configuration
//@EnableJpaRepositories("com.example.assignment1.repository")
//@EnableSpringDataWebSupport
public class WebMvcConfiguration implements WebMvcConfigurer {
/*

    private final AbstractApplicationContext applicationContext;

    @Autowired
    public WebMvcConfiguration(AbstractApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new SpecificationArgumentResolver());
    }
*/

}
