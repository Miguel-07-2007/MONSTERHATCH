package Model.Factory;

import Model.Strategy.EstrategiaBatalla;

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


