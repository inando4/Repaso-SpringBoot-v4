package com.masterclass.spring_boot_masterclass.componentes;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ContadorSession {
    private int numero = 0;

    public int incrementarYObtener(){
        return ++numero;
    }
}
