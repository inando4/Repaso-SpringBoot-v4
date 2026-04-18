package com.masterclass.spring_boot_masterclass.componentes.agencia;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CuartelGeneral {
    @Value("${agencia.nombre}")
    String nombreAgencia;
    AgenteSecreto agenteSecreto;

    public CuartelGeneral(AgenteSecreto agenteSecreto){
        this.agenteSecreto = agenteSecreto;
    }

    public void asignarMision(String mision){
        System.out.println("El cuartel " + nombreAgencia + " asigna la misión: " + mision);
    }

}
