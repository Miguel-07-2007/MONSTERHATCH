package Model.Strategy;

import Model.Criatura;

public interface EstrategiaBatalla {

    String actuar(Criatura criatura, Criatura enemigo);
}
