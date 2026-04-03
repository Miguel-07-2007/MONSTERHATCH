package Model.Factory;

import Model.Strategy.EstrategiaBatalla;

public class Tanque extends Criatura{

    public Tanque(String nombre, EstrategiaBatalla estrategia, String tipo) {
        super(nombre, estrategia, tipo.toLowerCase());
        this.vida = 100;
        this.danio = 20;
        this.defensa = 15;
        this.esquivaActiva = true;
        this.tipo = "tanque";
        this.turnosLetargados = 0;
        this.turnosVeneno = 0;
    
    }


}
