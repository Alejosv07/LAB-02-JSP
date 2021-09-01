/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Cuenta;
import Clases.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CEjercici02", urlPatterns = {"/CEjercici02"})
public class CEjercici02 extends HttpServlet {

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
            out.println("<title>Servlet CEjercici02</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CEjercici02 at " + request.getContextPath() + "</h1>");
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
        User user = new User(0,request.getParameter("txtUsuario").trim(),request.getParameter("txtContra").trim());
        
        //Obtenemos la sesion
        HttpSession session = request.getSession();
        
        //Creamo una lista de cuentas
        ArrayList<Cuenta> alCuenta = new ArrayList<>();
        
        //Obtenemos una lista de cuentas
        alCuenta = (ArrayList<Cuenta>) session.getAttribute("listaCuentaOriginal");
        if (user.getCorreo().equalsIgnoreCase("root") && user.getContra().equals("root")) {
            session.setAttribute("usuario", user);
            response.sendRedirect("Admi.jsp");
        }else
        if (alCuenta != null && alCuenta.size()>0) {
            for (Cuenta cuenta : alCuenta) {
                if (user.getCorreo().equalsIgnoreCase(cuenta.getUser().getCorreo().trim())
                        && user.getContra().equals(cuenta.getUser().getContra().trim())) {
                    session.setAttribute("usuario", user);
                    response.sendRedirect("Cliente.jsp");
                }
            }
        }else{
            response.sendRedirect("index.jsp");
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
