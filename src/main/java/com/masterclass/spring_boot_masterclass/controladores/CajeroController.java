package com.masterclass.spring_boot_masterclass.controladores;

import com.masterclass.spring_boot_masterclass.componentes.ContadorRequest;
import com.masterclass.spring_boot_masterclass.componentes.ContadorSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CajeroController {
    public final ContadorSession contadorSession;
    public final ContadorRequest contadorRequest;
    public CajeroController(ContadorRequest contadorRequest, ContadorSession contadorSession){
        this.contadorRequest = contadorRequest;
        this.contadorSession = contadorSession;
    }

    @GetMapping("/visitar")
    public String visitarTienda() {
        int req = contadorRequest.incrementarYObtener();
        int ses = contadorSession.incrementarYObtener();

        return "(DevTools funciona!) Valor Request: " + req + " | Valor Session: " + ses;
    }
}
