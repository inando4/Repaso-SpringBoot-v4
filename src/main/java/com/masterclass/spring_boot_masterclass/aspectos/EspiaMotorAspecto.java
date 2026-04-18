package com.masterclass.spring_boot_masterclass.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EspiaMotorAspecto {
    @Before("execution(* com.masterclass.spring_boot_masterclass.componentes.Motor.encender(..))")
    public void antesDeEncender() {
        System.out.println("🕵️‍♂️ [AOP ANTES] ¡Alerta! Alguien va a intentar encender el motor...");
    }

    @After("execution(* com.masterclass.spring_boot_masterclass.componentes.Motor.encender(..))")
    public void despuesDeEncender() {
        System.out.println("🕵️‍♂️ [AOP DESPUÉS] El proceso de encendido del motor ha concluido.");
    }
}
