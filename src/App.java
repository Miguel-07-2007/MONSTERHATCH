import Model.Factory.Camaleon;
import Model.Factory.Criatura;
import Model.Strategy.EstrategiaAgresiva;
import Model.Strategy.EstrategiaEnvenenadora;

public class App {
    public static void main(String[] args) throws Exception {
        Criatura charizard = new Camaleon("Charizard", new EstrategiaAgresiva(), "camaleon");
        Criatura pikachu = new Camaleon("Pikachu", new EstrategiaEnvenenadora(), "tanque");

        System.out.println("-------------------------------------------------------");
        System.out.println("------------- SE DEJÓ VENIR ESTO HP -------------------");
        
        while (charizard.estaViva() && pikachu.estaViva()) {
            System.out.println(charizard.ejecutarAccion(pikachu));
            System.out.println(pikachu.ejecutarAccion(charizard));
            charizard.aplicarEfectos();
            pikachu.aplicarEfectos();
        }
        String estado = charizard.estaViva() + "-" + pikachu.estaViva();

        switch (estado) {
            case "true-false":
                System.out.println(" como era de esperarse, charizard gana");
                break;
            case "false-true":
                System.out.println(" como era de esperarse, pikachu gana");
                break;
            case "false-false":
                System.out.println(" ambos murieron, es un empate");
                break;
        }

    }
}
