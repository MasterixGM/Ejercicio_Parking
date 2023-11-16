==================================================
           README.txt - Ejercicio Parking
==================================================

1. **Clases:**
   - `Parking`: Representa el sistema de gestión del estacionamiento.
   - `Plaza`: Representa un espacio de estacionamiento individual.
   - `Vehiculo`: Representa un vehículo y su comportamiento como un hilo separado.

2. **Métodos:**
   - Clase `Parking`:
     - `comprobadorPlaza()`: Verifica la disponibilidad de un espacio de estacionamiento.
     - `entradaParking(Vehiculo v)`: Controla la entrada de un vehículo al estacionamiento.
     - `salidaParking(Vehiculo v)`: Simula la salida de un vehículo del estacionamiento.
   - Clase `Plaza`:
     - `isOcupado()`: Devuelve si el espacio de estacionamiento está ocupado.
     - `getnPlazas()`: Devuelve el índice del espacio de estacionamiento.
   - Clase `Vehiculo`:
     - `run()`: Simula el comportamiento de un vehículo (entrada, estancia, salida).

3. **Ejecución:**
   - El método principal está en la clase `Parking`.
   - Establece el número de espacios de estacionamiento (`numeroPlazas`) y vehículos (`numeroCoches`) en el método `main`.
   - Ejecuta el programa para observar la entrada y salida de vehículos en el estacionamiento.

4. **Manejo de Excepciones:**
   - El programa utiliza `InterruptedException` para manejar interrupciones relacionadas con hilos durante las operaciones de espera.
   - Otras excepciones se pueden implementar, según las necesidades del programa.

==================================================
