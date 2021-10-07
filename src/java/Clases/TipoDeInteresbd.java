/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Urban
 */
public class TipoDeInteresbd extends Conexion{
    private PreparedStatement ps;
    private ResultSet rs;
    
    public void agregarTipoDeInteres(TipoDeInteres tp){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("INSERT INTO tipodeinteres (nombreInteres,tasaInteres) VALUES('?',?);");
            ps.setString(1, tp.getNombreInteres());
            ps.setDouble(2, tp.getTasaInteres());
            ps.execute();
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cuentabd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int ultimoID(){
        Connection con = null;
        int salida = 0;
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM tipodeinteres ORDER BY idTipoDeInteres DESC limit 1;");
            rs = ps.executeQuery();
            
            salida = rs.getInt(1);
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cuentabd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return salida;
    }
}
