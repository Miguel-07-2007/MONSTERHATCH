package Model.Strategy;

import Model.Factory.Criatura;

public interface EstrategiaBatalla {

    String actuar(Criatura criatura, Criatura enemigo);
}
