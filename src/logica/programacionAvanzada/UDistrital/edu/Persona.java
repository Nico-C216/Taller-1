package logica.programacionAvanzada.UDistrital.edu;

/**
 * Clase abstracta que representa a una persona con información básica.
 * Esta clase es la base para los diferentes tipos de personas relacionadas
 * con la gestión de la situación militar.
 */
public abstract class Persona {
	private String cedula;
    private String nombre;
    private String apellido;

    /**
     * Constructor para crear una nueva Persona.
     *
     * @param cedula   La cédula de la persona, no puede ser nula o vacía.
     * @param nombre   El nombre de la persona, no puede ser nulo o vacío.
     * @param apellido El apellido de la persona, no puede ser nulo o vacío.
     * @throws IllegalArgumentException si alguno de los parámetros es nulo o vacío.
     */
    public Persona(String cedula, String nombre, String apellido) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede ser nula o vacía.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser nulo o vacío.");
        }

        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Métodos getters para los atributos de la clase Persona
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Método abstracto para obtener el estado militar de la persona.
     * Cada subclase debe implementar este método para definir su propio estado militar.
     *
     * @return El estado militar de la persona.
     */
    public abstract String obtenerEstadoMilitar();

}
