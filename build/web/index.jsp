<%-- 
    Document   : Ejercicio02
    Created on : 26-ago-2021, 15:59:28
    Author     : Urban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/stylesIndex.css">
    <title>Banco BALR</title>
</head>

<body>
    <main>
        <section class="container">
            <div class="containerLogo">
                <img src="Assets/img/Banco-agricola-sv.png" alt="" class="containerLogo__logo">
                <small class="containerLogo__logoFooter">El Salvador cuenta con nosotros</small>
            </div>
            <form action="CEjercici02" method="post" class="formInicioSesion">
                <div class="formInicioSesion__campo">
                    <input type="text" name="txtUsuario" class="formInicioSesion__inputText" placeholder="Usuario">
                </div>
                <div class="formInicioSesion__campo">
                    <input type="text" name="txtContra" class="formInicioSesion__inputText" placeholder="Contraseña">
                </div>
                <input type="submit" value="Ingresar" class="boton">
                <a href="#" class="link">¿Olvidaste la Contraseña?</a>
            </form>
        </section>
    </main>
</body>

</html>
