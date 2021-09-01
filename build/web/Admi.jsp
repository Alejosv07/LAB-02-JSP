<%-- 
    Document   : Admi
    Created on : 27-ago-2021, 0:31:08
    Author     : Urban
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Cuenta"%>
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
                <li class="item">root</li>
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
            <h2 class="sectionNuevaCuenta__title">Crear Cuenta</h2>

            <!-- formulario para crear una nueva cuenta -->
            <form action="CCuenta" method="POST">

                <!-- seccion de datos de usuario -->
                <section class="sectionUser">
                    <h5 class="sectionUser__title">Usuario</h5>
                    <input type="email" name="txtCorreoN" placeholder="Correo Electronico" required class="inputText">
                    <input type="text" name="txtContraN" placeholder="Contraseña" required class="inputText">
                </section>

                <!-- seccion de datos de cuenta -->
                <section class="sectionCuenta">
                    <h5 class="sectionCuenta__title">Cuenta</h5>
                    <input type="text" name="txtNombreN" placeholder="Nombre" required class="inputText">

                    <!-- campo de seccion cuenta -->
                    <div class="sectionCuenta__campo">
                        <input type="number" name="txtNCuentaN" placeholder="Numero de cuenta" required class="inputText" min="1000000000000000" max="9999999999999999" step="1" id="txtNRandom">
                        <button class="boton boton--random" id="btnGenerarNcuenta" type="button"><i class="fas fa-random"></i></button>
                    </div>
                    <input type="number" name="txtSaldo" placeholder="Saldo" required class="inputText" min=0.01 step="0.01">

                    <!-- Seccion de tipo de interes -->
                    <section class="sectionTipoInteres">
                        <h5 class="sectionTipoInteres__title">
                            Tipo de interes
                        </h5>
                        <select name="optionInteres" id="" class="select">
                            <option value="Interes simple">Interés simple</option>
                        </select>
                    </section>
                    <input type="number" name="txtInteres" placeholder="Interes(% mensual)" required class="inputText" min=0.01 step="0.01">
                </section>
                <input type="submit" value="Crear cuenta" class="boton boton--verde">
            </form>
        </section>


        <!-- seccion derecha -->
        <section class="seccionRegistrados">
            <h2 class="seccionRegistrados__title">Cuentas registradas</h2>

            <!-- seccion de busqueda -->
            <form action="CCuenta" method="get" class="buscador">
                <input type="text" name="txtBuscador" placeholder="Buscador por nombres" class="inputText buscador__txt">
                <button type="submit" class="buscador__boton"><i class="fas fa-search"></i></button>
            </form>

            <!-- seccion de las cartas listas -->
            <div class="cards">
                <% 
                    //Creamos una lista de cuentas
                    ArrayList<Cuenta>alCuenta = new ArrayList<>();

                    //Obtenemos una lista de cuentas
                    alCuenta = (ArrayList<Cuenta>) session.getAttribute("listaCuenta");

                    //Agregamos la cuenta a la lista
                    if (alCuenta != null) {
                        for (Cuenta c : alCuenta) {
                            out.print("<form action=\"CCuenta\" method=\"post\" class=\"card\">"
                                        + "<input name =\"nCuenta\" class=\"nCuenta\" value=\""+c.getCuenta()+"\" readonly style=\"border: none; outline: none;\"></input>"
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
                    User user = (User)session.getAttribute("usuario");
                    if (user == null || !user.getCorreo().equalsIgnoreCase("root")
                            || !user.getContra().equalsIgnoreCase("root")) {
                        response.sendRedirect("index.jsp");
                    }
                %> 
                
            </div>
        </section>

    </div>
    <script src="js/scriptAdmi.js"></script>
</body>

</html>