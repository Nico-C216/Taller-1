package logica.programacionAvanzada.UDistrital.edu;

/**
 * Clase que representa a un Remiso, una persona que estaba citada para presentarse
 * a la incorporación pero no se presentó.
 */
public class Remiso extends Persona {
	
	 /**
     * Constructor para crear un nuevo Remiso.
     *
     * @param cedula   La cédula del remiso, no puede ser nula o vacía.
     * @param nombre   El nombre del remiso, no puede ser nulo o vacío.
     * @param apellido El apellido del remiso, no puede ser nulo o vacío.
     * @throws IllegalArgumentException si alguno de los parámetros es nulo o vacío.
     */
	public Remiso(String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
    }

	/**
     * Implementación del método abstracto para obtener el estado militar del remiso.
     *
     * @return El estado militar del remiso.
     */
    @Override
    public String obtenerEstadoMilitar() {
        return "Remiso";
    }

}
