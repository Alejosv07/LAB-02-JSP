/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Cuenta;
import Clases.Cuentabd;
import Clases.User;
import Clases.TipoDeInteres;
import Clases.TipoDeInteresbd;
import Clases.Transaccion;
import Clases.Transaccionbd;
import Clases.Userbd;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Urban
 */
@WebServlet(name = "CCuenta", urlPatterns = {"/CCuenta"})
public class CCuenta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CCuenta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CCuenta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cuentabd cbd = new Cuentabd();
        //Creamos una lista de cuentas y obtenemos una lista de cuentas
        ArrayList<Cuenta>alCuenta = cbd.listaCuenta((String)request.getParameter("txtBuscador").trim());
        response.sendRedirect("Admi.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String btnEliminar = request.getParameter("btnEliminar");
        String btnActualizar = request.getParameter("btnActualizar");
        String btnSalir = request.getParameter("btnSalir");
        
        
        Cuentabd cbd = new Cuentabd();
        Userbd usb = new Userbd();
        Cuenta c = new Cuenta();
        
        
        if (btnEliminar != null) {
            c = (Cuenta)session.getAttribute("cuenta");
            if (c != null) {
                cbd.eliminarCuenta(c);
                usb.eliminarUsuario(c.getUser());
            }
            response.sendRedirect("Admi.jsp");
        }else if(btnActualizar != null){
            c = (Cuenta)session.getAttribute("cuenta");
            if (c != null) {
                cbd.actualizarCuenta(c);
                usb.actualizarUsuario(c.getUser());
            }
            response.sendRedirect("Admi.jsp");
        }else if(btnSalir != null){
            session.removeAttribute("cuenta");
            response.sendRedirect("index2.jsp");
        }else{
            User user = new User();
            
            
            user.setCorreo(request.getParameter("txtCorreoN").trim());
            user.setContra(request.getParameter("txtContraN").trim());
            
            usb.agregarUsuario(user);
            
            user.setIdUser((int)session.getAttribute("idUser")+1);
//            user.setIdUser(1);
            
            
            TipoDeInteresbd tbd = new TipoDeInteresbd();
            TipoDeInteres tp = new TipoDeInteres();
            
            tp.setNombreInteres("Interes simple");
            tp.setTasaInteres(Double.parseDouble(request.getParameter("txtInteres")));
            
            tbd.agregarTipoDeInteres(tp);
            
            tp.setIdTipoDeInteres((int)session.getAttribute("idTipoDeInteres")+1);
//            tp.setIdTipoDeInteres(1);
            
            Cuenta cuenta = new Cuenta();
            
//            cuenta.setIdCuenta(Integer.parseInt(request.getParameter("txtNCuentaN").trim()));
            cuenta.setNombre(request.getParameter("txtNombreN").trim());
            cuenta.setUser(user);
            cuenta.setSaldo(Double.parseDouble(request.getParameter("txtSaldo").trim()));
            cuenta.setTipoDeInteres(tp);
            
            cbd.agregarCuenta(cuenta);

            cuenta.setIdCuenta((int)session.getAttribute("idCuenta"));
//            cuenta.setIdCuenta(1);
            
            Transaccion transaccion = new Transaccion();
            transaccion.setCuenta(cuenta);
            transaccion.setTipoTransaccion("Abono");
            transaccion.setMonto(cuenta.getSaldo());
            transaccion.setObservacion("Capital inicial");
            transaccion.setFecha(LocalDate.now().toString());
            
            new Transaccionbd().insertarTransaccion(transaccion);
            response.sendRedirect("Admi.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
