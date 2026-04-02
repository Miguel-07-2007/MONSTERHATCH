package Model;

import Model.Strategy.EstrategiaBatalla;

public class Criatura {
private String nombre;
private int vida;
private int ataque;
private int defensa;
private boolean esquivaActiva;
private EstrategiaBatalla estrategia;

public Criatura(String nombre, int vida, int ataque, int defensa, EstrategiaBatalla estrategia){
    this.nombre = nombre;
    this.vida = vida;
    this.ataque = ataque;
    this.defensa = defensa;
    this.estrategia = estrategia;
    this.esquivaActiva = false;
}

public String getNombre(){
    return nombre;
}

public int getVida(){
    return vida;
}

public int getAtaque(){
    return ataque;
}

public int getDefensa(){
    return defensa;
}

public boolean getEsquivaActiva(){
    return esquivaActiva;
}

public EstrategiaBatalla getEstrategia(){
    return estrategia;
}

public void setNombre(String nombre){
    this.nombre = nombre;
}

public void setVida(int vida){
    this.vida = vida;
}

public void setAtaque(int ataque){
    this.ataque = ataque;
}

public void setDefensa(int defensa){
    this.defensa = defensa;
}

public void activarEsquiva(){
    this.esquivaActiva = true;
}

public void desactivarEsquiva(){
    this.esquivaActiva = false;
}
 
}
