package co.unicatolica.parkcontrol.services;

import co.unicatolica.parkcontrol.models.Vehiculo;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class ParqueaderoService {

    private List<Vehiculo> listaVehiculos = new ArrayList<>();
    private final int CAPACIDAD_MAXIMA = 10;
    private final String archivo = "parqueadero.txt";

    public ParqueaderoService() {
        cargarDatos();
    }

    public boolean agregarVehiculo(Vehiculo v) {

        if (listaVehiculos.size() >= CAPACIDAD_MAXIMA) {
            System.out.println("❌ Parqueadero lleno.");
            return false;
        }

        if (!validarPlaca(v.getPlaca())) {
            System.out.println("❌ Formato de placa inválido. Ej: ABC123 o ABC12D.");
            return false;
        }

        if (buscarVehiculo(v.getPlaca()) != null) {
            System.out.println("❌ Ya existe un vehículo con esa placa.");
            return false;
        }

        listaVehiculos.add(v);
        guardarDatos();
        return true;
    }

    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) return v;
        }
        return null;
    }

    public void mostrarVehiculos() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        listaVehiculos.forEach(System.out::println);
    }

    public boolean retirarVehiculo(String placa) {
        Vehiculo v = buscarVehiculo(placa);

        if (v == null) {
            System.out.println("❌ Vehículo no encontrado.");
            return false;
        }

        v.registrarSalida();
        double costo = v.calcularCosto();
        System.out.println(">> Tiempo total: " + v.calcularMinutos() + " min");
        System.out.println(">> Total a pagar: $" + costo);

        listaVehiculos.remove(v);
        guardarDatos();
        return true;
    }

    // ----------------Persistencia-------------------

    private void guardarDatos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Vehiculo v : listaVehiculos) {
                pw.println(v.getPlaca() + ";" + v.getHoraIngreso() + ";" + v.toString());
            }
        } catch (IOException e) {
            System.out.println("Error guardando datos.");
        }
    }

    private void cargarDatos() {
        File f = new File(archivo);
        if (!f.exists()) return;
    }

    // ----------------Helpers------------------------

    private boolean validarPlaca(String placa) {
        String regex = "^[A-Z]{3}[0-9]{3}$|^[A-Z]{3}[0-9]{2}[A-Z]$";
        return Pattern.matches(regex, placa);
    }
}
