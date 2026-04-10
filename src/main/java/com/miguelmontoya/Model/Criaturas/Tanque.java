package com.miguelmontoya.Model.Criaturas;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;

// La criatura tanque es una criatura que tiene una vida y defensa alta, pero un daño bajo, y se ve afectada por la letargia
// y veneno de manera normal.
public class Tanque extends Criatura{

    public Tanque(String nombre, EstrategiaBatalla estrategia, String tipo) {
        super(nombre, estrategia, tipo.toLowerCase());
        this.vida = 100;
        this.danio = 30;
        this.defensa = 15;
        this.esquivaActiva = true;
        this.tipo = "tanque";
        this.turnosLetargados = 0;
        this.turnosVeneno = 0;
    
    }


}
