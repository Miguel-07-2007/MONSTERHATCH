package com.miguelmontoya.Model.Estrategias;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;

public class EstrategiaAgresiva implements EstrategiaBatalla{

    @Override
    public String actuar(Criatura criatura, Criatura enemigo) {
        int daño = criatura.getDanio() + (int)(Math.random()*5);
        enemigo.reducirVida(daño);
        return(criatura.getNombre() + " ataca de forma agresiva causando " + daño +
        " puntos de daño a " + enemigo.getNombre());
    }
    
}