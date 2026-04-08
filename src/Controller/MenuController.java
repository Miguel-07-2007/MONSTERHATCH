package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Criaturas.Camaleon;
import Model.Criaturas.Magica;
import Model.Criaturas.Tanque;
import Model.Criaturas.Veloz;
import Model.Criaturas.Factory.Criatura;
import Model.Estrategias.EstrategiaAgresiva;
import Model.Estrategias.EstrategiaEnvenenadora;
import Model.Estrategias.Factory.EstrategiaBatalla;
import View.MenuConsola;
import Model.Estrategias.Factory.EstrategiaFactory;
import Model.Criaturas.Factory.CriaturaFactory;

public class MenuController {

    ArenaDeBatalla arena;
    MenuConsola vistaMenu;
    Scanner scanner;
    List<Criatura> criaturas;

    // Constructor del MenuController, exige instancias de MenuConsola y Scanner.
    public MenuController(MenuConsola vistaMenu) {
        this.vistaMenu = vistaMenu;
        this.scanner = new Scanner(System.in);
        this.criaturas = new ArrayList<>();
        Criatura charizard = new Camaleon("Charizard", new EstrategiaAgresiva(), "camaleon");
        Criatura pikachu = new Tanque("Pikachu", new EstrategiaEnvenenadora(), "tanque");
        Criatura bulbasaur = new Magica("Bulbasaur", new EstrategiaEnvenenadora(), "magica");
        Criatura squirtle = new Veloz("Squirtle", new EstrategiaAgresiva(), "veloz");
        criaturas.add(charizard);
        criaturas.add(pikachu);
        criaturas.add(bulbasaur);
        criaturas.add(squirtle);
    }

    /*
     * recibe las entradas del usuario para seleccionar dos criaturas de la lista de
     * criaturas disponibles y luego llama al método iniciarBatalla de la clase 
     * ArenaDeBatalla para iniciar la batalla entre las dos criaturas seleccionadas, 
     * finalmente muestra el estado de la batalla después de cada turno.
     * 
     * Es importante revisar el manejo de índices para evitar errores de selección, 
     * y asegurarse de que el método iniciarBatalla refleje correctamente el estado
     * de las criaturas después de cada acción.
     */
    public void iniciarBatalla() {
        vistaMenu.mostrarMensaje("---------------------------------------------");
        vistaMenu.mostrarMensaje("-------- Preparando Arena de Batalla --------\n");
        vistaMenu.mostrarMensaje("Para iniciar la batalla es necesario que seleccione dos" +
                "criaturas, a continuación se le presenta la lista: \n");
        mostrarCriaturasDisponibles();
        vistaMenu.mostrarMensaje("Escriba el índice de la primera criatura");
        int criatura1 = scanner.nextInt();
        Criatura criaturaElegida1 = criaturas.get(criatura1);
        vistaMenu.mostrarMensaje("Escriba el índice de la segunda criatura");
        int criatura2 = scanner.nextInt();
        Criatura criaturaElegida2 = criaturas.get(criatura1);
        arena.iniciarBatalla(criaturaElegida1, criaturaElegida2);
        arena.mostrarEstado();
        scanner.close();
    }

    /*
     * Muestra las criaturas disponibles
     */
    public void mostrarCriaturasDisponibles() {
        vistaMenu.mostrarMensaje("------------------------------------------------");
        vistaMenu.mostrarMensaje("------------- Criaturas disponibles -------------\n");
        for (int i = 0; i < criaturas.size(); i++) {
            vistaMenu.mostrarMensaje(i+1 + ". " + criaturas.get(i).toString());
        }
        System.out.println("------------------------------------------------");
        }

    /*
     * Método que se encarga en su totalidad de la creación de criaturas
     * aprovechando el patrón de diseño
     * Factory de las clases EstrategiaBatalla y Criatura y utilizando el
     * vistaMenu para mostrar información
     * al final se agrega la criatura creada a la lista de criaturas disponibles.
     */
    public void crearCriaturaPersonalizada(Scanner scanner) {
        vistaMenu.mostrarMensaje("*********************************");
        vistaMenu.mostrarMensaje("A continuación podrás personalizar tu criatura");
        vistaMenu.mostrarMensaje("Ingrese el nombre:");
        String nombre = scanner.nextLine();
        vistaMenu.mostrarEstrategias();
        vistaMenu.mostrarMensaje("Ingrese el número de la estrategia que desea:");
        int opcion = scanner.nextInt();
        EstrategiaBatalla estrategia = EstrategiaFactory.crearEstrategia(procesarEstrategia(opcion));
        vistaMenu.mostrarTipos();
        vistaMenu.mostrarMensaje("Ingrese el número del tipo de criatura que desea:");
        int opcion2 = scanner.nextInt();
        Criatura criaturaCreada = CriaturaFactory.crearCriatura(procesarTipo(opcion2), nombre, estrategia);
        vistaMenu.mostrarMensaje("Has creado exitosamente tu criatura" + criaturaCreada.toString());
        criaturas.add(criaturaCreada);
        scanner.close();
    }

    /*
     * Maneja a través de un switch el entero ingresado por el usuario y lo
     * transforma en un String
     * permite mayor comodidad para el uso de factory
     */
    public String procesarTipo(int opcion) {
        switch (opcion) {
            case 1:
                return "Camaleon";
            case 2:
                return "Magica";
            case 3:
                return "Tanque";
            case 4:
                return "Veloz";
            default:
                vistaMenu.mostrarMensaje("Usted ha ingresado una" +
                        "respuesta inválida, se le asignará el tipo Camaleón");
                return "Camaleon";
        }
    }

    public String procesarEstrategia(int opcion) {
        switch (opcion) {
            case 1:
                return "Agresiva";
            case 2:
                return "Aletargadora";
            case 3:
                return "Curativa";
            case 4:
                return "Defensiva";
            case 5:
                return "Evasiva";
            default:
                vistaMenu.mostrarMensaje("Usted ha ingresado una" +
                        "respuesta inválida, se le asignará la estrategia agresiva");
                return "Agresiva";
        }
    }

    /*
     * Esta clase se encargará de procesar la opción elegida por el usuario en el
     * menú, y de llamar a los métodos y clases correspondientes para ejecutar la
     * acción elegida por el usuario.
     */
    public static void procesarOpcionMenu(int opcion) {
        while (opcion != 5) {
            switch (opcion) {
                case 1:
                    // Lógica para crear criatura personalizada
                    break;
                case 2:
                    // Lógica para listar criaturas disponibles
                    break;
                case 3:
                    // Lógica para elegir dos criaturas para batalla
                    break;
                case 4:
                    // Lógica para mostrar estrategias disponibles
                    break;
                case 5:
                    System.out.println("Gracias por jugar Monster Hatch. ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        }
    }
}
