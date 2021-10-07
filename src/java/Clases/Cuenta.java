/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Urban
 */
public class Cuenta {
    private int idCuenta;
    private User user;
    private String nombre;
    private double saldo;
    private TipoDeInteres tipoDeInteres;
    
    public Cuenta() {
    }

    public Cuenta(int idCuenta, User user, String nombre, String cuenta, double saldo, TipoDeInteres tipoDeInteres) {
        this.idCuenta = idCuenta;
        this.user = user;
        this.nombre = nombre;
        this.saldo = saldo;
        this.tipoDeInteres = tipoDeInteres;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public TipoDeInteres getTipoDeInteres() {
        return tipoDeInteres;
    }

    public void setTipoDeInteres(TipoDeInteres tipoDeInteres) {
        this.tipoDeInteres = tipoDeInteres;
    }
    
    public void estadoCuenta() {
    }
    
    public void depositos() {
    }
    
    public void retiros() {
    }

    public double interesGanado(int nAnos) {
        return this.saldo*this.tipoDeInteres.getTasaInteres()*nAnos;
    }
}
