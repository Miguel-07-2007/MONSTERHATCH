package Model.Criaturas.Factory;

import Model.Estrategias.Factory.EstrategiaBatalla;

public class Criatura {
    protected String nombre;
    protected int vida;
    protected int defensa;
    protected int danio;
    protected boolean esquivaActiva;
    protected EstrategiaBatalla estrategia;
    protected int turnosVeneno;
    protected int turnosLetargados;
    protected String tipo;

    // constructor con todos los atributos de una Criatura
    public Criatura(String nombre, int vida, int danio, int defensa, EstrategiaBatalla estrategia, String tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.danio = danio;
        this.defensa = defensa;
        this.estrategia = estrategia;
        this.esquivaActiva = false;
        this.tipo = tipo;
    }

    // Constructor con nombre, estrategia y tipo
    public Criatura(String nombre, EstrategiaBatalla estrategia, String tipo) {
        this.nombre = nombre;
        this.estrategia = estrategia;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTurnosVeneno() {
        return turnosVeneno;
    }

    public void aumentarTurnosVeneno(int turnosVeneno) {
        this.turnosVeneno += turnosVeneno;
    }

    public int getTurnosLetargados() {
        return turnosLetargados;
    }

    public void aumentarTurnosLetargados(int turnosLetargados) {
        this.turnosLetargados += turnosLetargados;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDanio() {
        return danio;
    }

    public boolean getEsquivaActiva() {
        return esquivaActiva;
    }

    public EstrategiaBatalla getEstrategia() {
        return estrategia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public void activarEsquiva() {
        this.esquivaActiva = true;
    }

    public void desactivarEsquiva() {
        this.esquivaActiva = false;
    }

    public void aumentarVida(int aumento) {
        this.vida += Math.max(aumento, 0);
    }

    public void aumentarDefensa(int aumento) {
        this.defensa += Math.max(aumento, 0);
    }

    public String reducirVida(int danio) {
        if (esquivaActiva) {
            esquivaActiva = false;
            return (nombre + " esquiva completamente el daño");
        }
        int danioReal = Math.max(danio - defensa, 0);
        vida -= danioReal;
        return (nombre + " recibe " + danioReal + " de daño. Vida restante: " + vida);
    }

    public boolean estaViva() {
        return this.vida > 0;
    }

    /**
     * Método para ejecutar la acción de la criatura, que puede ser un ataque normal
     * o una estrategia
     * especial dependiendo de la probabilidad, si el enemigo ya tiene veneno, no se
     * aplicará la estrategia envenenadora.
     */
    public String ejecutarAccion(Criatura enemigo) {
        int probabilidadDeUsarEstrategia = (int) (Math.random() * 11);
        if (probabilidadDeUsarEstrategia > 5 && enemigo.getTurnosVeneno() < 1) {
            return estrategia.actuar(this, enemigo);
        }
        return this.ataca(enemigo);
    }

    public String ataca(Criatura enemigo) {
        if (this.turnosLetargados > 0) {
            int letarga = 5 + (int) (Math.random() * 6); // la letargia total será de entre 5 y 10 puntos de ataque
            return (this.nombre + " bajo los efectos de latargia, ataca a " + enemigo.getNombre()) +
                    ("\n" + enemigo.reducirVida(this.danio - letarga));
        }
        return (this.nombre + " ataca a " + enemigo.getNombre()) + ("\n" + enemigo.reducirVida(this.danio));
    }

    /**
     * Método para aplicar veneno, que reduce la vida de la criatura,
     * llamar según la cantidad de turnos veneno restantes.
     */
    public String aplicarVeneno() {
        int danio = 5 + (int) (Math.random() * 6); // el daño total del veneno será entre 5 y 10
        this.vida -= danio;
        this.turnosVeneno--;
        return (this.nombre + " sufre " + danio + " de daño por el veneno. Vida restante: " + this.vida +
                ". Turnos de veneno restantes: " + this.turnosVeneno);
    }

    /**
     * Método que se llamará al inicio de cada turno de la batalla
     */
    public String aplicarEfectos() {
        if (this.turnosVeneno > 0) {
            return this.aplicarVeneno();
        }
        return ("");
    }

@Override
    public String toString() {
        return "Criatura{" +
                "nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", defensa=" + defensa +
                ", danio=" + danio +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
