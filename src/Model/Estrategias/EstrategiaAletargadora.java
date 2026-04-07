package Model.Estrategias;

import Model.Criaturas.Factory.Criatura;
import Model.Estrategias.Factory.EstrategiaBatalla;

public class EstrategiaAletargadora implements EstrategiaBatalla{

    //Reduce el ataque del enemigo en una cantidad fija o porcentual durante 2 turnos.

    @Override
    public String actuar(Criatura criatura, Criatura enemigo){
        enemigo.aumentarTurnosLetargados(2);
        return(criatura.getNombre() + " ha activado su estrategia aletargadora, así que el daño de "
        + enemigo.getNombre() + " se verá reducido en los próximos 2 turnos");
    }

}
