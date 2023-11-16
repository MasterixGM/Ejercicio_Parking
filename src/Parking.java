import java.util.ArrayList;
import java.util.List;

/**
 * La clase Parking representa un estacionamiento con plazas y vehículos.
 * Cada plaza en el estacionamiento puede estar ocupada o disponible, y cada vehículo
 * puede entrar y salir del estacionamiento, asignándosele una plaza si está disponible.
 */
public class Parking {
    /**
     * Lista de plazas disponibles en el estacionamiento.
     */
    public List<Plaza> plazas;

    /**
     * Lista de vehículos en el estacionamiento.
     */
    public List<Vehiculo> vehiculos;

    /**
     * Constructor de la clase Parking que inicializa las listas de plazas y vehículos.
     *
     * @param plazas    Lista de plazas disponibles en el estacionamiento.
     * @param vehiculos Lista de vehículos en el estacionamiento.
     */
    public Parking(List<Plaza> plazas, List<Vehiculo> vehiculos) {
        this.plazas = plazas;
        this.vehiculos = vehiculos;
    }

    /**
     * Obtiene la lista de plazas del estacionamiento.
     *
     * @return Lista de plazas disponibles en el estacionamiento.
     */
    public List<Plaza> getPlazas() {
        return plazas;
    }

    /**
     * Establece la lista de plazas del estacionamiento.
     *
     * @param plazas Nueva lista de plazas disponibles en el estacionamiento.
     */
    public void setPlazas(List<Plaza> plazas) {
        this.plazas = plazas;
    }

    /**
     * Comprueba y devuelve una plaza disponible en el estacionamiento.
     *
     * @return Plaza disponible en el estacionamiento. Si no hay plazas disponibles, se crea una nueva con número -1.
     */
    public synchronized Plaza comprobadorPlaza() {
        for (Plaza p : plazas) {
            if (!p.isOcupado() && p.getnPlazas() > 0) {
                return p;
            }
        }
        return new Plaza(false, -1);
    }

    /**
     * Permite que un vehículo entre al estacionamiento, asignándole una plaza disponible si la hay.
     *
     * @param v Vehículo que intenta entrar al estacionamiento.
     * @throws InterruptedException Si ocurre una interrupción mientras el vehículo espera su turno para entrar.
     */
    public synchronized void entradaParking(Vehiculo v) throws InterruptedException {
        Plaza plazaAsignada = comprobadorPlaza();

        if (plazaAsignada.getnPlazas() == -1) {
            try {
                System.out.println("Coche: " + v.getCocheID() + " espera la entrada al Parking");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            plazaAsignada.setOcupado(true);  // Marcar la plaza como ocupada
            v.setPlazaAsignada(plazaAsignada);
            System.out.println("Coche: " + v.getCocheID() + " entra al parking. Con la plaza: " + v.getPlazaAsignada().getnPlazas());
        }
    }

    /**
     * Permite que un vehículo salga del estacionamiento, liberando la plaza que ocupaba.
     *
     * @param v Vehículo que sale del estacionamiento.
     */
    public synchronized void salidaParking(Vehiculo v) {
        System.out.println("Coche " + v.getCocheID() + " sale del parking plaza Nº: " + v.getPlazaAsignada().getnPlazas() + " Disponible!");
        v.getPlazaAsignada().setOcupado(false);
        notifyAll();  // Notificar a todos los hilos que estaban esperando para entrar
    }

    /**
     * Método principal que simula la creación de un estacionamiento con plazas y vehículos.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        int numeroPlazas = 5;
        int numeroCoches = 10;

        List<Plaza> plazas = new ArrayList<>(numeroPlazas);
        for (int i = 0; i < numeroPlazas; i++) {
            plazas.add(new Plaza(false, i + 1));
        }

        List<Vehiculo> vehiculos = new ArrayList<>(numeroCoches);

        Parking p = new Parking(plazas, vehiculos);

        for (int i = 0; i < numeroCoches; i++) {
            // Si el coche no tiene plaza asignada, el número de la plaza será -1.
            Vehiculo vehiculo = new Vehiculo(i, new Plaza(false, -1), p);
            Thread vehiculoThread = new Thread(vehiculo);
            vehiculoThread.start();
            vehiculos.add(vehiculo);
        }
    }
}
