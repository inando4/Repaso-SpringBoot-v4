package com.masterclass.utilidades_externas;

import org.springframework.stereotype.Component;

@Component
public class ImpresoraLog {
    public void imprimir(String mensaje){
        System.out.println("LOG EXTERNO: " + mensaje);
    }
}
