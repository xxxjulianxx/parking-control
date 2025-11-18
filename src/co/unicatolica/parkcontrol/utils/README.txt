README - Demostración de estructuras usadas en el proyecto ParkControl (en memoria)

1. Estructura estática (Array):
   - Archivo: ParqueaderoService.java
   - Variable: private Vehiculo[] actuales;
   - Uso: representa las plazas fijas del parqueadero (capacidad definida al iniciar).
   - Operaciones: inserción en posición libre, búsqueda lineal para validar duplicados y eliminar en salida.

2. Estructura dinámica (ArrayList):
   - Archivo: ParqueaderoService.java
   - Variable: private ArrayList<Vehiculo> historial;
   - Uso: almacena el historial completo de vehículos con entrada y salida.
   - Operaciones: add, forEach, iteration.

3. Cola (Queue - LinkedList):
   - Archivo: ParqueaderoService.java
   - Variable: private Queue<Vehiculo> espera;
   - Uso: cuando el parqueadero está lleno, los vehículos esperan en cola FIFO.
   - Operaciones: add (enqueue), poll (dequeue).

4. Pila (Stack):
   - Archivo: ParqueaderoService.java
   - Variable: private Stack<String> acciones;
   - Uso: guarda acciones para posible deshacer (push/pop).

5. Ordenamiento y búsqueda:
   - Ordenamiento: método ordenarVehiculosPorHoraEntrada() utiliza algoritmo burbuja sobre una lista temporal.
   - Búsqueda: buscarEnActuales() hace búsqueda lineal sobre el array 'actuales'.

Este proyecto está diseñado para ser sencillo de compilar y ejecutar desde la consola.
