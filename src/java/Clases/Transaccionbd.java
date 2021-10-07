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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Urban
 */
public class Transaccionbd extends Conexion{
    private PreparedStatement ps;
    private ResultSet rs;
    
    //Insertar transaccion
    public void insertarTransaccion(Transaccion transaccion){
        Connection con = null;
        
        try{
            con = super.conectar();
            ps = con.prepareStatement("INSERT INTO "
                    + "Transaccion(idTransaccion, idCuenta, tipoTransaccion, monto, observacion, fecha) "
                    + "VALUES (DEFAULT, ?, '?', ?, '?', '?');");
            ps.setInt(1, transaccion.getCuenta().getIdCuenta());
            ps.setString(2, transaccion.getTipoTransaccion());
            ps.setDouble(3, transaccion.getMonto());
            ps.setString(4, transaccion.getObservacion());
            ps.setString(5, transaccion.getFecha());
            
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
    
    //Insertar transaccion
    public ArrayList<Transaccion> listarTransaccion(Cuenta cuenta){
        Connection con = null;
        ArrayList<Transaccion> alTransaccion = new ArrayList<>();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM tratransaccion WHERE idCuenta = ?;");
            ps.setInt(1, cuenta.getIdCuenta());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Cuenta c = new Cuenta();
                c.setIdCuenta(rs.getInt("idCuenta"));
                
                alTransaccion.add(new Transaccion(rs.getInt("idTransaccion"),
                        c, rs.getString("tipoTransaccion"),
                        rs.getDouble("monto"), rs.getString("observacion"), 
                        rs.getString("fecha"), rs.getString("hora")));
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cuentabd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alTransaccion;
    }
}
