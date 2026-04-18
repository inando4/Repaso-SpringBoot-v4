package com.masterclass.spring_boot_masterclass.componentes;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Motor {
    public void encender() {
        System.out.println("El motor está encendido");
    }
    @PostConstruct
    public void inicializacion(){
        System.out.println("Motor construido y listo para funcionar");
    }

    //Spring no detecta los preDestroy cuando es de scope prototype
    @PreDestroy
    public void destruccion(){
        System.out.println("Apagando el motor de forma segura y liberando recursos");
    }
}
