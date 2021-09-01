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
    private User user;
    private String nombre;
    private String cuenta;
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

    public ConsultaSaldos estadoCuenta() {
        ConsultaSaldos consultaSaldos = new ConsultaSaldos();
        
        consultaSaldos.setNombre(this.nombre);
        consultaSaldos.setSaldo(this.saldo);
        consultaSaldos.setnCuenta(this.cuenta);
        
        return consultaSaldos;
    }
    
    public MostarTransaciones depositos(ArrayList<Transaccion> alTransaccion) {
        MostarTransaciones mostarTransaciones = new MostarTransaciones();
        mostarTransaciones.setNombre(this.nombre);
        mostarTransaciones.setNuevoSaldo(this.saldo);
        mostarTransaciones.setnCuenta(this.cuenta);
        
        if (alTransaccion.size()==1) {
            mostarTransaciones.setSaldoAnterior(0);
        }
        ArrayList<Transaccion> alTransaccion2 = new ArrayList<>();
        if (alTransaccion.size()>1) {
            for (Transaccion t : alTransaccion) {
                if (t.getCuenta().cuenta.trim().equalsIgnoreCase(this.cuenta)) {
                    alTransaccion2.add(t);
                }
            }
            
            mostarTransaciones.setSaldoAnterior(alTransaccion2.get(alTransaccion2.size()-1).getMonto());
        }
        
        return mostarTransaciones;
    }
    
    public MostarTransaciones retiros(ArrayList<Transaccion> alTransaccion) {
        MostarTransaciones mostarTransaciones = new MostarTransaciones();
        mostarTransaciones.setNombre(this.nombre);
        mostarTransaciones.setNuevoSaldo(this.saldo);
        
        if (alTransaccion.size()==1) {
            mostarTransaciones.setSaldoAnterior(0);
        }
        ArrayList<Transaccion> alTransaccion2 = new ArrayList<>();
        if (alTransaccion.size()>1) {
            for (Transaccion t : alTransaccion) {
                if (t.getCuenta().cuenta.trim().equalsIgnoreCase(this.cuenta)) {
                    alTransaccion2.add(t);
                }
            }
            
            mostarTransaciones.setSaldoAnterior(alTransaccion2.get(alTransaccion2.size()-1).getMonto());
        }
        
        return mostarTransaciones;
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
