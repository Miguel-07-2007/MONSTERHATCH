package Model.Estrategias;

import Model.Criaturas.Factory.Criatura;
import Model.Estrategias.Factory.EstrategiaBatalla;

public class EstrategiaEvasiva implements EstrategiaBatalla{

    //La criatura evita el siguiente ataque recibido. La evasión se resetea tras esquivar.

    @Override
    public String actuar(Criatura criatura, Criatura enemigo) {
        criatura.activarEsquiva();
        return(criatura.getNombre() + " ha activado su estrategia evasiva, y está"
        + " listo para evadir el próximo ataque de " + enemigo.getNombre());
    }

    

}
