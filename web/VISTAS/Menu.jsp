<%-- 
    Document   : Menu
    Created on : 24-abr-2020, 21:54:52
    Author     : Anabe
--%>
<%@page import="Modelo.Votante"%>
<%@page import="Modelo.Parametros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link  rel="icon"   href="../FOTOS/favicon.png" type="image/png" />
        <title>Votaciones</title>
        <style type="text/css">
            #nav{
                text-align: left;
                display:inline-block;
            }
            #menu{
                text-align:center;
            }
            ul li {
                list-style: none;
                height: 44px;
                float:left;
                padding:10px 5px;
            }
            ul li a {
                width: 175px;
                height: 40px;
                line-height: 53px;
                border-bottom: 4px solid #636393;
                padding:0px;
                color: #05043c;
                font-size: 22px;
                font-family: Roboto;
                font-weight:lighter;
                text-align:center;
                text-decoration: none;
                display: block;
                -webkit-transition: .2s all linear;
                -moz-transition: .2s all linear;
                -o-transition: .2s all linear;
                transition: .2s all linear;
            }
            li:nth-child(1) a, li:nth-child(6) a  {
                border-color: #636393;

            }
            li:nth-child(2) a, li:nth-child(7) a {
                border-color: #B5222D;
            }
            li:nth-child(3) a {
                border-color: #D4953C;
            }
            li:nth-child(4) a {
                border-color: #609491;
            }
            li:nth-child(5) a {
                border-color: #87A248;
            }
            li:nth-child(1) a:hover, li:nth-child(6) a:hover {
                border-bottom: 35px solid #636393;
                height: 9px;
                color: white;
            }
            li:nth-child(2) a:hover, li:nth-child(7) a:hover {
                border-bottom: 35px solid #B5222D;
                height: 9px;
                color: white;
            }
            li:nth-child(3) a:hover {
                border-bottom: 35px solid #D4953C;
                height: 9px;
                color: white;
            }
            li:nth-child(4) a:hover {
                border-bottom: 35px solid #609491;
                height: 9px;
                color: white;
            }
            li:nth-child(5) a:hover {
                border-bottom: 35px solid #87A248;
                height: 9px;
                color: white;
            }
            html{
                width: 100%;
                height: 100%;
            }
            * {
                margin: 0; padding: 0;
            }
            body {
                background-image: url("../FOTOS/votar2.jpg");
                background-position: center; 
                background-repeat: no-repeat;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                position: relative;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
            }
            #estado {
                background-color: #fafafa;
                margin: 1rem;
                padding: 1rem;
                border: 2px solid #ccc;
                text-align: center;
                font-family: "Roboto";
                font-size: 30px;
                line-height: 1.3em;
            }
            #atras{
                height: 40px;
                line-height: 53px;
                border-bottom: 4px solid #636393;
                padding: 0px;
                color: #05043c;
                font-size: 22px;
                font-family: Roboto;
                font-weight: lighter;
                text-align: center;
                text-decoration: none;
                display: block;
                -webkit-transition: .2s all linear;
                -moz-transition: .2s all linear;
                -o-transition: .2s all linear;
                transition: .2s all linear;
            }


        </style>
    </head>
    <body>
        <div id="menu">
            <% Parametros objParametros = (Parametros) session.getAttribute("objParametros");
                Votante objVotante = (Votante) session.getAttribute("objVotante");
                if (objVotante.getRol().equals("Votante") && objVotante.getVotado().equals("NV") && objParametros.getEstadoEscrutiño().equals("Cerrado")) { %>
            <ul id="nav">
                <li class="tutorials"><a href="BajaVotante.jsp">Baja votante</a></li>
                <li class="about"><a href="ModificarVotante.jsp">Modificar votante</a></li>
                <li class="news"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% } else if (objVotante.getRol().equals("Votante") && objVotante.getVotado().equals("V") && objParametros.getEstadoEscrutiño().equals("Cerrado")) {
            %>
            <div id="estado">
                <p>EL ESCRUTIÑO SE ENCUENTRA CERRADO, NO SE PUEDE REALIZAR NINGUNA OPCIÓN</p>
                <p><a id="atras" href="../index.jsp">CERRAR SESIÓN</a></p>
            </div>
            <% } else if (objVotante.getRol().equals("Administrador") && objVotante.getVotado().equals("V") && objParametros.getEstadoEscrutiño().equals("Cerrado")) {%>
            <ul id="nav">
                <li class="news"><a href="../ControladorListarCenso">Listar Censo</a></li>
                <li class="home"><a href="Escrutinio.jsp">Escrutiño</a></li>
                <li class="tutorials"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% } else if (objVotante.getRol().equals("Administrador") && objVotante.getVotado().equals("NV") && objParametros.getEstadoEscrutiño().equals("Cerrado")) {%>
            <ul id="nav">
                <li class="tutorials"><a href="BajaVotante.jsp">Baja votante</a></li>
                <li class="about"><a href="ModificarVotante.jsp">Modificar votante</a></li>
                <li class="news"><a href="../ControladorListarCenso">Listar Censo</a></li>
                <li class="home"><a href="Escrutinio.jsp">Escrutiño</a></li>
                <li class="tutorials"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% } else if (objVotante.getRol().equals("Votante") && objVotante.getVotado().equals("NV") && objParametros.getEstadoEscrutiño().equals("Abierto")) {
            %>
            <ul id="nav">             
                <li class="contact"><a href="../ControladorListarPartidos">Votar</a></li>
                <li class="news"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% } else if (objVotante.getRol().equals("Votante") && objVotante.getVotado().equals("V") && objParametros.getEstadoEscrutiño().equals("Abierto")) {
            %>
            <div id="estado">
                <p>EL ESCRUTIÑO SE ENCUENTRA ABIERTO, NO SE PUEDES REALIZAR NINGUNA OPCIÓN</p>
                <p><a id="atras" href="../index.jsp">CERRAR SESIÓN</a></p>
            </div>
            <% } else if (objVotante.getRol().equals("Administrador") && objVotante.getVotado().equals("V") && objParametros.getEstadoEscrutiño().equals("Abierto")) {
            %>
            <ul id="nav">
                <li class="news"><a href="../ControladorListarCenso">Listar Censo</a></li>
                <li class="home"><a href="Escrutinio.jsp">Escrutiño</a></li>
                <li class="about"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% } else if (objVotante.getRol().equals("Administrador") && objVotante.getVotado().equals("NV") && objParametros.getEstadoEscrutiño().equals("Abierto")) {
            %>
            <ul id="nav">
                <li class="news"><a href="../ControladorListarCenso">Listar Censo</a></li>
                <li class="contact"><a href="../ControladorListarPartidos">Votar</a></li>
                <li class="home"><a href="Escrutinio.jsp">Escrutiño</a></li>
                <li class="about"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% } else if (objVotante.getRol().equals("Votante") && objVotante.getVotado().equals("NV") && objParametros.getEstadoEscrutiño().equals("Finalizado")) {
            %>
            <ul id="nav">
                <li class="tutorials"><a href="../ControladorResultadoElectos">Electos</a></li>
                <li class="about"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% } else if (objVotante.getRol().equals("Votante") && objVotante.getVotado().equals("V") && objParametros.getEstadoEscrutiño().equals("Finalizado")) {
            %>
            <ul id="nav">
                <li class="tutorials"><a href="../ControladorResultadoElectos">Electos</a></li>
                <li class="about"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% } else if (objVotante.getRol().equals("Administrador") && objVotante.getVotado().equals("V") && objParametros.getEstadoEscrutiño().equals("Finalizado")) {
            %>
            <ul id="nav">

                <li class="news"><a href="../ControladorListarCenso">Listar Censo</a></li>
                <li class="home"><a href="Escrutinio.jsp">Escrutiño</a></li>
                <li class="tutorials"><a href="../ControladorResultadoElectos">Electos</a></li>
                <li class="about"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% } else if (objVotante.getRol().equals("Administrador") && objVotante.getVotado().equals("NV") && objParametros.getEstadoEscrutiño().equals("Finalizado")) {%>
            <ul id="nav">
                <li class="news"><a href="../ControladorListarCenso">Listar Censo</a></li>
                <li class="home"><a href="Escrutinio.jsp">Escrutiño</a></li>
                <li class="tutorials"><a href="../ControladorResultadoElectos">Electos</a></li>
                <li class="about"><a href="../index.jsp">Cerrar Sesión</a></li>
            </ul>
            <% }%>
        </div>
    </body>
</html>
