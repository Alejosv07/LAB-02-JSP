package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.Cuentabd;
import java.util.ArrayList;
import Clases.Cuenta;
import Clases.User;

public final class Admi_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                <li class=\"item\">root</li>\n");
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
      out.write("            <h2 class=\"sectionNuevaCuenta__title\">Crear Cuenta</h2>\n");
      out.write("\n");
      out.write("            <!-- formulario para crear una nueva cuenta -->\n");
      out.write("            <form action=\"CCuenta\" method=\"POST\">\n");
      out.write("\n");
      out.write("                <!-- seccion de datos de usuario -->\n");
      out.write("                <section class=\"sectionUser\">\n");
      out.write("                    <h5 class=\"sectionUser__title\">Usuario</h5>\n");
      out.write("                    <input type=\"email\" name=\"txtCorreoN\" placeholder=\"Correo Electronico\" required class=\"inputText\" value=\"basdl@gmail\">\n");
      out.write("                    <input type=\"text\" name=\"txtContraN\" placeholder=\"Contraseña\" required class=\"inputText\" value=\"123\">\n");
      out.write("                </section>\n");
      out.write("\n");
      out.write("                <!-- seccion de datos de cuenta -->\n");
      out.write("                <section class=\"sectionCuenta\">\n");
      out.write("                    <h5 class=\"sectionCuenta__title\">Cuenta</h5>\n");
      out.write("                    <input type=\"text\" name=\"txtNombreN\" placeholder=\"Nombre\" required class=\"inputText\" value=\"Alejs\">\n");
      out.write("\n");
      out.write("                    <!-- campo de seccion cuenta -->\n");
      out.write("                    <div class=\"sectionCuenta__campo\">\n");
      out.write("                        <input type=\"number\" name=\"txtNCuentaN\" placeholder=\"Numero de cuenta\" required class=\"inputText\" min=\"1000000000000000\" max=\"9999999999999999\" step=\"1\" id=\"txtNRandom\">\n");
      out.write("                        <button class=\"boton boton--random\" id=\"btnGenerarNcuenta\" type=\"button\"><i class=\"fas fa-random\"></i></button>\n");
      out.write("                    </div>\n");
      out.write("                    <input type=\"number\" name=\"txtSaldo\" placeholder=\"Saldo\" required class=\"inputText\" min=0.01 step=\"0.01\" value=\"100\">\n");
      out.write("\n");
      out.write("                    <!-- Seccion de tipo de interes -->\n");
      out.write("                    <section class=\"sectionTipoInteres\">\n");
      out.write("                        <h5 class=\"sectionTipoInteres__title\">\n");
      out.write("                            Tipo de interes\n");
      out.write("                        </h5>\n");
      out.write("                        <select name=\"optionInteres\" id=\"\" class=\"select\">\n");
      out.write("                            <option value=\"Interes simple\" selected=\"true\">Interés simple</option>\n");
      out.write("                        </select>\n");
      out.write("                    </section>\n");
      out.write("                    <input type=\"number\" name=\"txtInteres\" placeholder=\"Interes(% anual)\" required class=\"inputText\" min=0.01 step=\"0.01\" value=\"10\">\n");
      out.write("                </section>\n");
      out.write("                <input type=\"submit\" value=\"Crear cuenta\" class=\"boton boton--verde\">\n");
      out.write("            </form>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- seccion derecha -->\n");
      out.write("        <section class=\"seccionRegistrados\">\n");
      out.write("            <h2 class=\"seccionRegistrados__title\">Cuentas registradas</h2>\n");
      out.write("\n");
      out.write("            <!-- seccion de busqueda -->\n");
      out.write("            <form action=\"CCuenta\" method=\"get\" class=\"buscador\">\n");
      out.write("                <input type=\"text\" name=\"txtBuscador\" placeholder=\"Buscador por nombres\" class=\"inputText buscador__txt\">\n");
      out.write("                <button type=\"submit\" class=\"buscador__boton\"><i class=\"fas fa-search\"></i></button>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <!-- seccion de las cartas listas -->\n");
      out.write("            <div class=\"cards\">\n");
      out.write("                ");
 
                    //Creamos una lista de cuentas
                    ArrayList<Cuenta>alCuenta = new ArrayList<>();

                    Cuentabd cbd = new Cuentabd();
                    //Obtenemos una lista de cuentas
                    alCuenta = cbd.listaCuenta("");

                    
                    //Session test
                    int idUser = 0;
                    int idTipoDeInteres = 0;
                    int idCuenta = 0;
                    //Agregamos la cuenta a la lista
                    if (alCuenta != null) {
                        out.print(session.getAttribute("idUser"));
                        for (Cuenta c : alCuenta) {
                            
                            
                            idUser = c.getUser().getIdUser();
                            session.setAttribute("idUser", idUser);
                            
                            idTipoDeInteres = c.getTipoDeInteres().getIdTipoDeInteres();
                            session.setAttribute("idTipoDeInteres", idTipoDeInteres);
                            
                            idCuenta = c.getIdCuenta();
                            session.setAttribute("idCuenta", idCuenta);
                            
                            out.print("<form action=\"CCuenta\" method=\"post\" class=\"card\">"
                                        + "<input name =\"nCuenta\" class=\"nCuenta\" value=\""+c.getIdCuenta()+"\" readonly style=\"border: none; outline: none;\"></input>"
                                        + "<label class=\"nombreCuenta\">"+c.getNombre()+"</label>"
                                        + "<label class=\"nombreCuenta\" style=\"display: none;\">"+c.getUser().getContra()+"</label>"
                                        + "<label class=\"nombreCuenta\" style=\"display: none;\">"+c.getUser().getCorreo()+"</label>"
                                        + "<label class=\"saldo\">"+c.getSaldo()+"</label>"
                                        + " <button class=\"boton boton--transaccion\"  type=\"button\">Transacción</button>"
                                        + "<button class=\"boton boton--actualizar\" type=\"button\"><i class=\"fas fa-pen\"></i></button>"
                                        + "<button name=\"btnEliminar\" class=\"boton boton--eliminar\" type=\"submit\"><i class=\"fas fa-backspace\"></i></button>"
                                        + "<div class=\"card__transaccion\">"
                                            + "<button class=\"boton boton--cancelar\" type=\"button\"><i class=\"far fa-times-circle\"></i></button>"
                                        + "</div>"
                                    + "</form>");
                        }
                    }
                
      out.write(" \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <script src=\"js/scriptAdmi.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
