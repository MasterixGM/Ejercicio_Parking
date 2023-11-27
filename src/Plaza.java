/**
 * La clase Plaza representa una plaza de estacionamiento en un estacionamiento.
 * Cada plaza puede estar ocupada o disponible, y tiene un número único asociado.
 */
public class Plaza {
    /**
     * Indica si la plaza está ocupada por un vehículo.
     */
    private boolean ocupado;

    /**
     * Número único asociado a la plaza.
     */
    private int nPlazas;

    /**
     * Constructor de la clase Plaza que inicializa la ocupación y el número de la plaza.
     *
     * @param ocupado  Indica si la plaza está ocupada por un vehículo.
     * @param nPlazas  Número único asociado a la plaza.
     */
    public Plaza(boolean ocupado, int nPlazas) {
        this.ocupado = ocupado;
        this.nPlazas = nPlazas;
    }

    /**
     * Devuelve true si la plaza está ocupada por un vehículo, false si está disponible.
     *
     * @return true si la plaza está ocupada, false si está disponible.
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * Establece el estado de ocupación de la plaza.
     *
     * @param ocupado true para marcar la plaza como ocupada, false para marcarla como disponible.
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    /**
     * Obtiene el número único asociado a la plaza.
     *
     * @return Número único asociado a la plaza.
     */
    public int getnPlazas() {
        return nPlazas;
    }

    /**
     * Establece el número único asociado a la plaza.
     *
     * @param nPlazas Nuevo número único asociado a la plaza.
     */
    public void setnPlazas(int nPlazas) {
        this.nPlazas = nPlazas;
    }
}
