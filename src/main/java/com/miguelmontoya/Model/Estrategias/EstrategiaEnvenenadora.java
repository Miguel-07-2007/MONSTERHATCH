package com.miguelmontoya.Model.Estrategias;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;

public class EstrategiaEnvenenadora implements EstrategiaBatalla {

    //El enemigo pierde entre 5 y 10 puntos de vida por turno durante los próximos 2 turnos.

    //                         PENDIENTE DE REVISIÓN
    
    @Override
    public String actuar(Criatura criatura, Criatura enemigo) {
        
        enemigo.aumentarTurnosVeneno(2);
        return ('¡' + criatura.getNombre() + " ha activado su estrategia envenenadora y ha aplicado"
        + " veneno a " + enemigo.getNombre() + '!');

    }
}
