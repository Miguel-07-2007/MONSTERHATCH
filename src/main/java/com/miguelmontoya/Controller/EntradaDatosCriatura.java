package com.miguelmontoya.Controller;

public class EntradaDatosCriatura {

    private String nombre;
    private int opcionEstrategia;
    private int opcionTipo;

    public EntradaDatosCriatura(String nombre, int opcionEstrategia, int opcionTipo){
        this.nombre = nombre;
        this.opcionEstrategia = opcionEstrategia;
        this.opcionTipo = opcionTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOpcionEstrategia() {
        return opcionEstrategia;
    }

    public void setOpcionEstrategia(int opcionEstrategia) {
        this.opcionEstrategia = opcionEstrategia;
    }

    public int getOpcionTipo() {
        return opcionTipo;
    }

    public void setOpcionTipo(int opcionTipo) {
        this.opcionTipo = opcionTipo;
    }

    
}
