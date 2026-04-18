package com.masterclass.spring_boot_masterclass.componentes.agencia;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AgenteSecreto {

    @PostConstruct
    public void iniciar() {
        System.out.println("Agente reclutado y entrenado");
    }

}
