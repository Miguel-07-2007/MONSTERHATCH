package com.miguelmontoya;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.miguelmontoya.Controller.ArenaDeBatalla;
import com.miguelmontoya.Controller.MenuController;
import com.miguelmontoya.View.MenuConsola;

public class Main {
    private static final Logger logger = LogManager.getLogger(ArenaDeBatalla.class);
    public static void main(String[] args) throws Exception {
        MenuController controladorJuego = new MenuController(new MenuConsola(), ArenaDeBatalla.getInstancia());
        controladorJuego.procesarMenu();
        
    }
}
