package Model.Criaturas;

import Model.Criaturas.Factory.Criatura;
import Model.Estrategias.Factory.EstrategiaBatalla;

// La criatura mágica es una criatura que tiene una vida y daño media, pero una defensa baja, 
// pero aumenta su defensa mientras esté letargada, y aumenta su daño mientras esté envenenada.
public class Magica extends Criatura{

    public Magica(String nombre, EstrategiaBatalla estrategia, String tipo) {
        super(nombre, estrategia, tipo.toLowerCase());
        this.vida = 80;
        this.danio = 30;
        this.defensa = 10;
        this.esquivaActiva = false;
        this.tipo = "magica";
        this.turnosLetargados = 0;
        this.turnosVeneno = 0;
    
    }

        @Override
    public String ataca(Criatura enemigo) {
        if (this.turnosLetargados > 0) {
            this.defensa += 5; // Aumenta la defensa en 5 puntos mientras esté letargada
            return (this.nombre + " aumenta su defensa bajo los efectos de latargia por ser mágica, y ataca a " + enemigo.getNombre()) +
                    ("\n" + enemigo.reducirVida(this.danio));
        }
        return (this.nombre + " ataca a " + enemigo.getNombre()) + ("\n" + enemigo.reducirVida(this.danio));
    }

    @Override
    public String aplicarVeneno() {
        this.danio += 2; // Aumenta el daño en 2 puntos mientras esté envenenada
        return (this.nombre + " aumenta su daño bajo los efectos del veneno por ser mágica.");
    }
}
