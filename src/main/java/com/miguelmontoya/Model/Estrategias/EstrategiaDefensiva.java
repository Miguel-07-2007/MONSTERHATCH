package com.miguelmontoya.Model.Estrategias;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;

public class EstrategiaDefensiva implements EstrategiaBatalla{

    //La criatura aumenta su defensa entre 5  y 10 puntos durante su turno.
    @Override
    public String actuar(Criatura criatura, Criatura enemigo) {
        int escudo = 5 + (int)(Math.random()*5);
        criatura.aumentarDefensa(escudo);
        return(criatura.getNombre() + " ha activado su estrategia curativa y refuerza " +
        "su defensa aumentando su escudo en " + escudo + " puntos");
    }

    

}
