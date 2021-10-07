<%-- 
    Document   : Ejercicio02
    Created on : 26-ago-2021, 15:59:28
    Author     : Urban
--%>

<%@page import="Clases.Userbd"%>
<%@page import="Clases.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="958494741918-haqmha152e2duquusg4t89chk2b15b5q.apps.googleusercontent.com">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/stylesIndex.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <title>Banco BALR</title>
   </script>
</head>

<body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container" style="height: 52px">
          <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <button class="btn btn-dark" type="menu"><a class="nav-link" aria-current="page" href="index.jsp">Problema 1</a></button>
                <button class="btn btn-dark" type="menu"><a class="nav-link" aria-current="page" href="index2.jsp">Problema 2</a></button>
            </div>
          </div>
        </div>
      </nav>
    <main>
        <section class="container">
            <div class="containerLogo">
                <img src="Assets/img/Banco-agricola-sv.png" alt="" class="containerLogo__logo">
                <small class="containerLogo__logoFooter">El Salvador cuenta con nosotros</small>
            </div>
            <form action="CEjercici02" method="POST" class="formInicioSesion">
                <div id="frmGoogle">
                   <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" style="margin-bottom: 0.5em;"></div>
                </div>
                <div class="formInicioSesion__campo">
                    <input type="text" name="txtUsuario" class="formInicioSesion__inputText" placeholder="Usuario">
                </div>
                <div class="formInicioSesion__campo">
                    <input type="text" name="txtContra" class="formInicioSesion__inputText" placeholder="Contraseña">
                </div>
                <input type="submit" value="Ingresar" class="boton">
                <a href="#" class="link">¿Olvidaste la Contraseña?<%
                    Userbd user = new Userbd();
                        out.print(user.ultimoID());
                    %></a>
            </form>
        </section>
    </main>
      <script>
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
          console.log('User signed out.');
        });
        window.location.href = "authPag.jsp?email="+profile.getEmail();
        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      }
    </script>
</body>

</html>
