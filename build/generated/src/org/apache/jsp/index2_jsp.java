package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.Userbd;
import Clases.Conexion;
import java.sql.Connection;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta name=\"google-signin-scope\" content=\"profile email\">\n");
      out.write("    <meta name=\"google-signin-client_id\" content=\"958494741918-haqmha152e2duquusg4t89chk2b15b5q.apps.googleusercontent.com\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/stylesIndex.css\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\n");
      out.write("    <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n");
      out.write("    <title>Banco BALR</title>\n");
      out.write("   </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("            <div class=\"container\" style=\"height: 52px\">\n");
      out.write("          <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\n");
      out.write("            <div class=\"navbar-nav\">\n");
      out.write("                <button class=\"btn btn-dark\" type=\"menu\"><a class=\"nav-link\" aria-current=\"page\" href=\"index.jsp\">Problema 1</a></button>\n");
      out.write("                <button class=\"btn btn-dark\" type=\"menu\"><a class=\"nav-link\" aria-current=\"page\" href=\"index2.jsp\">Problema 2</a></button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </nav>\n");
      out.write("    <main>\n");
      out.write("        <section class=\"container\">\n");
      out.write("            <div class=\"containerLogo\">\n");
      out.write("                <img src=\"Assets/img/Banco-agricola-sv.png\" alt=\"\" class=\"containerLogo__logo\">\n");
      out.write("                <small class=\"containerLogo__logoFooter\">El Salvador cuenta con nosotros</small>\n");
      out.write("            </div>\n");
      out.write("            <form action=\"CEjercici02\" method=\"POST\" class=\"formInicioSesion\">\n");
      out.write("                <div id=\"frmGoogle\">\n");
      out.write("                   <div class=\"g-signin2\" data-onsuccess=\"onSignIn\" data-theme=\"dark\" style=\"margin-bottom: 0.5em;\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"formInicioSesion__campo\">\n");
      out.write("                    <input type=\"text\" name=\"txtUsuario\" class=\"formInicioSesion__inputText\" placeholder=\"Usuario\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"formInicioSesion__campo\">\n");
      out.write("                    <input type=\"text\" name=\"txtContra\" class=\"formInicioSesion__inputText\" placeholder=\"Contraseña\">\n");
      out.write("                </div>\n");
      out.write("                <input type=\"submit\" value=\"Ingresar\" class=\"boton\">\n");
      out.write("                <a href=\"#\" class=\"link\">¿Olvidaste la Contraseña?");

                    Connection con = new Conexion().conectar();
                    Userbd user = new Userbd();
                    out.print(user.ultimoID());
                    
      out.write("</a>\n");
      out.write("            </form>\n");
      out.write("        </section>\n");
      out.write("    </main>\n");
      out.write("      <script>\n");
      out.write("      function onSignIn(googleUser) {\n");
      out.write("        // Useful data for your client-side scripts:\n");
      out.write("        var profile = googleUser.getBasicProfile();\n");
      out.write("        console.log(\"ID: \" + profile.getId()); // Don't send this directly to your server!\n");
      out.write("        console.log('Full Name: ' + profile.getName());\n");
      out.write("        console.log('Given Name: ' + profile.getGivenName());\n");
      out.write("        console.log('Family Name: ' + profile.getFamilyName());\n");
      out.write("        console.log(\"Image URL: \" + profile.getImageUrl());\n");
      out.write("        console.log(\"Email: \" + profile.getEmail());\n");
      out.write("        var auth2 = gapi.auth2.getAuthInstance();\n");
      out.write("        auth2.signOut().then(function () {\n");
      out.write("          console.log('User signed out.');\n");
      out.write("        });\n");
      out.write("        window.location.href = \"authPag.jsp?email=\"+profile.getEmail();\n");
      out.write("        // The ID token you need to pass to your backend:\n");
      out.write("        var id_token = googleUser.getAuthResponse().id_token;\n");
      out.write("        console.log(\"ID Token: \" + id_token);\n");
      out.write("      }\n");
      out.write("    </script>\n");
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
