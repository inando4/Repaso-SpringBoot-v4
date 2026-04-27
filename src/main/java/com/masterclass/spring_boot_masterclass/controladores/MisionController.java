package com.masterclass.spring_boot_masterclass.controladores;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/misiones")
public class MisionController {
    @GetMapping
    public String leerMisiones(){
        return "Obteniendo lista de misiones";
    }

    @PostMapping
    public String crearMision(){
        return "Misión Creada exitosamente";
    }

    @PutMapping
    public String Actualizar(){
        return "Misión reemplazada por completo";
    }

    @PatchMapping
    public String actualizacionParcial(){
        return "Estado de misión actualizado";
    }

    @DeleteMapping
    public String eliminarMisiones(){
        return "Misión eliminada del registro";
    }
}
