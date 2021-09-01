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
public class ConsultaSaldos {
    private String nCuenta;
    private String nombre;
    private double saldo;

    public ConsultaSaldos() {
    }

    public ConsultaSaldos(String nCuenta, String nombre, double saldo) {
        this.nCuenta = nCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
