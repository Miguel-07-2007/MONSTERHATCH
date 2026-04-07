package Model.Criaturas;

import Model.Criaturas.Factory.Criatura;
import Model.Estrategias.Factory.EstrategiaBatalla;

//La criatura veloz es una criatura que no se ve afectada por la letargia, y tiene una 
// defensa y vida media, pero un daño bajo.
public class Veloz extends Criatura{

    public Veloz(String nombre, EstrategiaBatalla estrategia, String tipo){
        super(nombre, estrategia, tipo.toLowerCase());
        this.vida = 70;
        this.danio = 20;
        this.defensa = 15;
        this.esquivaActiva = true;
        this.tipo = "veloz";
        this.turnosLetargados = 0;
        this.turnosVeneno = 0;

    }

    @Override
    public String ataca(Criatura enemigo) {
        if (this.turnosLetargados > 0) {
            return (this.nombre + " no sufre bajo los efectos de latargia por ser veloz, y ataca a " + enemigo.getNombre()) +
                    ("\n" + enemigo.reducirVida(this.danio));
        }
        return (this.nombre + " ataca a " + enemigo.getNombre()) + ("\n" + enemigo.reducirVida(this.danio));
    }
}
