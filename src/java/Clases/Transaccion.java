/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Urban
 */
public class Transaccion {
    private Cuenta cuenta;
    private String tipoTransaccion;
    private double monto;
    private String observacion;
    private LocalDate fecha;
    private LocalTime hora;
    
    public Transaccion() {
    }

    public Transaccion(Cuenta cuenta, String tipoTransaccion, double monto, String observacion, LocalDate fecha, LocalTime hora) {
        this.cuenta = cuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.observacion = observacion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
