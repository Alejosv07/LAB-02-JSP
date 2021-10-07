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
public class Userbd extends Conexion{
    private PreparedStatement ps;
    private ResultSet rs;
    
    //Consulta cuenta por usuario
    public User consultarUsuario(User usuarioE){
        Connection con = null;
        User usuario = new User();
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM usuario WHERE LOWER(correo) = LOWER('?') AND contra = '?';");
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getContra());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuario = usuarioE;
                usuario.setIdUser(Integer.parseInt(rs.getString("idUser")));
            }
        }catch(Exception e){
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Cuentabd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }
    
    public void eliminarUsuario(User user){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("DELETE FROM usuario WHERE idUser=?;");
            ps.setInt(1, user.getIdUser());
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
    
    
    public void actualizarUsuario(User user){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("UPDATE usuario SET correo = ?, contra = ? WHERE idUser = ?;");
            ps.setString(1, user.getCorreo());
            ps.setString(2, user.getContra());
            ps.setInt(3, user.getIdUser());
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
    
    
    public void agregarUsuario(User user){
        Connection con = null;
        try{
            con = super.conectar();
            ps = con.prepareStatement("INSERT INTO usuario (correo,contra) VALUES('"+user.getCorreo()+"','"+user.getContra()+"');");

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
    
    public String ultimoID(){
        Connection con = null;
        String salida = "0";
        try{
            con = super.conectar();
            ps = con.prepareStatement("SELECT * FROM usuario ORDER BY idUser DESC limit 1;");
            rs = ps.executeQuery();
            
            salida = rs.getString(2);
        }catch(SQLException e){
            System.out.println(e);
            salida = "mierda";
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
