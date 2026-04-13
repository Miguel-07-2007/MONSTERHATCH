package com.miguelmontoya.Model.Criaturas;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;

//La criatura veloz es una criatura que no se ve afectada por la letargia, y tiene una 
// defensa y vida media, pero un daño bajo.
public class Veloz extends Criatura{

    public Veloz(String nombre, EstrategiaBatalla estrategia, String tipo){
        super(nombre, estrategia, tipo.toLowerCase());
        this.vida = 70;
        this.danio = 35;
        this.defensa = 10;
        this.esquivaActiva = true;
        this.tipo = "veloz";
        this.turnosLetargados = 0;
        this.turnosVeneno = 0;

    }

    @Override
    public String atacar(Criatura enemigo) {
        if (this.turnosLetargados > 0) {
            return (this.nombre + " no sufre bajo los efectos de latargia por ser veloz, y ataca a " + enemigo.getNombre()) +
                    enemigo.reducirVida(this.danio);
        }
        return (this.nombre + " ataca a " + enemigo.getNombre() + ". " + enemigo.reducirVida(this.danio));
    }
}
