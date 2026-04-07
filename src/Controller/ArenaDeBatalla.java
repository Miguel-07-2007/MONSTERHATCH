package Controller;

import Model.Criaturas.Factory.Criatura;

public class ArenaDeBatalla {

//  - Atributos para las dos criaturas.
//   - Un método para iniciar la batalla.
//   - Bucle de turnos alternos hasta que una criatura quede sin vida.
//   - Métodos auxiliares para mostrar estado y aplicar estrategias.

    public Criatura criatura1;
    public Criatura criatura2;

    public ArenaDeBatalla(Criatura criatura1, Criatura criatura2) {
        this.criatura1 = criatura1;
        this.criatura2 = criatura2;
    }

    public String iniciarBatalla(Criatura criatura1, Criatura criatura2) {
        StringBuilder salida = new StringBuilder();
        salida.append("-------------------------------------------------------\n");
        salida.append("------------- SE DEJÓ VENIR ESTO -------------------\n");

        while (criatura1.estaViva() && criatura2.estaViva()) {
            salida.append(criatura1.ejecutarAccion(criatura2)).append("\n");
            salida.append(criatura2.ejecutarAccion(criatura1)).append("\n");
            salida.append(criatura1.aplicarEfectos()).append("\n");
            salida.append(criatura2.aplicarEfectos()).append("\n");
        }

        String estado = criatura1.estaViva() + "-" + criatura2.estaViva();
        switch (estado) {
            case "true-false":
                salida.append("Como era de esperarse, ").append(criatura1.getNombre()).append(" gana\n");
                break;
            case "false-true":
                salida.append("Como era de esperarse, ").append(criatura2.getNombre()).append(" gana\n");
                break;
            case "false-false":
                salida.append("Ambos murieron, es un empate\n");
                break;
        }

        return salida.toString();
    }
}

