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
public class TipoDeInteres {
    private int idTipoDeInteres;
    private String nombreInteres;
    private double tasaInteres;

    public TipoDeInteres() {
    }

    public TipoDeInteres(int idTipoDeInteres, String nombreInteres, double tasaInteres) {
        this.idTipoDeInteres = idTipoDeInteres;
        this.nombreInteres = nombreInteres;
        this.tasaInteres = tasaInteres;
    }

    public int getIdTipoDeInteres() {
        return idTipoDeInteres;
    }

    public void setIdTipoDeInteres(int idTipoDeInteres) {
        this.idTipoDeInteres = idTipoDeInteres;
    }

    public String getNombreInteres() {
        return nombreInteres;
    }

    public void setNombreInteres(String nombreInteres) {
        this.nombreInteres = nombreInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
}
