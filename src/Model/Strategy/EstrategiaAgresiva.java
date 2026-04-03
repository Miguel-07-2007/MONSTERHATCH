package Model.Strategy;

import Model.Criatura;

public class EstrategiaAgresiva implements EstrategiaBatalla{

    @Override
    public String actuar(Criatura criatura, Criatura enemigo) {
        int daño = criatura.getAtaque() + (int)(Math.random()*5);
        enemigo.reducirVida(daño);
        return(criatura.getNombre() + "ataca violentamente causando " + daño +
        " puntos de daño a " + enemigo.getNombre());
    }
    
}