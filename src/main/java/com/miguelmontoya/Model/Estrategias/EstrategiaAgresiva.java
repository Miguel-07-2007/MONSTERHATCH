package com.miguelmontoya.Model.Estrategias;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;

public class EstrategiaAgresiva implements EstrategiaBatalla{

    @Override
    public String actuar(Criatura criatura, Criatura enemigo) {
        int danio = criatura.getDanio() + (int)(Math.random()*11);
        // enemigo.reducirVida(danio);
        // return('¡' + criatura.getNombre() + " ataca de forma agresiva causando " + danio +
        // " puntos de daño a " + enemigo.getNombre() + '!' + "\nVida restante: " + enemigo.getVida());
        return('¡' + criatura.getNombre() + " ataca de forma agresiva!\n" + enemigo.reducirVida(danio));
    }
    
}