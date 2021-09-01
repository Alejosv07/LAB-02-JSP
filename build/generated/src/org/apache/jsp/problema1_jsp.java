package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.regex.Pattern;
import java.util.ArrayList;
import Clases.numeroAleatorio;

public final class problema1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("          <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\n");
      out.write("            <div class=\"navbar-nav\">\n");
      out.write("              <button class=\"btn btn-dark\" type=\"menu\"><a class=\"nav-link active\" aria-current=\"page\">Problema 1</a></button>\n");
      out.write("              <button class=\"btn btn-dark\" type=\"menu\"><a class=\"nav-link active\" aria-current=\"page\">Problema 2</a></button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </nav>\n");
      out.write("      <br><br>\n");
      out.write("        ");

            numeroAleatorio numero;
            if (session.getAttribute("numero") == null) {
                numero = new numeroAleatorio(new ArrayList<Integer>());
                session.setAttribute("numero", numero);
                //out.print(numero.getSecreto());
            } else {
                numero = (numeroAleatorio) session.getAttribute("numero");
                //out.print(numero.getSecreto());
            }
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"col-6 offset-3\">\n");
      out.write("                <form style=\"margin: 5%;\" action=\"#\" method=\"GET\">\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"idNumero\" class=\"form-label\">Ingrese un numero entre ");
 out.print(numero.numeroMenor); 
      out.write(" y ");
 out.print(numero.numeroMayor); 
      out.write("</label>\n");
      out.write("                        <input type=\"number\" class=\"form-control\" id=\"idNumero\" name=\"numero\">\n");
      out.write("                        <div id=\"idNumeroAyuda\" class=\"form-text\">En cada nuevo intento obtendra pistas de su proximidad</div>\n");
      out.write("                    </div>\n");
      out.write("                    <center>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <input type=\"submit\" name=\"reiniciar\" value=\"Reiniciar\" class=\"btn btn-dark\" style=\"width: 40%;\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <input type=\"submit\" name=\"submit\" value=\"Ingresar\" class=\"btn btn-dark\" style=\"width: 100%;\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <input type=\"submit\" name=\"rendirse\" value=\"Rendirse\" class=\"btn btn-dark\" style=\"width: 40%;\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </center>\n");
      out.write("                </form>\n");
      out.write("                ");

                    if (request.getParameter("submit") != null && request.getParameter("submit") != "") {
                        if (request.getParameter("numero") != null && request.getParameter("numero") != ""
                                && Integer.parseInt(request.getParameter("numero")) >= numero.numeroMenor && Integer.parseInt(request.getParameter("numero")) <= numero.numeroMayor) {
                            numero.setAlerta(Integer.parseInt(request.getParameter("numero")));
                            switch (numero.getAlerta()) {
                                case "warning":
                                    out.print("<div class=\"alert alert-");
                                    out.print(numero.getAlerta());
                                    out.print("\" role=\"alert\"><center>");
                                    out.print("Numero incorrecto: <strong>" + request.getParameter("numero") + "</strong>. Intenta con un numero <strong>");
                                    numero.setPista(Integer.parseInt(request.getParameter("numero")));
                                    out.print(numero.getPista());
                                    out.print("</strong></center>");
                                    out.print("\n<center>");
                                    numero.setNumerosProximos(Integer.parseInt(request.getParameter("numero")));
                                    out.print("El numero esta entre <strong>" + numero.numeroMenorProximo + "</strong> y <strong>" + numero.numeroMayorProximo + "</strong>");
                                    out.print("</center></div>");
                                    break;
                                case "danger":
                                    out.print("<div class=\"alert alert-");
                                    out.print(numero.getAlerta());
                                    out.print("\" role=\"alert\"><center>");
                                    out.print("Mas suerte la proxima...el numero secreto era <strong>" + numero.getSecreto() + "</strong></center></div>");
                                    break;
                                case "success":
                                    out.print("<div class=\"alert alert-");
                                    out.print(numero.getAlerta());
                                    out.print("\" role=\"alert\"><center>");
                                    out.print("Acertaste en tu <strong>" + (numero.getNumeroElegido().size() + 1) + "</strong> intento!!! el numero screto era: <strong>" + numero.getSecreto() + "</strong></center></div>");
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                        } else if (request.getParameter("numero") != null && request.getParameter("numero") != ""
                                && Pattern.matches("[0-9]+[\\.]?[0-9]*", request.getParameter("numero"))) {
                            out.print("<div class=\"alert alert-");
                            out.print("danger");
                            out.print("\" role=\"alert\"><center>");
                            out.print("Sigue las indicaciones! Ingresa un numero entre el rango " + numero.numeroMenor + " y " + numero.numeroMayor + "</center></div>");
                        }
                        try {
                            if (request.getParameter("numero") != null && request.getParameter("numero") != ""
                                    && Integer.parseInt(request.getParameter("numero")) >= numero.numeroMenor && Integer.parseInt(request.getParameter("numero")) <= numero.numeroMayor) {
                                if (numero.getNumeroElegido().size() < 10) {
                                    numero.setNumeroElegido(Integer.parseInt(request.getParameter("numero")));
                                }

                                if (numero.getNumeroElegido().size() < 11) {
                                    out.print("<table class=\"table\">");
                                    out.print("<thead>");
                                    out.print("<tr>");
                                    out.print("<th scope=\"col\" style=\"text-align: center;\">Intento</th>");
                                    out.print("<th scope=\"col\" style=\"text-align: center;\">Numero elegido</th>");
                                    out.print("<tr>");
                                    out.print("</thead>");
                                    out.print("<tbody>");
                                    for (int i = 0; i < numero.getNumeroElegido().size(); i++) {
                                        try {
                                            out.print("<tr>");
                                            out.print("<th scope=\"col\" style=\"text-align: center;\">" + (i + 1) + "</th>");
                                            out.print("<th scope=\"col\" style=\"text-align: center;\">" + (numero.numeroElegido.get(i)) + "</th>");
                                        } catch (Exception e) {
                                            out.print("<tr>");
                                            out.print("<th scope=\"col\" style=\"text-align: center;\">" + (i + 1) + "</th>");
                                            out.print("<th scope=\"col\" style=\"text-align: center;\">" + (numero.getSecreto()) + "</th>");
                                        }
                                        out.print("<tr>");
                                    }
                                    out.print("</tbody>");
                                    out.print("</table>");
                                }

                            } else {
                                if (numero.getNumeroElegido().size() < 11) {
                                    out.print("<table class=\"table\">");
                                    out.print("<thead>");
                                    out.print("<tr>");
                                    out.print("<th scope=\"col\" style=\"text-align: center;\">Intento</th>");
                                    out.print("<th scope=\"col\" style=\"text-align: center;\">Numero elegido</th>");
                                    out.print("<tr>");
                                    out.print("</thead>");
                                    out.print("<tbody>");
                                    for (int i = 0; i < numero.getNumeroElegido().size(); i++) {
                                        try {
                                            out.print("<tr>");
                                            out.print("<th scope=\"col\" style=\"text-align: center;\">" + (i + 1) + "</th>");
                                            out.print("<th scope=\"col\" style=\"text-align: center;\">" + (numero.numeroElegido.get(i)) + "</th>");
                                        } catch (Exception e) {
                                            out.print("<tr>");
                                            out.print("<th scope=\"col\" style=\"text-align: center;\">" + (i + 1) + "</th>");
                                            out.print("<th scope=\"col\" style=\"text-align: center;\">" + (numero.getSecreto()) + "</th>");
                                        }
                                        out.print("<tr>");
                                    }
                                    out.print("</tbody>");
                                    out.print("</table>");
                                }
                            }
                        } catch (Exception e) {
                            out.print("Ingrese un numero");
                        }
                    } else if (request.getParameter("reiniciar") != null && request.getParameter("reiniciar") != "") {
                        session.removeAttribute("numero");
                    } else if (request.getParameter("rendirse") != null && request.getParameter("rendirse") != "") {
                        out.print("<div class=\"alert alert-");
                        out.print("secondary");
                        out.print("\" role=\"alert\"><center>");
                        out.print("Te rendiste :( el numero secreto era " + numero.getSecreto() + "</center></div>");
                        session.removeAttribute("numero");
                    }

                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
