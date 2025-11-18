package co.unicatolica.parkcontrol.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vehiculo {

    private String placa;
    private String tipo;
    private LocalDateTime horaIngreso;
    private LocalDateTime horaSalida;
    private String observacion;

    public Vehiculo(String placa, String tipo, String observacion) {
        this.placa = placa.toUpperCase();
        this.tipo = tipo;
        this.observacion = observacion;
        this.horaIngreso = LocalDateTime.now();
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void registrarSalida() {
        this.horaSalida = LocalDateTime.now();
    }

    public long calcularMinutos() {
        if (horaSalida == null) return 0;
        return java.time.Duration.between(horaIngreso, horaSalida).toMinutes();
    }

    public double calcularCosto() {
        long minutos = calcularMinutos();
        return (minutos / 60.0) * 3000; // $3000 por hora
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Placa: " + placa +
                " | Tipo: " + tipo +
                " | Ingreso: " + horaIngreso.format(fmt) +
                (horaSalida != null ? " | Salida: " + horaSalida.format(fmt) : "") +
                (observacion.isEmpty() ? "" : " | Obs: " + observacion);
    }
}
