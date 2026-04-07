package View;

public class MenuConsola {
    // Esta clase se encargará de mostrar el menú de opciones al usuario y de
    // recibir su input para luego
    // pasar el input del usuario al MenuController para que este lo procese y
    // ejecute la acción correspondiente.
    public static void mostrarMenu() {
        System.out.println("****** BIENVENIDO A MONSTER HATCH ******");
        System.out.println("1. Crear criatura personalizada");
        System.out.println("2. Listar criaturas disponibles");
        System.out.println("3. Elegir dos criaturas para batalla");
        System.out.println("4. Mostrar estrategias disponibles");
        System.out.println("5. Salir");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEstrategias() {
        System.out.println("Estrategias disponibles en MonsterHatch");
        System.out.println("1. Estrategia Agresiva \n" +
                "2. Estrategia Aletargadora \n" +
                "3. Estrategia Curativa \n" +
                "4. Estrategia Defensiva \n" +
                "5. Estrategia Evasiva");
    }

	public void mostrarTipos() {
	System.out.println("Tipos de criaturas disponibles en MonsterHatch");
    System.out.println("1. Camaleón: Es una criatura que tiene una vida y daño media, una defensa baja, \n" + 
                "y se ve afectada por la letargia de manera normal, pero no sufre los efectos del veneno.\n\n");
    System.out.println("2. Magica: es una criatura que tiene una vida y daño media, una defensa baja, \n" + 
                "aumenta su defensa mientras esté letargada, y aumenta su daño mientras esté envenenada.\n\n");
    System.out.println("3. Tanque: es una criatura que tiene una vida y defensa alta, pero un daño bajo, \n" +
                "y se ve afectada por la letargia y veneno de manera normal.\n\n");
    System.out.println("4. Veloz: es una criatura que tiene una defensa y vida media\n" +
                "pero un daño bajo, y no se ve afectada por la letargia.\n\n");
}
}
