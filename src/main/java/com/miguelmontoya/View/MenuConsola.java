package com.miguelmontoya.View;

import java.util.List;
import java.util.Scanner;

import com.miguelmontoya.Controller.EntradaDatosCriatura;
import com.miguelmontoya.Model.Criaturas.Factory.Criatura;

public class MenuConsola {
    // Esta clase se encargará de mostrar el menú de opciones al usuario y de
    // recibir su input para luego
    // pasar el input del usuario al MenuController para que este lo procese y
    // ejecute la acción correspondiente.

    public int mostrarMenu(Scanner scanner) {

        System.out.println("************** BIENVENIDO A MONSTER HATCH **************\n");
        System.out.println("1. Crear criatura personalizada");
        System.out.println("2. Listar criaturas disponibles");
        System.out.println("3. Elegir dos criaturas para batalla");
        System.out.println("4. Mostrar estrategias disponibles");
        System.out.println("5. Salir\n");
        System.out.println("********************************************************");
        System.out.print("Seleccione una de las opciones: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        return opcion;

    }

    public EntradaDatosCriatura pedirDatosCriatura(Scanner scanner){
        System.out.println("**************** PERSONALIZAR CRIATURA ****************\n");
        System.out.println("A continuación podrás personalizar tu criatura");
        System.out.print("Ingrese el nombre:");
        String nombre = scanner.nextLine();
        mostrarEstrategias();
        System.out.print("Ingrese el número de la estrategia que desea:");
        int opcionEstrategia = Integer.parseInt(scanner.nextLine());
        mostrarTipos();
        System.out.print("Ingrese el número del tipo de criatura que desea:");
        int opcionTipo = Integer.parseInt(scanner.nextLine());
        
        return new EntradaDatosCriatura(nombre, opcionEstrategia, opcionTipo);
    }

    public List<Criatura> solicitarCriaturas(List<Criatura> criaturas, Scanner scanner){
      mostrarMensaje("---------------------------------------------");
        mostrarMensaje("-------- Preparando Arena de Batalla --------\n");
        mostrarMensaje("Para iniciar la batalla es necesario que seleccione dos " +
                "criaturas, a continuación se le presenta la lista: \n");
        mostrarCriaturasDisponibles(criaturas);
        mostrarMensaje("Escriba el índice de la primera criatura");
        int criatura1 = (Integer.parseInt(scanner.nextLine()))-1;
        Criatura criaturaElegida1 = criaturas.get(criatura1);
        mostrarMensaje("Escriba el índice de la segunda criatura");
        int criatura2 = (Integer.parseInt(scanner.nextLine()))-1;
        Criatura criaturaElegida2 = criaturas.get(criatura2);
        return List.of(criaturaElegida1, criaturaElegida2);
    }
     /*
     * Muestra las criaturas disponibles
     */
    public void mostrarCriaturasDisponibles(List<Criatura> criaturas) {
        System.out.println("************ CRIATURAS DISPONIBLES ************\n");
        for (int i = 0; i < criaturas.size(); i++) {
            System.out.println(i + 1 + ". " + criaturas.get(i).toString());
        }
        System.out.println("***********************************************");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEstrategias() {
        System.out.println("******* ESTRATEGIAS DISPONIBLES EN MONSTERHATCH *******\n");
        System.out.println("1. Estrategia Agresiva \n" +
                "2. Estrategia Aletargadora \n" +
                "3. Estrategia Curativa \n" +
                "4. Estrategia Defensiva \n" +
                "5. Estrategia Evasiva");
        System.out.println("*******************************************************\n");
    }

    public void mostrarTipos() {

        System.out.println("************* TIPOS DE CRIATURAS DISPONIBLES **********\n");
        System.out.println("1. Camaleón: Es una criatura que tiene una vida y daño media, una defensa baja, \n" +
                "y se ve afectada por la letargia de manera normal, pero no sufre los efectos del veneno.");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("2. Magica: es una criatura que tiene una vida y daño media, una defensa baja, \n" +
                "aumenta su defensa mientras esté letargada, y aumenta su daño mientras esté envenenada.");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("3. Tanque: es una criatura que tiene una vida y defensa alta, pero un daño bajo, \n" +
                "y se ve afectada por la letargia y veneno de manera normal.");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("4. Veloz: es una criatura que tiene una defensa y vida media\n" +
                "pero un daño bajo, y no se ve afectada por la letargia.");
        System.out.println("*******************************************************\n");
    }
}
