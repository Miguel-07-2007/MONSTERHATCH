import java.util.ArrayList;
import java.util.List;

import Controller.MenuController;
import Model.Criaturas.Camaleon;
import Model.Criaturas.Magica;
import Model.Criaturas.Tanque;
import Model.Criaturas.Veloz;
import Model.Criaturas.Factory.Criatura;
import Model.Estrategias.EstrategiaAgresiva;
import Model.Estrategias.EstrategiaEnvenenadora;
import Controller.MenuController;

public class App {
    public static void main(String[] args) throws Exception {


        MenuController controladorJuego = new MenuController(new View.MenuConsola(), new java.util.Scanner(System.in));
        
    }
}
