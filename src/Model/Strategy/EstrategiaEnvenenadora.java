package Model.Strategy;

import Model.Factory.Criatura;

public class EstrategiaEnvenenadora implements EstrategiaBatalla {

    //El enemigo pierde entre 5 y 10 puntos de vida por turno durante los próximos 3 turnos.

    //                         PENDIENTE DE REVISIÓN
    
    @Override
    public String actuar(Criatura criatura, Criatura enemigo) {
        int danio = 5 + (int)Math.random() * 5;
        enemigo.aumentarTurnosVeneno(2);
        return (criatura.getNombre() + " ha activado su estrategia envenenadora y aplica"
        + " veneno a " + enemigo.getNombre() + " por 3 turnos\n" 
        + enemigo.reducirVida(danio));

    }
}
