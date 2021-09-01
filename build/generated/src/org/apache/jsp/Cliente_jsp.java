package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.Transaccion;
import Clases.Cuenta;
import java.util.ArrayList;
import Clases.User;

public final class Cliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/stylesAdmi.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.15.4/css/all.css\" integrity=\"sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm\" crossorigin=\"anonymous\">\n");
      out.write("    <title>Banco BALR</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <nav class=\"navBar\">\n");
      out.write("            <ul class=\"ul\">\n");
      out.write("                <li class=\"item\">\n");
      out.write("                    ");

                        User user = (User)session.getAttribute("usuario");
                        
                        ArrayList<Cuenta> alCuenta = (ArrayList<Cuenta>) session.getAttribute("listaCuentaOriginal");
                        
                        if (alCuenta == null || alCuenta.size()==0 || user == null) {
                            response.sendRedirect("index.jsp");
                        }else{
                            for (Cuenta c : alCuenta) {
                                if (c.getUser().getCorreo().equalsIgnoreCase(user.getCorreo())) {
                                    out.print(c.getNombre());
                                    session.setAttribute("cuenta", c);
                                }
                            }
                        }
                    
      out.write("</li>\n");
      out.write("                <li class=\"item\">\n");
      out.write("                    <form action=\"CCuenta\" method=\"POST\">\n");
      out.write("                        <button type=\"submit\" class=\"boton--salir\" name=\"btnSalir\">Salir <i class=\"fas fa-sign-out-alt\"></i></button>\n");
      out.write("                    </form>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- seccion izquierda -->\n");
      out.write("        <section class=\"sectionNuevaCuenta\">\n");
      out.write("            <h2 class=\"sectionNuevaCuenta__title\">Usuario</h2>\n");
      out.write("\n");
      out.write("            <!-- div informacion de cuenta -->\n");
      out.write("            <div>\n");
      out.write("                <!-- seccion de datos de usuario -->\n");
      out.write("                <section class=\"sectionUser\">\n");
      out.write("                    <h5 class=\"sectionUser__title\">Usuario</h5>\n");
      out.write("                    <label>Correo: ");
 Cuenta 
                            c = (Cuenta) session.getAttribute("cuenta");
                            out.print(c.getUser().getCorreo());
                    
      out.write("</label>\n");
      out.write("                    <label>Contraseña: ");

                        c.getUser().getContra();
                        
      out.write("</label>\n");
      out.write("                </section>\n");
      out.write("\n");
      out.write("                <!-- seccion de datos de cuenta -->\n");
      out.write("                <section class=\"sectionCuenta\">\n");
      out.write("                    <h5 class=\"sectionCuenta__title\">Cuenta</h5>\n");
      out.write("                    <label>Nombre: ");
 out.print(c.getNombre()); 
      out.write("</label>\n");
      out.write("                    <label>N.Cuenta: ");
 out.print(c.getCuenta()); 
      out.write("</label>\n");
      out.write("                    <label>Saldo: ");
 out.print(c.getSaldo()); 
      out.write("</label>\n");
      out.write("                    <label>Tipo de interes: ");
 out.print(c.getTipoDeInteres().getNombreInteres()); 
      out.write("</label>\n");
      out.write("                    <label>Interes(% mensual): ");
 out.print(c.getTipoDeInteres().getTasaInteres()); 
      out.write("</label>\n");
      out.write("            </div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- seccion derecha -->\n");
      out.write("            <section class=\"seccionRegistrados\">\n");
      out.write("                <h2 class=\"seccionRegistrados__title\">Transacción</h2>\n");
      out.write("\n");
      out.write("                <!-- Formulario para hacer Transacción -->\n");
      out.write("                <form action=\"#\" method=\"post\" class=\"card__transaccion2\">\n");
      out.write("                    <input type=\"number\" step=\"0.01\" required min=\"0.01\" placeholder=\"Monto\">\n");
      out.write("                    <input type=\"text\" class=\"inputText\" placeholder=\"Observación\" required>\n");
      out.write("                    <button type=\"submit\" class=\"boton boton--abonar\">Abonar</button>\n");
      out.write("                    <button type=\"submit\" class=\"boton boton--retirar\">Retirar</button>\n");
      out.write("                </form>\n");
      out.write("                <!-- seccion de las cartas listas -->\n");
      out.write("                <div class=\"cards\">\n");
      out.write("                    ");

                        ArrayList<Transaccion> alTransaccion = (ArrayList<Transaccion>)session.getAttribute("listaTransacciones");
                        
                        if (alTransaccion != null) {
                            for (Transaccion t : alTransaccion) {
                                if (t.getCuenta() == c) {
                                    out.print("<div class=\"card\">"
                                                + "<label>Tipo de Transacción: "+t.getTipoTransaccion()+"</label>"
                                                 +"<label>Monto: "+t.getMonto()+"</label>"
                                                 +"<label>Observaciones: "+t.getObservacion()+"</label>"
                                                 +"<label>Fecha: "+t.getFecha().toString()+"</label>"
                                                 +"<label>Hora: "+t.getHora().toString()+"</label>"
                                            + "</div>");
                                }
                            }
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"js/scriptAdmi.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
