<%-- 
    Document   : ModificarVotante2
    Created on : 28-abr-2020, 18:49:29
    Author     : Anabe
--%>

<%@page import="Modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link  rel="icon"   href="../FOTOS/favicon.png" type="image/png" />
        <title>Votaciones</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <style type="text/css">

        * {
            margin: 0;
            padding: 0;
        }
        body {
            background:whit;
            background-size: cover;
            font-family: "Roboto","Helvetica Neue Light","Helvetica Neue",Helvetica,Arial,"Lucida Grande",sans-serif,aclonica;
            font-size:20px;
            color:black;
        }
        .h3 {
            font-family: "aclonica";
            font-size: 120px;
            color: orange;
        }
        .input-field label{
            font-size: 1.2rem;
        }
        input[type=text], input[type=password], input[type=email], input[type=date]{
            font-size: 1.2em;
        }
    </style>
</head>
<body>
    <section class="container">
        <div class="row" style="padding:100px;">
            <h3 class="center-align">DATOS PERSONALES</h3>
            <article class="col s6 offset-s3">
                <form method="POST" action="../ControladorModificarVotante2">
                    <% HttpSession sesion = request.getSession(true);
                        Votante objVotante = (Votante) sesion.getAttribute("objVotante");%>
                    <input type="hidden" value="<%= objVotante.getNif()%>" name="nif" id="nif">
                    <div class="input-field">
                        <i class="material-icons prefix">perm_identity</i>
                        <label for="nombre">Nombre</label>
                        <input type="text" name="nombre" required value="<% out.print(objVotante.getNombre()); %>">
                    </div>

                    <div class="input-field">
                        <i class="material-icons prefix">person_pin</i>
                        <label for="apellidos">Apellidos</label>
                        <input type="text" name="apellidos" value="<% out.print(objVotante.getApellidos());%>" required>
                    </div>

                    <div class="input-field">
                        <i class="material-icons prefix">home</i>
                        <label for="domicilio">Domicilio</label>
                        <input type="text" name="domicilio" value="<% out.print(objVotante.getDomicilio()); %>" required>
                    </div>

                    <div class="input-field">
                        <i class="material-icons prefix">mode_edit</i>
                        <label for="password">Contraseña</label>
                        <input name="password" id="password" type="password" required>
                    </div>
                    <div class="input-field">
                        <i class="material-icons prefix">cake</i>
                        <!--            <label for="fechanac">Fecha Nacimiento</label>-->
                        <input name="fechanac" id="fechanac" value="<% out.print(objVotante.getFechanac()); %>" type="date" required>
                    </div>

                    <p class="center-align">
                        <button class="waves-effect waves-light btn" type="submit"><i class="material-icons right">send</i>ACEPTAR</button>
                    </p>
                    <%%>
                </form>

            </article>
        </div>
    </section>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>
</body>
</html>
