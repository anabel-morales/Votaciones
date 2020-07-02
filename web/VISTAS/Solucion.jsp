<%-- 
    Document   : Solucion
    Created on : 24-abr-2020, 20:36:40
    Author     : Anabe
--%>

<%@page import="Modelo.Partido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resolución</title>
        <style type="text/css">
            html{
                width: 100%;
                height: 100%;
            }
            * {
                margin: 0; padding: 0;
            }
            body {
                background-image: url("../FOTOS/solucion1.jpg");
                background-position: center; 
                background-repeat: no-repeat;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                position: relative;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
            }
            h2{
                font-family: Roboto;
                text-align: center;
                font-size: 30px;
                padding-top: 200px;
                color: #0F5306 ;
            }
            p {
                font-size: 1.8rem;
                text-align: center;
            }
            a{ 
                color: black;
                text-decoration: none; }
            .boton_personalizado{
                text-decoration: none;
                padding: 10px;
                font-weight: 600;
                font-size: 20px;
                text-align: center;
                color: #ffffff;
                background-color: #1883ba;
                border-radius: 6px;
                border: 2px solid #0016b0;
            }

        </style>
    </head>
    <body>
        <% String codigo = request.getParameter("codigo");
            if (codigo.equals("error-insertar-votante")) {
        %>
        <h2> ESE USUARIO YA SE ENCUENTRA REGISTRADO</h2>
        <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
        <% } else if (codigo.equals("error-login-votante") || codigo.equals("error2-login-votante")) {%>
        <h2> HA OCURRIDO UN ERROR AL INICIAR SESIÓN </br> POR FAVOR, VUELVA A INTENTARLO Y COMPRUEBA LOS DATOS</h2>
        <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
        <%} else if (codigo.equals("error-baja-votante")) {
        %>
        <h2> DATOS DEL USUARIO INCORRECTOS</h2>
        <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
        <%
        } else if (codigo.equals("baja-votante")) {%>
        <h2> SE HA BORRADO CORRECTAMENTE </h2>
        <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
        <%} else if (codigo.equals("error-modificar-votante")) { %>
        <h2>HA OCURRIDO UN ERROR, NO SE HAN PODIDO MODIFICAR LOS DATOS.</h2>
        <a class="boton_personalizado" href="Menu.jsp">Volver atrás</a>
        <% } else if (codigo.equals("error-listar-partidos")) {%>
        <h2>EN ESTOS MOMENTOS NO SE PUEDEN LISTAR LOS PARTIDOS.</h2>
        <a class="boton_personalizado" href="Menu.jsp">Volver atrás</a>
        <% } else if (codigo.equals("error-registro-voto")) {%>
        <h2>NO SE HA PODIDO REGISTRAR EL VOTO</h2>
        <a class="boton_personalizado" href="Menu.jsp">Volver atrás</a>
        <% } else if (codigo.equals("correcto-registro-voto")) {
        %>
        <h2>SE HA REGISTRADO TU VOTO, HASTA LUEGO </h2>
         <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
        <%} else if (codigo.equals("estado-escrutinio")) { %>
        <h2>NO SE PUEDE REALIZAR ESTA OPCIÓN, COMPRUEBA EL ESTADO DEL ESCRUTIÑO</h2>
        <a class="boton_personalizado" href="Menu.jsp">Volver atrás</a>
        <%} else if (codigo.equals("parametros")) { %>
        <h2>NO HAY DATOS DISPONIBLES DE VOTACIONES</h2>
        <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
       <%}else if(codigo.equals("modificar-datos")){ %>
        <h2>SE HAN MODIFICADO LOS DATOS CORRECTAMENTE, VUELVE A INICIAR SESIÓN</h2>
        <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
        <% }else if(codigo.equals("abierto")){%>
         <h2>EL ESCRUTINIO AHORA ESTÁ ABIERTO, VUELVE A INICIAR SESIÓN PARA COMPROBARLO</h2>
        <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
         <% }else if(codigo.equals("cerrado")){%>
          <h2>EL ESCRUTINIO AHORA ESTÁ CERRADO, VUELVE A INICIAR SESIÓN PARA COMPROBARLO</h2>
        <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
          <% }else if(codigo.equals("finalizar")){%>
         <h2>EL ESCRUTINIO AHORA ESTÁ FINALIZADO, VUELVE A INICIAR SESIÓN PARA COMPROBARLO</h2>
        <a class="boton_personalizado" href="../index.jsp">Volver atrás</a>
        <%
            }
        %>
</html>
