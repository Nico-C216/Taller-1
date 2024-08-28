package logica.programacionAvanzada.UDistrital.edu;

/**
 * Clase que representa a una persona reclutada, que se presentó a la incorporación
 * y fue reclutada para el periodo.
 */
public class Reclutado extends Persona {
	private String codigoReclutamiento;

	/**
     * Constructor para crear un nuevo Reclutado.
     *
     * @param cedula             La cédula del reclutado, no puede ser nula o vacía.
     * @param nombre             El nombre del reclutado, no puede ser nulo o vacío.
     * @param apellido           El apellido del reclutado, no puede ser nulo o vacío.
     * @param codigoReclutamiento El código de reclutamiento del reclutado, no puede ser nulo o vacío.
     * @throws IllegalArgumentException si alguno de los parámetros es nulo o vacío.
     */
	public Reclutado(String cedula, String nombre, String apellido, String codigoReclutamiento) {
        super(cedula, nombre, apellido);
        if (codigoReclutamiento == null || codigoReclutamiento.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de reclutamiento no puede ser nulo o vacío.");
        }
        this.codigoReclutamiento = codigoReclutamiento;
    }

	// Métodos getter y setter
    public String getCodigoReclutamiento() {
        return codigoReclutamiento;
    }

    public void setCodigoReclutamiento(String codigoReclutamiento) {
        this.codigoReclutamiento = codigoReclutamiento;
    }

    /**
     * Implementación del método abstracto para obtener el estado militar del reclutado.
     *
     * @return El estado militar del reclutado.
     */
    @Override
    public String obtenerEstadoMilitar() {
        return "Reclutado";
    }

}
