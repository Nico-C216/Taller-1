package logica.programacionAvanzada.UDistrital.edu;

import java.time.LocalDate;

/**
 * Clase que representa a un Aplazado, una persona que fue aplazada por razones
 * como estar cursando estudios o ser menor de edad.
 */
public class Aplazado extends Persona {
	private LocalDate fechaAplazamiento;

	/**
     * Constructor para crear un nuevo Aplazado.
     *
     * @param cedula           La cédula del aplazado, no puede ser nula o vacía.
     * @param nombre           El nombre del aplazado, no puede ser nulo o vacío.
     * @param apellido         El apellido del aplazado, no puede ser nulo o vacío.
     * @param fechaAplazamiento La fecha de aplazamiento, no puede ser nula o en el pasado.
     * @throws IllegalArgumentException si alguno de los parámetros es nulo o inválido.
     */
	 public Aplazado(String cedula, String nombre, String apellido, LocalDate fechaAplazamiento) {
	     super(cedula, nombre, apellido);
	     if (fechaAplazamiento == null || fechaAplazamiento.isBefore(LocalDate.now())) {
	         throw new IllegalArgumentException("La fecha de aplazamiento no puede ser nula o en el pasado.");
	     }
	     this.fechaAplazamiento = fechaAplazamiento;
	}

	 //Metodos getter y stter
    public LocalDate getFechaAplazamiento() {
        return fechaAplazamiento;
    }

    public void setFechaAplazamiento(LocalDate fechaAplazamiento) {
        this.fechaAplazamiento = fechaAplazamiento;
    }

    /**
     * Implementación del método abstracto para obtener el estado militar del aplazado.
     *
     * @return El estado militar del aplazado.
     */
    @Override
    public String obtenerEstadoMilitar() {
        return "Aplazado";
    }

}
