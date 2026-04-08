package com.miguelmontoya;

import java.util.ArrayList;
import java.util.List;

import com.miguelmontoya.Controller.MenuController;
import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;
import com.miguelmontoya.View.MenuConsola;


public class Main {
    public static void main(String[] args) throws Exception {


        MenuController controladorJuego = new MenuController(new MenuConsola());
        controladorJuego.mostrarCriaturasDisponibles();
        
    }
}
