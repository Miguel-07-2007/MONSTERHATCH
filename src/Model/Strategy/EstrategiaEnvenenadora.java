package Model.Strategy;

import Model.Factory.Criatura;

public class EstrategiaEnvenenadora implements EstrategiaBatalla {

    //El enemigo pierde entre 5 y 10 puntos de vida por turno durante los próximos 3 turnos.

    //                         PENDIENTE DE REVISIÓN
    
    @Override
    public String actuar(Criatura criatura, Criatura enemigo) {
        
        enemigo.aumentarTurnosVeneno(3);
        return (criatura.getNombre() + " ha activado su estrategia envenenadora y ha aplicado"
        + " veneno a " + enemigo.getNombre());

    }
}
