package com.masterclass.spring_boot_masterclass.componentes.agencia;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditoriaAspecto {
    @Before("execution(* com.masterclass.spring_boot_masterclass.componentes.agencia.CuartelGeneral.asignarMision(..))")
    public void antesDeAsignar(){
        System.out.println("[TOP SECRET] Registrando acceso a información clasificada...");
    }
}
