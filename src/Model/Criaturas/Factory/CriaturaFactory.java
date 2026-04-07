package Model.Criaturas.Factory;

import Model.Criaturas.Camaleon;
import Model.Criaturas.Magica;
import Model.Criaturas.Tanque;
import Model.Criaturas.Veloz;
import Model.Estrategias.Factory.EstrategiaBatalla;

public class CriaturaFactory {

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
