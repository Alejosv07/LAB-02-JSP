/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Urban
 */
public class Transaccion {
    private int idTransaccion;
    private Cuenta cuenta;
    private String tipoTransaccion;
    private double monto;
    private String observacion;
    private String fecha;
    private String hora;
    
    public Transaccion() {
    }

    public Transaccion(int idTransaccion, Cuenta cuenta, String tipoTransaccion, double monto, String observacion, String fecha, String hora) {
        this.idTransaccion = idTransaccion;
        this.cuenta = cuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.observacion = observacion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
