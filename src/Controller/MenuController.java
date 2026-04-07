package Controller;

import java.util.Scanner;

import Model.Criaturas.Factory.Criatura;
import Model.Estrategias.Factory.EstrategiaBatalla;
import View.MenuConsola;
import Model.Estrategias.Factory.EstrategiaFactory;
import Model.Criaturas.Factory.CriaturaFactory;

public class MenuController {

    ArenaDeBatalla arena;
    MenuConsola vistaMenu;
    Scanner scanner;

    // Constructor del MenuController, exige instancias de MenuConsola y Scanner.
    public MenuController(MenuConsola vistaMenu, Scanner scanner) {
        this.vistaMenu = vistaMenu;
        this.scanner = scanner;
    }

    /*
     * Método que se encarga en su totalidad de la creación de criaturas
     * aprovechando el patrón de diseño
     * Factory de las clases EstrategiaBatalla y Criatura y utilizando el
     * view.mwnuConsola para mostrar información
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
