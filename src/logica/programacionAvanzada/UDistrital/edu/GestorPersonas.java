package logica.programacionAvanzada.UDistrital.edu;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que gestiona las operaciones relacionadas con las personas y sus estados
 * de situación militar en el sistema.
 */
public class GestorPersonas {
	private Map<String, Persona> personasRegistradas;

	/**
     * Constructor para inicializar el gestor de personas.
     */
    public GestorPersonas() {
        personasRegistradas = new HashMap<>();
    }

    /**
     * Método para insertar una nueva persona en el sistema.
     *
     * @param persona La persona a insertar.
     * @return true si la persona fue insertada correctamente.
     * @throws PersonaYaExisteException si la persona ya está registrada en el sistema.
     */
    public boolean insertarPersona(Persona persona) throws PersonaYaExisteExcepcion {
        if (personasRegistradas.containsKey(persona.getCedula())) {
            throw new PersonaYaExisteExcepcion("La persona con cédula " + persona.getCedula() + " ya existe en el sistema.");
        }
        personasRegistradas.put(persona.getCedula(), persona);
        return true;
    }

    /**
     * Método para consultar una persona por su cédula.
     *
     * @param cedula La cédula de la persona a consultar.
     * @return La persona encontrada.
     * @throws PersonaNoEncontradaException si no se encuentra ninguna persona con la cédula proporcionada.
     */
    public Persona consultarPersona(String cedula) throws PersonaNoEncontradaExcepcion {
        Persona persona = personasRegistradas.get(cedula);
        if (persona == null) {
            throw new PersonaNoEncontradaExcepcion("No se encontró ninguna persona con la cédula " + cedula + ".");
        }
        return persona;
    }

    /**
     * Método para cambiar el estado militar de una persona.
     *
     * @param cedula        La cédula de la persona cuyo estado se va a cambiar.
     * @param nuevaPersona  La nueva instancia de la persona con el estado actualizado.
     * @throws PersonaNoEncontradaException   si no se encuentra ninguna persona con la cédula proporcionada.
     * @throws CambioDeEstadoInvalidoException si el cambio de estado no es válido según las reglas de negocio.
     */
    public void cambiarEstadoMilitar(String cedula, Persona nuevaPersona) throws PersonaNoEncontradaExcepcion, CambioDeEstadoInvalidadoExcepcion {
        Persona personaActual = personasRegistradas.get(cedula);
        if (personaActual == null) {
            throw new PersonaNoEncontradaExcepcion("No se encontró ninguna persona con la cédula " + cedula + " para cambiar el estado militar.");
        }

        // Validar cambio de estado militar
        validarCambioDeEstado(personaActual, nuevaPersona);

        // Actualizar la persona en el sistema con el nuevo estado
        personasRegistradas.put(cedula, nuevaPersona);
    }

    /**
     * Método para validar si el cambio de estado militar es permitido.
     *
     * @param personaActual La persona en su estado actual.
     * @param nuevaPersona  La nueva persona con el estado al que se desea cambiar.
     * @throws CambioDeEstadoInvalidoException si el cambio de estado no es permitido.
     */
    private void validarCambioDeEstado(Persona personaActual, Persona nuevaPersona) throws CambioDeEstadoInvalidadoExcepcion {
        // Ejemplo de validación: un "Aplazado" no puede pasar a "Reservista"
        if (personaActual instanceof Aplazado && nuevaPersona instanceof Reservista) {
            throw new CambioDeEstadoInvalidadoExcepcion("Un aplazado no puede cambiar directamente a reservista.");
        }
        // Agregar más reglas de validación según sea necesario
    }

    /**
     * Método para generar un reporte de personas por su estado militar.
     *
     * Este método cuenta cuántas personas hay en cada uno de los estados militares disponibles.
     * Los posibles estados son: "Reservista", "Reclutado", "Remiso", "Aplazado".
     */
    public void generarReportePorEstado(String estadoMilitar) {
        for (Persona persona : personasRegistradas.values()) {
            if (persona.obtenerEstadoMilitar().equals(estadoMilitar)) {
                System.out.println(persona);
            }
        }
    }

}
