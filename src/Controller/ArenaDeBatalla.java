package Controller;

import Model.Criaturas.Factory.Criatura;

public class ArenaDeBatalla {

    // - Bucle de turnos alternos hasta que una criatura quede sin vida.
    // - Métodos auxiliares para mostrar estado y aplicar estrategias.

    public Criatura criatura1;
    public Criatura criatura2;

    public ArenaDeBatalla(Criatura criatura1, Criatura criatura2) {
        this.criatura1 = criatura1;
        this.criatura2 = criatura2;
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
        StringBuilder salida = new StringBuilder();
        salida.append("---------------------------------------------------------\n");
        salida.append("------------------- INICIA LA BATALLA -------------------\n");

        while (criatura1.estaViva() && criatura2.estaViva()) {

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
            salida.append("El ganador de esta batalla es: ").append(criatura1.getNombre());
        } else if (criatura1.estaViva() && !criatura2.estaViva()) {
            salida.append("El ganador de esta batalla es: ").append(criatura2.getNombre());
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
        salida.append("------------------- ESTADO ACTUAL -------------------\n");
        salida.append(criatura1.toString()).append("\n");
        salida.append(criatura2.toString()).append("\n");
        return salida.toString();

    }
}
