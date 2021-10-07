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
public class Cuentabd extends Conexion{
    private PreparedStatement ps;
    private ResultSet rs;
    
    //Consulta cuenta por usuario
    public Cuenta consultarCuenta(User usuario){
        Connection con = null;
        Cuenta cuenta = new Cuenta();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM cuenta INNER JOIN usuario ON usuario.idUser = cuenta.idUser INNER JOIN tipodeinteres ON tipodeinteres.idTipoDeInteres = cuenta.idTipoDeInteres WHERE cuenta.idUser = "+usuario.getIdUser()+";");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                cuenta.setIdCuenta(rs.getInt("idCuenta"));
                cuenta.setNombre(rs.getString("nombre"));
                cuenta.setUser(new User(rs.getInt("idUser"), rs.getString("correo"), rs.getString("contra")));
                cuenta.setSaldo(rs.getDouble("saldo"));
                cuenta.setTipoDeInteres(new TipoDeInteres(rs.getInt("idTipoDeInteres"),
                        rs.getString("nombreInteres"), rs.getDouble("tasaInteres")));
            }
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                Logger.getLogger(Cuentabd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cuenta;
    }
    
     //Consulta cuenta por usuario email
    public Cuenta consultarCuentaEmail(User usuario){
        Connection con = null;
        Cuenta cuenta = new Cuenta();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM cuenta INNER JOIN usuario ON usuario.idUser = cuenta.idUser INNER JOIN tipodeinteres ON tipodeinteres.idTipoDeInteres = cuenta.idTipoDeInteres WHERE usuario.correo = 'balrking07@gmail.com';");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                cuenta.setIdCuenta(rs.getInt("idCuenta"));
                cuenta.setNombre(rs.getString("nombre"));
                cuenta.setUser(new User(rs.getInt("idUser"), rs.getString("correo"), rs.getString("contra")));
                cuenta.setSaldo(rs.getDouble("saldo"));
                cuenta.setTipoDeInteres(new TipoDeInteres(rs.getInt("idTipoDeInteres"),
                        rs.getString("nombreInteres"), rs.getDouble("tasaInteres")));
            }
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cuentabd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cuenta;
    }
    
    public ArrayList<Cuenta> listaCuenta(String nombre){
        Connection con = null;
        ArrayList<Cuenta> alCuenta = new ArrayList<>();
        Cuenta cuenta = new Cuenta();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM cuenta INNER JOIN usuario ON usuario.idUser = cuenta.idUser INNER JOIN tipodeinteres ON tipodeinteres.idTipoDeInteres = cuenta.idTipoDeInteres WHERE LOWER(cuenta.nombre) LIKE '%"+nombre+"%';");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                cuenta.setIdCuenta(rs.getInt("idCuenta"));
                cuenta.setNombre(rs.getString("nombre"));
                cuenta.setUser(new User(rs.getInt("idUser"), rs.getString("correo"), rs.getString("contra")));
                cuenta.setSaldo(rs.getDouble("saldo"));
                cuenta.setTipoDeInteres(new TipoDeInteres(rs.getInt("idTipoDeInteres"),
                        rs.getString("nombreInteres"), rs.getDouble("tasaInteres")));
                
                alCuenta.add(cuenta);
            }
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cuentabd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alCuenta;
    }
    
    public void agregarCuenta(Cuenta cuenta){
        Connection con = null;
        Userbd userbd = new Userbd();
        TipoDeInteresbd tp = new TipoDeInteresbd();
        
        try{
            con = super.conectar();
            ps = con.prepareStatement("INSERT INTO cuenta (nombre,idUser,saldo,idTipoDeInteres)"
                    + "VALUES('"+cuenta.getNombre()+"',"+cuenta.getUser().getIdUser()+","+
                    cuenta.getSaldo()+","+cuenta.getTipoDeInteres().getIdTipoDeInteres()+");");
//            ps.setString(1, cuenta.getNombre());
//            ps.setInt(2, cuenta.getUser().getIdUser());
//            ps.setDouble(3, cuenta.getSaldo());
//            ps.setInt(4, cuenta.getTipoDeInteres().getIdTipoDeInteres());
            
            ps.execute();
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cuentabd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void eliminarCuenta(Cuenta cuenta){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("DELETE FROM cuenta WHERE idCuenta=?;");
            ps.setInt(1, cuenta.getIdCuenta());
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
    
    public void actualizarCuenta(Cuenta cuenta){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("UPDATE cuenta SET nombre = ?, saldo = ? WHERE idCuenta = ?;");
            ps.setString(1, cuenta.getNombre());
            ps.setDouble(2, cuenta.getSaldo());
            ps.setInt(3, cuenta.getIdCuenta());
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
            ps = con.prepareStatement("SELECT * FROM cuenta ORDER BY idCuenta DESC limit 1;");
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
