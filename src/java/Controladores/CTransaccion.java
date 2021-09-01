/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Cuenta;
import Clases.Transaccion;
import Clases.User;
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
@WebServlet(name = "CTransaccion", urlPatterns = {"/CTransaccion"})
public class CTransaccion extends HttpServlet {

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
            out.println("<title>Servlet CTransaccion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CTransaccion at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String btnAbonar = request.getParameter("btnAbonar");
        String btnRetirar = request.getParameter("btnRetirar");
        String btnAbonar2 = request.getParameter("btnAbonar2");
        String btnRetirar2 = request.getParameter("btnRetirar2");
        
        ArrayList<Transaccion>alTransaccion = (ArrayList<Transaccion>) session.getAttribute("listaTransacciones");
        ArrayList<Cuenta>alCuenta = (ArrayList<Cuenta>) session.getAttribute("listaCuentaOriginal");
        ArrayList<Cuenta>alCuentaInsertar = new ArrayList<>();
        String nCuenta = request.getParameter("nCuenta");
        
        if (alTransaccion==null) {
            alTransaccion = new ArrayList<>();
        }
        //Obtenemos los datos y los hacemos objeto de tipo transaccion
        Transaccion transaccion = new Transaccion();
        double monto = Double.parseDouble(request.getParameter("txtMonto"));
        for (Cuenta c : alCuenta) {
            if (c.getCuenta().equalsIgnoreCase(nCuenta) && c.getSaldo()> monto) {
                transaccion.setCuenta(c);
                transaccion.setFecha(LocalDate.now());
                transaccion.setHora(LocalTime.now());
                transaccion.setMonto(monto);
                double resultado = 0;
                transaccion.setObservacion(request.getParameter("txtObservacion"));
                if (btnAbonar != null || btnAbonar2 != null) {
                    transaccion.setTipoTransaccion("Abono");
                    resultado = c.getSaldo()+monto;
                }else if(btnRetirar != null || btnRetirar2 != null){
                    resultado = c.getSaldo()-monto;
                    transaccion.setTipoTransaccion("Retiro");
                }
                alTransaccion.add(transaccion);
                alCuentaInsertar.add(new Cuenta(c.getNombre(), nCuenta, resultado, c.getTipoDeInteres(), c.getUser()));
                session.setAttribute("listaTransacciones", alTransaccion);
                session.setAttribute("listaCuenta", alCuentaInsertar);
                session.setAttribute("listaCuentaOriginal", alCuentaInsertar);
            }else{
                alCuentaInsertar.add(c);
            }
        }
        if (btnRetirar != null || btnAbonar != null) {
            response.sendRedirect("Admi.jsp");
        }else{
            response.sendRedirect("Cliente.jsp");
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
