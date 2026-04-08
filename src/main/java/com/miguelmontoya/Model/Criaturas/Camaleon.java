package com.miguelmontoya.Model.Criaturas;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;

//La criatura camaleon es una criatura que tiene una vida y daño media, pero una defensa baja, 
//y se ve afectada por la letargia de manera normal, pero no sufre los efectos del veneno.
public class Camaleon extends Criatura {

        public Camaleon(String nombre, EstrategiaBatalla estrategia, String tipo) {
        super(nombre, estrategia, tipo.toLowerCase());
        this.vida = 70;
        this.danio = 25;
        this.defensa = 10;
        this.esquivaActiva = false;
        this.tipo = "camaleon";
        this.turnosLetargados = 0;
        this.turnosVeneno = 0;
    
    }
    @Override
    public String aplicarVeneno(){
    return(this.nombre + " por ser una criatura de tipo camaleon, no sufrirá los efectos del veneno.");
}
}


