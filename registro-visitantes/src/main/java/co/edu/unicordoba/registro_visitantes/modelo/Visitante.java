package co.edu.unicordoba.registro_visitantes.modelo;
import co.edu.unicordoba.registro_visitantes.util.TextoUtil;

public class Visitante { // ESTADO DE INSTANCIA
    private final int id;
    private final String nombre;
    private final int edad;

    // ESTADO DE CLASE (STATIC)
    private static int totalCreados;
    public static final int EDAD_MINIMA = 18;

    static {
        // Bloque static: se ejecuta 1 vez al cargar la clase
        totalCreados = 0;
    }

    public Visitante(String nombre, int edad) {
        totalCreados++; // Se modifica la variable compartida de la CLASE
        this.id = totalCreados; // Atributo de ESTE objeto
        this.nombre = TextoUtil.normalizarNombre(nombre);
        this.edad = edad;
    }

    // MÉTODO DE INSTANCIA
    public boolean esMayorDeEdad() {
        return this.edad >= EDAD_MINIMA;
    }

    // MÉTODO DE CLASE (STATIC)
    public static int getTotalCreados() {
        return totalCreados;
    }

    // Getters para que Spring Serialice los atributos a JSON
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
}
