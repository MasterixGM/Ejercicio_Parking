/**
 * La clase Vehiculo representa un vehículo que puede entrar y salir de un estacionamiento.
 * Cada vehículo tiene un identificador único, una plaza asignada y pertenece a un estacionamiento.
 */
public class Vehiculo extends Thread {
    /**
     * Identificador único del vehículo.
     */
    private int cocheID;

    /**
     * Plaza asignada al vehículo en el estacionamiento.
     */
    private Plaza plazaAsignada;

    /**
     * Estacionamiento al que pertenece el vehículo.
     */
    private Parking pr;

    /**
     * Constructor de la clase Vehiculo.
     *
     * @param cocheID         Identificador único del vehículo.
     * @param plazaAsignada   Plaza asignada al vehículo en el estacionamiento.
     * @param pr              Estacionamiento al que pertenece el vehículo.
     */
    public Vehiculo(int cocheID, Plaza plazaAsignada, Parking pr) {
        this.cocheID = cocheID;
        this.plazaAsignada = plazaAsignada;
        this.pr = pr;
    }

    /**
     * Obtiene el identificador único del vehículo.
     *
     * @return Identificador único del vehículo.
     */
    public int getCocheID() {
        return cocheID;
    }

    /**
     * Establece el identificador único del vehículo.
     *
     * @param cocheID Nuevo identificador único del vehículo.
     */
    public void setCocheID(int cocheID) {
        this.cocheID = cocheID;
    }

    /**
     * Obtiene la plaza asignada al vehículo en el estacionamiento.
     *
     * @return Plaza asignada al vehículo.
     */
    public Plaza getPlazaAsignada() {
        return plazaAsignada;
    }

    /**
     * Establece la plaza asignada al vehículo en el estacionamiento.
     *
     * @param plazaAsignada Nueva plaza asignada al vehículo.
     */
    public void setPlazaAsignada(Plaza plazaAsignada) {
        this.plazaAsignada = plazaAsignada;
    }

    /**
     * Método principal que simula el comportamiento del vehículo en el estacionamiento.
     * El vehículo espera un tiempo, entra al estacionamiento, permanece un tiempo, sale
     * y espera nuevamente antes de volver a entrar.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 5000) + 1000); // Tiempo de espera para entrar

                pr.entradaParking(this);

                Thread.sleep((long) (Math.random() * 5000) + 1000); // Tiempo de estancia en el parking

                pr.salidaParking(this);

                Thread.sleep((long) (Math.random() * 5000) + 1000); // Tiempo de espera para volver a entrar
            } catch (InterruptedException errorSleep) {
                System.out.println("Hilo no pudo esperar durante el tiempo especificado");
                errorSleep.printStackTrace();
            }
        }
    }
}
