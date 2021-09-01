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
public class MostarTransaciones {
    private String nCuenta;
    private String nombre;
    private double saldoAnterior;
    private double nuevoSaldo;

    public MostarTransaciones() {
    }

    public MostarTransaciones(String nCuenta, String nombre, double saldoAnterior, double nuevoSaldo) {
        this.nCuenta = nCuenta;
        this.nombre = nombre;
        this.saldoAnterior = saldoAnterior;
        this.nuevoSaldo = nuevoSaldo;
    }

    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getNuevoSaldo() {
        return nuevoSaldo;
    }

    public void setNuevoSaldo(double nuevoSaldo) {
        this.nuevoSaldo = nuevoSaldo;
    }
}
