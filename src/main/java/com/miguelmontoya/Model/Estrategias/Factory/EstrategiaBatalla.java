package com.miguelmontoya.Model.Estrategias.Factory;

import com.miguelmontoya.Model.Criaturas.Factory.Criatura;

public interface EstrategiaBatalla {

    String actuar(Criatura criatura, Criatura enemigo);
}
