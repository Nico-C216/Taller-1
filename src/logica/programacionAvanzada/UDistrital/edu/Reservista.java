package logica.programacionAvanzada.UDistrital.edu;

/**
 * Clase que representa a un Reservista, una persona que pertenece a una unidad
 * o fuerza de reserva militar y que tiene una libreta militar.
 */
public class Reservista extends Persona {
	private String libretaMilitar;

	/**
     * Constructor para crear un nuevo Reservista.
     *
     * @param cedula         La cédula del reservista, no puede ser nula o vacía.
     * @param nombre         El nombre del reservista, no puede ser nulo o vacío.
     * @param apellido       El apellido del reservista, no puede ser nulo o vacío.
     * @param libretaMilitar La libreta militar del reservista, no puede ser nula o vacía.
     * @throws IllegalArgumentException si alguno de los parámetros es nulo o vacío.
     */
	public Reservista(String cedula, String nombre, String apellido, String libretaMilitar) {
        super(cedula, nombre, apellido);
        if (libretaMilitar == null || libretaMilitar.trim().isEmpty()) {
            throw new IllegalArgumentException("La libreta militar no puede ser nula o vacía.");
        }
        this.libretaMilitar = libretaMilitar;
    }

	// Métodos getter y setter
    public String getLibretaMilitar() {
        return libretaMilitar;
    }

    public void setLibretaMilitar(String libretaMilitar) {
        this.libretaMilitar = libretaMilitar;
    }

    /**
     * Implementación del método abstracto para obtener el estado militar del reservista.
     *
     * @return El estado militar del reservista.
     */
    @Override
    public String obtenerEstadoMilitar() {
        return "Reservista";
    }

}
