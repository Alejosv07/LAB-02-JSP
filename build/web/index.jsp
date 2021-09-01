<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.numeroAleatorio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
          <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <button class="btn btn-dark" type="menu"><a class="nav-link" aria-current="page" href="index.jsp">Problema 1</a></button>
                <button class="btn btn-dark" type="menu"><a class="nav-link" aria-current="page" href="index2.jsp">Problema 2</a></button>
            </div>
          </div>
        </div>
      </nav>
      <br><br>
        <%
            numeroAleatorio numero;
            if (session.getAttribute("numero") == null) {
                numero = new numeroAleatorio(new ArrayList<Integer>());
                session.setAttribute("numero", numero);
                //out.print(numero.getSecreto());
            } else {
                numero = (numeroAleatorio) session.getAttribute("numero");
                //out.print(numero.getSecreto());
            }
        %>
        <div class="container">
            <div class="col-6 offset-3">
                <form style="margin: 5%;" action="#" method="GET">
                    <div class="mb-3">
                        <label for="idNumero" class="form-label">Ingrese un numero entre <% out.print(numero.numeroMenor); %> y <% out.print(numero.numeroMayor); %></label>
                        <input type="number" class="form-control" id="idNumero" name="numero" min="0" max="1000">
                        <div id="idNumeroAyuda" class="form-text">En cada nuevo intento obtendra pistas de su proximidad</div>
                    </div>
                    <center>
                        <div class="row">
                            <div class="col">
                                <input type="submit" name="reiniciar" value="Reiniciar" class="btn btn-dark" style="width: 56%;">
                            </div>
                            <div class="col">
                                <input type="submit" name="submit" value="Ingresar" class="btn btn-dark" style="width: 100%;">
                            </div>
                            <div class="col">
                                <input type="submit" name="rendirse" value="Rendirse" class="btn btn-dark" style="width: 56%;">
                            </div>
                        </div>
                    </center>
                </form>
                <%
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

                %>
            </div>
        </div>
    </body>
</html>
