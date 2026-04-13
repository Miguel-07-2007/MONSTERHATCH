package com.miguelmontoya.Model.Estrategias;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;

public class EstrategiaCurativa implements EstrategiaBatalla{

    //La criatura recupera entre 10 y 20 puntos de vida al usar su turno.

    @Override
    public String actuar(Criatura criatura, Criatura enemigo) {
        int aumento = 10 + (int)Math.random() * 11;
        criatura.aumentarVida(aumento);
        return('¡' + criatura.getNombre() + " ha activado su estrategia curativa y aumenta " + 
        aumento + " puntos de vida en este turno!");
    }

}
