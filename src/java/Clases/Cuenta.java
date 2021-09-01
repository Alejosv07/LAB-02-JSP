/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Urban
 */
public class Cuenta {
    private User user;
    private String nombre;
    private String cuenta;
//    private BigInteger cuenta;
    private double saldo;
    private TipoDeInteres tipoDeInteres;
    
    public Cuenta() {
    }
    
    public Cuenta(String nombre, String cuenta, double saldo, TipoDeInteres tipoDeInteres, User user) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.saldo = saldo;
        this.tipoDeInteres = tipoDeInteres;
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public HashMap estadoCuenta() {
        //Creamos el hashMap
        HashMap hmEstadoCuenta = new HashMap();
        
        //Ingresamos Nombre del titular y número de identificación cuenta.
        hmEstadoCuenta.put("Numero de cuenta", this.cuenta);
        hmEstadoCuenta.put("Nombre del titular", this.nombre);
        
        hmEstadoCuenta.put("Saldo actual", this.saldo);            

        return hmEstadoCuenta;
    }
    
    public HashMap depositos(ArrayList<Transaccion> alTransaccion) {
        //Creamos el hashMap
        HashMap hmEstadoCuenta = new HashMap();
        
        //Ingresamos Nombre del titular y número de identificación cuenta.
        hmEstadoCuenta.put("Numero de cuenta", this.cuenta);
        hmEstadoCuenta.put("Nombre del titular", this.nombre);
        //Fecha del estado.
        hmEstadoCuenta.put("Fecha", alTransaccion.get(alTransaccion.size()).getFecha());
        hmEstadoCuenta.put("Hora", alTransaccion.get(alTransaccion.size()).getHora());
        
        hmEstadoCuenta.put("Transacción realizada", alTransaccion.get(alTransaccion.size()).getTipoTransaccion());
        
        if (alTransaccion.size()==1) {
            hmEstadoCuenta.put("Saldo anterior", 0);
            hmEstadoCuenta.put("Saldo actual", alTransaccion.get(alTransaccion.size()).getMonto());
        }
        
        if (alTransaccion.size()>1) {
            hmEstadoCuenta.put("Saldo anterior", alTransaccion.get(alTransaccion.size()-1).getMonto());            
            hmEstadoCuenta.put("Saldo actual", alTransaccion.get(alTransaccion.size()).getMonto());            
        }

        return hmEstadoCuenta;
    }
    
    public HashMap retiros(ArrayList<Transaccion> alTransaccion) {
        //Creamos el hashMap
        HashMap hmEstadoCuenta = new HashMap();
        
        //Ingresamos Nombre del titular y número de identificación cuenta.
        hmEstadoCuenta.put("Numero de cuenta", this.cuenta);
        hmEstadoCuenta.put("Nombre del titular", this.nombre);
        //Fecha del estado.
        hmEstadoCuenta.put("Fecha", alTransaccion.get(alTransaccion.size()).getFecha());
        hmEstadoCuenta.put("Hora", alTransaccion.get(alTransaccion.size()).getHora());
        
        hmEstadoCuenta.put("Transacción realizada", alTransaccion.get(alTransaccion.size()).getTipoTransaccion());
        
        if (alTransaccion.size()==1) {
            hmEstadoCuenta.put("Saldo anterior", 0);
            hmEstadoCuenta.put("Saldo actual", alTransaccion.get(alTransaccion.size()).getMonto());
        }
        
        if (alTransaccion.size()>1) {
            hmEstadoCuenta.put("Saldo anterior", alTransaccion.get(alTransaccion.size()-1).getMonto());            
            hmEstadoCuenta.put("Saldo actual", alTransaccion.get(alTransaccion.size()).getMonto());            
        }

        return hmEstadoCuenta;
    }

    public TipoDeInteres getTipoDeInteres() {
        return tipoDeInteres;
    }

    public void setTipoDeInteres(TipoDeInteres tipoDeInteres) {
        this.tipoDeInteres = tipoDeInteres;
    }
    
    public double interesGanado(int nAnos) {
        return this.saldo*this.tipoDeInteres.getTasaInteres()*nAnos;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
