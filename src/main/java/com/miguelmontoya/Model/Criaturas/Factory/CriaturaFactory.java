package com.miguelmontoya.Model.Criaturas.Factory;

import com.miguelmontoya.Model.Criaturas.Camaleon;
import com.miguelmontoya.Model.Criaturas.Magica;
import com.miguelmontoya.Model.Criaturas.Tanque;
import com.miguelmontoya.Model.Criaturas.Veloz;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;

public class CriaturaFactory {

    /**
     * Método estático que crea una criatura según su tipo, nombre y estrategia.
     * Utiliza el patrón de diseño Factory para instanciar la clase correspondiente.
     */
    public static Criatura crearCriatura(String tipo, String nombre, EstrategiaBatalla estrategia) {
        if (tipo.equalsIgnoreCase("camaleon")) {
            return new Camaleon(nombre, estrategia, tipo);
        } else if (tipo.equalsIgnoreCase("magica")) {
            return new Magica(nombre, estrategia, tipo);
        } else if (tipo.equalsIgnoreCase("Tanque")) {
            return new Tanque(nombre, estrategia, tipo);
        } else if (tipo.equalsIgnoreCase("Veloz")) {
            return new Veloz(nombre, estrategia, tipo);
        } else {
            return new Camaleon(nombre, estrategia, tipo);
        }
    }
}
