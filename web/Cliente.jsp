<%-- 
    Document   : Cliente
    Created on : 01-sep-2021, 5:19:24
    Author     : Urban
--%>

<%@page import="Clases.MostarTransaciones"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="Clases.Transaccion"%>
<%@page import="Clases.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/stylesAdmi.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <title>Banco BALR</title>
</head>

<body>
    <header class="header">
        <nav class="navBar">
            <ul class="ul">
                <li class="item">
                    <%
                        User user = (User)session.getAttribute("usuario");
                        
                        ArrayList<Cuenta> alCuenta = (ArrayList<Cuenta>) session.getAttribute("listaCuentaOriginal");
                        
                        if (alCuenta == null || alCuenta.size()==0 || user == null) {
                            response.sendRedirect("index2.jsp");
                        }else{
                            for (Cuenta c : alCuenta) {
                                if (c.getUser().getCorreo().equalsIgnoreCase(user.getCorreo())) {
                                    out.print(c.getNombre());
                                    session.setAttribute("cuenta", c);
                                }
                            }
                        }
                    %></li>
                <li class="item">
                    <form action="CCuenta" method="POST">
                        <button type="submit" class="boton--salir" name="btnSalir">Salir <i class="fas fa-sign-out-alt"></i></button>
                    </form>
                </li>
            </ul>
        </nav>
    </header>


    <div class="container">
        <!-- seccion izquierda -->
        <section class="sectionNuevaCuenta">
            <h2 class="sectionNuevaCuenta__title">Usuario</h2>

            <!-- div informacion de cuenta -->
            <div>
                <!-- seccion de datos de usuario -->
                <section class="sectionUser">
                    <h5 class="sectionUser__title">Interes ganado</h5>
                    <form  method="POST">
                        <input placeholder="Ingresa los años a calcular" name="anosCalcular" class="inputText" required="true" style="width: 100%; margin-bottom: 0.2em">
                        <button type="submit" class="boton boton--verde">Calcular</button>
                    </form>
                    <label>Interes: <%
                        Cuenta c = new Cuenta();
                        try{
                            c = (Cuenta) session.getAttribute("cuenta");
                            if (c==null || session.getAttribute("cuenta") == null) {
                                response.sendRedirect("index2.jsp");
                            }
                            out.print(c.getTipoDeInteres().getTasaInteres());
                        }catch(Exception ex){

                        }
                    %></label>
                    <label>Capital: <%
                        try
                        {
                            out.print(c.getSaldo());
                        }catch(Exception ex){
                        }
                        %></label>
                    <label>Tiempo: <%
                        int anos = 0;
                        try{
                            anos = Integer.parseInt(request.getParameter("anosCalcular"));
                            if (anos>0) {
                                out.print(anos);
                            }else{
                                out.print(0);
                            }
                        }catch(Exception e){
                            out.print(0);
                        }
                        %></label>
                    <label>Interes ganado: <%
                        
                        if (anos>0) {
                            out.print(c.interesGanado(anos));
                        }else{
                            out.print(0);
                        }
                        %></label>
                </section>

                <!-- seccion de datos de cuenta -->
                <section class="sectionCuenta">
                    <h5 class="sectionCuenta__title">Consulta de saldos</h5>
                    <label>Nombre: <%
                        try{
                            out.print(c.estadoCuenta().getNombre()); 
                        }catch(Exception ex){
                        }
                    %></label>
                    <label>N.Cuenta: <% try{
                            out.print(c.estadoCuenta().getnCuenta());
                        }catch(Exception ex){
                        } %></label>
                    <label>Saldo: <%try{
                            out.print(c.estadoCuenta().getSaldo());    
                        }catch(Exception ex){
                            }%></label>
                </section>
            </div>
            </section>


            <!-- seccion derecha -->
            <section class="seccionRegistrados">
                <h2 class="seccionRegistrados__title">Transacción</h2>

                <!-- Formulario para hacer Transacción -->
                <form action="CTransaccion" method="post" class="card__transaccion2">
                    <% out.print("<input name =\"nCuenta\" class=\"nCuenta\" value=\""+c.getCuenta()+"\" readonly style=\"border: none; outline: none;\"></input>"); %>
                    <input type="number" name="txtMonto" step="0.01" class="inputText" required min="0.01" placeholder="Monto">
                    <input type="text" class="inputText" placeholder="Observación" name="txtObservacion" required>
                    <button type="submit" class="boton boton--abonar" name="btnAbonar2">Abonar</button>
                    <button type="submit" class="boton boton--retirar" name="btnRetirar2">Retirar</button>
                </form>
                <!-- seccion de las cartas listas -->
                <div class="cards">
                    <%
                        ArrayList<Transaccion> alTransaccion = (ArrayList<Transaccion>)session.getAttribute("listaTransacciones");
//                        MostarTransaciones mt = c.depositos(alTransaccion);
//                        out.print("<div class=\"card\">"
//                                                 +"<label>"+mt.getNombre()+"</label>"
//                                                 +"<label>Anterior: $"+mt.getSaldoAnterior()+"</label>"
//                                                 +"<label>Actual: $"+mt.getNuevoSaldo()+"</label>"
//                                            + "</div>");
                        if (alTransaccion != null) {
                            int i = 1;
                            for (Transaccion t : alTransaccion) {
                                if (t.getCuenta().getCuenta().trim().equalsIgnoreCase(c.getCuenta().trim())) {
                                    out.print("<div class=\"card\">"
                                                + "<label>"+i+"</label>"
                                                + "<label>Tipo de Transacción: "+t.getTipoTransaccion()+"</label>"
                                                 +"<label>Monto: "+t.getMonto()+"</label>"
                                                 +"<label>Observaciones: "+t.getObservacion()+"</label>"
                                                 +"<label>Fecha: "+t.getFecha().toString()+"</label>"
                                                 +"<label>Hora: "+t.getHora().toString()+"</label>"
                                            + "</div>");
                                    i++;
                                }
                            }
                        }
                    %>
                </div>
            </section>
    </div>
    <script src="js/scriptAdmi.js"></script>
</body>

</html>
