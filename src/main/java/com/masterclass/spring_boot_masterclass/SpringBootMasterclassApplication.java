package com.masterclass.spring_boot_masterclass;
import com.masterclass.spring_boot_masterclass.componentes.Coche;
import com.masterclass.spring_boot_masterclass.componentes.Radio;
import com.masterclass.spring_boot_masterclass.componentes.agencia.CuartelGeneral;
import com.masterclass.utilidades_externas.ImpresoraLog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.masterclass.spring_boot_masterclass", "com.masterclass.utilidades_externas"})
public class SpringBootMasterclassApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMasterclassApplication.class, args);
    }

    // Este @Bean le dice a Spring que ejecute este código justo al arrancar la aplicación
    /*
    /*@Bean
    CommandLineRunner probandoTodo(Coche miCoche, Radio miRadio) {
        return args -> {
            System.out.println("--- INICIANDO PRUEBA ---");
            miCoche.arrancar();
            miRadio.tocarMusica();
            System.out.println("--- FIN DE LA PRUEBA ---");
        };
    }*/
    /*
    @Bean
    CommandLineRunner pruebaFinal(CuartelGeneral cuartelGeneral, ImpresoraLog impresora){
        return args -> {
            cuartelGeneral.asignarMision("Recuperar el disco duro");
            impresora.imprimir("Iniciando sistema");
        };
    }
     */


}

