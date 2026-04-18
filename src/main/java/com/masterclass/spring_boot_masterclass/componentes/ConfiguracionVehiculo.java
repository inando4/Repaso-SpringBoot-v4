package com.masterclass.spring_boot_masterclass.componentes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionVehiculo {
    @Bean
    public Radio miRadio(){
        return new Radio();
    }
}
