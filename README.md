# ParkControl – Sistema de Gestión de Parqueadero Gratuito

**ParkControl** es una aplicación desarrollada en **Java** para gestionar el ingreso y salida de vehículos en un parqueadero gratuito.  
El sistema funciona por consola y aplica estructuras de datos vistas en clase (arrays, listas, colas y pilas, según la versión del proyecto).

---

## Funcionalidades principales

- Registrar ingreso de vehículos (placa, tipo, hora y observación).
- Registrar la salida de un vehículo.
- Consultar vehículos actualmente dentro del parqueadero.
- Ver el historial completo de visitas.
- Validar placas duplicadas.
- Filtrar historial por tipo de vehículo.
- Carga y guardado automático en archivos `.txt` (solo versión con persistencia).

---

## Estructuras de datos utilizadas

### ✔ Versión con persistencia (archivos `.txt`)
- **ArrayList** para manejar los vehículos actuales e historial.
- Archivos usados:
  - `data/actuales.txt`
  - `data/historial.txt`

### ✔ Versión educativa (solo memoria)
- **Array estático** → vehículos actuales.
- **ArrayList** → historial.
- **Queue** → vehículos en espera si el parqueadero está lleno.
- **Stack** → registro de acciones (deshacer simple).
- Algoritmos:
  - Búsqueda lineal.
  - Ordenamiento burbuja.

---

## Estructura del proyecto
ParkControl/
├── Main.java
├── models/
│ └── Vehiculo.java
├── services/
│ └── ParqueaderoService.java
└── data/
├── actuales.txt
└── historial.txt

---

## Modelo UML (simplificado)

### **Vehiculo**
- placa : String  
- tipo : String  
- horaEntrada : long  
- horaSalida : long  
- observacion : String  

### **ParqueaderoService**
- actuales : Vehiculo[]  
- historial : ArrayList<Vehiculo>  
- espera : Queue<Vehiculo>  
- acciones : Stack<String>  

---

## Cómo ejecutar el proyecto

1. Abrir una terminal dentro de la carpeta `src`.
2. Compilar: javac co/unicatolica/parkcontrol/.java
co/unicatolica/parkcontrol/models/.java
co/unicatolica/parkcontrol/services/*.java

3. Ejecutar:
   
> ⚠ **Nota:**  
> - En la versión en memoria, los datos se borran al cerrar.  
> - En la versión con archivos, la información se guarda en `.txt`.

---

## Conclusiones

- ParkControl permite gestionar un parqueadero gratuito de forma sencilla.
- Implementa conceptos clave de la materia:
  - Programación orientada a objetos.
  - Estructuras de datos.
  - Manejo de archivos.
- El proyecto es modular y puede ampliarse fácilmente (cupos, interfaz gráfica, etc.).

---




