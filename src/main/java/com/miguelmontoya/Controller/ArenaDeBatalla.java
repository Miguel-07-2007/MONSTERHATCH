package com.miguelmontoya.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;

public class ArenaDeBatalla {
    private static final Logger logger = LogManager.getLogger(ArenaDeBatalla.class);
    private Criatura criatura1;
    private Criatura criatura2;

    // - Bucle de turnos alternos hasta que una criatura quede sin vida.
    // - Métodos auxiliares para mostrar estado y aplicar estrategias.

    private static final ArenaDeBatalla INSTANCIA = new ArenaDeBatalla();

    private ArenaDeBatalla() {
    }

    public static ArenaDeBatalla getInstancia() {
        return INSTANCIA;
    }

    /*
     * El método para iniciar La batalla requiere revisión en el manejo de la
     * verificación de vida de las criaturas, y en la aplicación de efectos y
     * estrategias.
     * Se recomienda revisar la lógica de turnos y la aplicación de efectos para
     * asegurar que se refleje
     * correctamente el estado de las criaturas después de cada acción.
     */
    public String iniciarBatalla(Criatura criatura1, Criatura criatura2) {
        this.criatura1 = criatura1;
        this.criatura2 = criatura2;
        logger.info("Iniciando batalla entre {} y {}", criatura1.getNombre(), criatura2.getNombre());
        StringBuilder salida = new StringBuilder();
        salida.append("----------------------------------------------------------------------------------\n");
        salida.append("-------------------------------- INICIA LA BATALLA -------------------------------\n");
        int rounds = 1;
        
        while (criatura1.estaViva() && criatura2.estaViva()) {
            logger.debug("round #" + rounds);
            salida.append("\n------------------------------------ ROUND # " + rounds + " ------------------------------------\n");
            rounds++;
            // Turno criatura 1
            salida.append(criatura1.ejecutarAccion(criatura2)).append("\n");

            if (!criatura2.estaViva())
                break;

            // Turno criatura 2
            salida.append(criatura2.ejecutarAccion(criatura1)).append("\n");

            // Procesar efectos de criatura 1
            salida.append(criatura1.aplicarEfectos()).append("\n");

            if (!criatura1.estaViva())
                break;

            // Procesar efectos criatura 2
            salida.append(criatura2.aplicarEfectos()).append("\n");
            
        }

        if (!criatura1.estaViva() && criatura2.estaViva()) {
            salida.append("El ganador de esta batalla es: ").append(criatura2.getNombre());
            logger.info("ganador: " + criatura2.getNombre());
        } else if (criatura1.estaViva() && !criatura2.estaViva()) {
            salida.append("El ganador de esta batalla es: ").append(criatura1.getNombre());
            logger.info("Ganador: " + criatura1.getNombre());
        } else {
            salida.append("Ambos murieron, es un empate\n");

        }

        return salida.toString();
    }

    /*
     * Retorna el estado de la batalla en forma de String
     */
    public String mostrarEstado() {
        StringBuilder salida = new StringBuilder();
        salida.append("---------------------------------------------------------\n");
        salida.append("--------------------- ESTADO FINAL ----------------------\n");
        salida.append(criatura1.toString()).append("\n");
        salida.append(criatura2.toString()).append("\n");
        logger.info("Estado finla de las crituras:\n" + criatura1.toString() + "\n" + criatura2.toString());
        return salida.toString();

    }
}
