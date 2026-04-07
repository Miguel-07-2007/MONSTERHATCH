package Model.Estrategias.Factory;

import Model.Criaturas.Factory.Criatura;

public interface EstrategiaBatalla {

    String actuar(Criatura criatura, Criatura enemigo);
}
