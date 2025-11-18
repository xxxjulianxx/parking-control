package co.unicatolica.parkcontrol;

import co.unicatolica.parkcontrol.models.Vehiculo;
import co.unicatolica.parkcontrol.services.ParqueaderoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParqueaderoService service = new ParqueaderoService();

        int opcion;

        do {
            System.out.println("\n=== MENU PARQUEADERO ===");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Mostrar vehículos");
            System.out.println("3. Retirar vehículo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();

                    System.out.print("Tipo (carro/moto): ");
                    String tipo = sc.nextLine();

                    System.out.print("Observación (opcional): ");
                    String obs = sc.nextLine();

                    Vehiculo v = new Vehiculo(placa, tipo, obs);
                    service.agregarVehiculo(v);
                    break;

                case 2:
                    service.mostrarVehiculos();
                    break;

                case 3:
                    System.out.print("Placa del vehículo a retirar: ");
                    String placaSalida = sc.nextLine();
                    service.retirarVehiculo(placaSalida);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
