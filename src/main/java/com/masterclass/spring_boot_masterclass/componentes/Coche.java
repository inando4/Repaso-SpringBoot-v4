package com.masterclass.spring_boot_masterclass.componentes;

import org.springframework.stereotype.Component;

@Component
public class Coche {
    private final Motor motorDerecho;
    private final Motor motorIzquierdo;

    public Coche(Motor motorDerecho, Motor motorIzquierdo){
        this.motorDerecho = motorDerecho;
        this.motorIzquierdo = motorIzquierdo;
    }

    public void arrancar(){
        System.out.println("Motor D: " + motorDerecho.hashCode());
        System.out.println("Motor I: " + motorIzquierdo.hashCode());
        motorDerecho.encender();
        motorIzquierdo.encender();
    }
}
