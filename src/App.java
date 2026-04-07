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
        Criatura charizard = new Camaleon("Charizard", new EstrategiaAgresiva(), "camaleon");
        Criatura pikachu = new Tanque("Pikachu", new EstrategiaEnvenenadora(), "tanque");
        Criatura bulbasaur = new Magica("Bulbasaur", new EstrategiaEnvenenadora(), "magica");
        Criatura squirtle = new Veloz("Squirtle", new EstrategiaAgresiva(), "veloz");

        MenuController controladorJuego = new MenuController(new View.MenuConsola(), new java.util.Scanner(System.in));
        
    }
}
