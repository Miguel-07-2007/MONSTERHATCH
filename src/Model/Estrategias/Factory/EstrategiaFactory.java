package Model.Estrategias.Factory;

import Model.Estrategias.EstrategiaAgresiva;
import Model.Estrategias.EstrategiaAletargadora;
import Model.Estrategias.EstrategiaCurativa;
import Model.Estrategias.EstrategiaDefensiva;
import Model.Estrategias.EstrategiaEvasiva;

public class EstrategiaFactory {

    public static EstrategiaBatalla crearEstrategia(String tipo){
        if (tipo.equalsIgnoreCase("Agresiva")){
            return new EstrategiaAgresiva();
        } else if (tipo.equalsIgnoreCase("Aletargadora")){
            return new EstrategiaAletargadora();
        } else if (tipo.equalsIgnoreCase("Curativa")){
            return new EstrategiaCurativa();
        } else if (tipo.equalsIgnoreCase("Defensiva")){
            return new EstrategiaDefensiva();
        } else if (tipo.equalsIgnoreCase("Evasiva")){
            return new EstrategiaEvasiva();
        } else {
            return new EstrategiaAgresiva(); // Valor por defecto
            //throw new IllegalArgumentException("Tipo de estrategia no válido: " + tipo);
        }
    }
}
