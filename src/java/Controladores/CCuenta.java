/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Cuenta;
import Clases.User;
import Clases.TipoDeInteres;
import Clases.Transaccion;
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
        
        //Creamos una lista de cuentas y obtenemos una lista de cuentas
        ArrayList<Cuenta>alCuenta = (ArrayList<Cuenta>) session.getAttribute("listaCuentaOriginal");
        
        //Si esta nula instanciamos una lista
        if (alCuenta != null) {
            String nombreBusqueda = (String) request.getParameter("txtBuscador").trim();
            ArrayList<Cuenta>alCuentaTem = new ArrayList<>();
            if (nombreBusqueda.length()<1) {
                session.setAttribute("listaCuenta", alCuenta);
                response.sendRedirect("Admi.jsp");
            }else{
                for (Cuenta cuenta : alCuenta) {
                    if (cuenta.getNombre().toLowerCase().contains(nombreBusqueda.toLowerCase())) {
                        alCuentaTem.add(cuenta);
                    }
                }
                session.setAttribute("listaCuenta", alCuentaTem);
            }
        }
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
        if (btnEliminar != null) {
            ArrayList<Cuenta>alCuenta = (ArrayList<Cuenta>) session.getAttribute("listaCuentaOriginal");
            ArrayList<Cuenta>alCuentaInsertar = new ArrayList<>();
            String nCuenta = request.getParameter("nCuenta");
            for (Cuenta c : alCuenta) {
                if (!c.getCuenta().equalsIgnoreCase(nCuenta)) {
                    alCuentaInsertar.add(c);
                }
            }
            session.setAttribute("listaCuenta", alCuentaInsertar);
            session.setAttribute("listaCuentaOriginal", alCuentaInsertar);
            response.sendRedirect("Admi.jsp");
        }else if(btnActualizar != null){
            ArrayList<Cuenta>alCuenta = (ArrayList<Cuenta>) session.getAttribute("listaCuentaOriginal");
            ArrayList<Cuenta>alCuentaInsertar = new ArrayList<>();
            String nCuenta = request.getParameter("nCuenta");
            for (Cuenta c : alCuenta) {
                if (!c.getCuenta().equalsIgnoreCase(nCuenta)) {
                    alCuentaInsertar.add(c);
                }else{
                    alCuentaInsertar.add(new Cuenta(request.getParameter("txtNombreA"), nCuenta,c.getSaldo(), c.getTipoDeInteres(), new User(0, request.getParameter("txtCorreoA"), request.getParameter("txtContraA"))));
                }
            }
            session.setAttribute("listaCuenta", alCuentaInsertar);
            session.setAttribute("listaCuentaOriginal", alCuentaInsertar);
            response.sendRedirect("Admi.jsp");
        }else if(btnSalir != null){
            session.removeAttribute("usuario");
            response.sendRedirect("index2.jsp");
        }else{
            Cuenta cuenta = new Cuenta();
            Transaccion transaccion = new Transaccion();
            ArrayList<Transaccion>alTransaccion = (ArrayList<Transaccion>) session.getAttribute("listaTransacciones");

            if (alTransaccion==null) {
                alTransaccion = new ArrayList<>();
            }
            
            cuenta.setUser(new User(0, request.getParameter("txtCorreoN").trim(), request.getParameter("txtContraN").trim()));
            cuenta.setCuenta(String.valueOf(request.getParameter("txtNCuentaN").trim()));
            cuenta.setNombre(request.getParameter("txtNombreN").trim());
            cuenta.setSaldo(Double.parseDouble(request.getParameter("txtSaldo").trim()));
            cuenta.setTipoDeInteres(new TipoDeInteres(request.getParameter("optionInteres").trim(), 
                    Double.parseDouble(request.getParameter("txtInteres").trim())));
            transaccion.setCuenta(cuenta);
                transaccion.setFecha(LocalDate.now());
                transaccion.setHora(LocalTime.now());
                transaccion.setMonto(cuenta.getSaldo());
                transaccion.setObservacion("Capital inicial");
                transaccion.setTipoTransaccion("Abono");
                alTransaccion.add(transaccion);
            //Creamos una lista de cuentas y obtenemos una lista de cuentas
            ArrayList<Cuenta>alCuenta = (ArrayList<Cuenta>) session.getAttribute("listaCuentaOriginal");

            //Si esta nula instanciamos una lista
            if (alCuenta == null) {
                alCuenta = new ArrayList<>();
            }

            //Agregamos la cuenta a la lista
            alCuenta.add(cuenta);
            session.setAttribute("listaTransacciones", alTransaccion);
            session.setAttribute("listaCuenta", alCuenta);
            session.setAttribute("listaCuentaOriginal", alCuenta);
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
