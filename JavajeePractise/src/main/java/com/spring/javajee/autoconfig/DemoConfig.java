package com.spring.javajee.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.spring.javajee")
@ImportResource(locations = "classpath:applicationContext.xml")
public class DemoConfig {

	@Bean (name = "jjwriter")
    public JJWriter getJJWriter()
    {
        return new JJWriter();
    }
}
