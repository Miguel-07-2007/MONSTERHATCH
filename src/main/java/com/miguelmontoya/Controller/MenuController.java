package com.miguelmontoya.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.miguelmontoya.Model.Criaturas.Camaleon;
import com.miguelmontoya.Model.Criaturas.Magica;
import com.miguelmontoya.Model.Criaturas.Tanque;
import com.miguelmontoya.Model.Criaturas.Veloz;
import com.miguelmontoya.Model.Criaturas.Factory.Criatura;
import com.miguelmontoya.Model.Estrategias.EstrategiaAgresiva;
import com.miguelmontoya.Model.Estrategias.EstrategiaEnvenenadora;
import com.miguelmontoya.Model.Estrategias.EstrategiaEvasiva;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaBatalla;
import com.miguelmontoya.Model.Estrategias.EstrategiaCurativa;
import com.miguelmontoya.Model.Estrategias.EstrategiaAletargadora;
import com.miguelmontoya.View.MenuConsola;
import com.miguelmontoya.Model.Estrategias.Factory.EstrategiaFactory;
import com.miguelmontoya.Model.Criaturas.Factory.CriaturaFactory;

public class MenuController {

    ArenaDeBatalla arena;
    MenuConsola vistaMenu;
    Scanner scanner;
    List<Criatura> criaturas;

    // Constructor del MenuController, exige instancias de MenuConsola y Scanner.
    public MenuController(MenuConsola vistaMenu, ArenaDeBatalla arena) {
        this.arena = arena;
        this.vistaMenu = vistaMenu;
        this.scanner = new Scanner(System.in);
        this.criaturas = new ArrayList<>();
        Criatura charizard = new Camaleon("Charizard", new EstrategiaAgresiva(), "Camaleon");
        Criatura pikachu = new Tanque("Pikachu", new EstrategiaEnvenenadora(), "Tanque");
        Criatura bulbasaur = new Magica("Bulbasaur", new EstrategiaCurativa(), "Magico");
        Criatura squirtle = new Veloz("Squirtle", new EstrategiaEvasiva(), "Veloz");
        Criatura mewtwo = new Magica("Mewtwo", new EstrategiaAletargadora(), "Magico");
        Criatura snorlax = new Magica("Snorlax", new EstrategiaCurativa(), "Magico");
        criaturas.add(charizard);
        criaturas.add(pikachu);
        criaturas.add(bulbasaur);
        criaturas.add(squirtle);
        criaturas.add(mewtwo);
        criaturas.add(snorlax);
    }
    //   - Crear criaturas personalizadas.
//   - Listar criaturas disponibles.
//   - Elegir dos criaturas para batalla.
//   - Mostrar estrategias disponibles.
//   - Ejecutar batalla y mostrar resultado.

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
        List<Criatura> elegidas = vistaMenu.solicitarCriaturas(this.criaturas, this.scanner);
        vistaMenu.mostrarMensaje(arena.iniciarBatalla(elegidas.get(0), elegidas.get(1)));;
        vistaMenu.mostrarMensaje(arena.mostrarEstado());
    }

    /*
     * Método que se encarga en su totalidad de la creación de criaturas
     * aprovechando el patrón de diseño
     * Factory de las clases EstrategiaBatalla y Criatura y utilizando el
     * vistaMenu para mostrar información
     * al final se agrega la criatura creada a la lista de criaturas disponibles.
     */
    public void crearCriaturaPersonalizada(Scanner scanner) {
        EntradaDatosCriatura  datosCriatura = vistaMenu.pedirDatosCriatura(scanner);
        EstrategiaBatalla estrategia = EstrategiaFactory.crearEstrategia(procesarEstrategia(
            datosCriatura.getOpcionEstrategia()));
        Criatura criaturaCreada = CriaturaFactory.crearCriatura(procesarTipo(datosCriatura.getOpcionTipo()), 
            datosCriatura.getNombre(), estrategia);
        criaturas.add(criaturaCreada);
        vistaMenu.mostrarMensaje("Criatura creada con éxito: \n" + criaturaCreada.toString());
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
    public void procesarMenu() {
        int opcion = 0;
        do {
            opcion = vistaMenu.mostrarMenu(scanner);
            switch (opcion) {
                case 1:
                    crearCriaturaPersonalizada(this.scanner);
                    break;
                case 2:
                    vistaMenu.mostrarCriaturasDisponibles(criaturas);
                    break;
                case 3:
                    iniciarBatalla();
                    break;
                case 4:
                    vistaMenu.mostrarEstrategias();
                    break;
                case 5:
                    vistaMenu.mostrarMensaje("Gracias por jugar Monster Hatch. ¡Hasta la próxima!");
                    break;
                default:
                    vistaMenu.mostrarMensaje("Opción no válida. Por favor, elige una opción del menú.");
            }
        } while (opcion != 5);
        scanner.close();
    } 
}
