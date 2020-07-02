<%-- 
    Document   : ListadoCenso
    Created on : 28-abr-2020, 21:21:16
    Author     : Anabe
--%>

<%@page import="java.util.ArrayList"%>
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
        <style type="text/css">
            *,
            *:before,
            *:after {
                -moz-box-sizing: border-box;
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
            }

            body {
                font-family: "Roboto";
                color: #384047;
                background-image: linear-gradient( rgba(0, 0, 0, 0), rgba(245, 243, 243, 0.63)), url("../FOTOS/29.jpg");
                background-position: center; 
                background-repeat: no-repeat;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                position: relative;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
            }


            table {
                max-width: 960px;
                margin: 10px auto;
            }

            caption {
                font-size: 3em;
                font-weight: 400;
                padding: 10px 0;
            }

            thead th {
                text-align: center;
                text-transform: uppercase;
                font-size: 20px;
                font-weight: 400;
                background: #052033;
                color: #fff;
                font-weight: bold;
            }

            tr {
                background: #ff671f;
                border-bottom: 1px solid #fff;
                color: white;
                margin-bottom: 5px;
            }

            tr:nth-child(even) {
                background: #e8eeef;
            }

            th,
            td {
                text-align: center;
                padding: 20px;
                font-weight: 300;
            }
            .boton_personalizado{
                text-decoration: none;
                padding: 10px;
                font-weight: 600;
                font-size: 20px;
                text-align: center;
                color: #ffffff;
                background-color: #ff671f;
                border-radius: 6px;
                border: 2px solid #000000;
            }


        </style>
    </head>

    <body>

        <table>
            <caption>LISTADO DEL CENSO</caption>
            <thead>
                <tr>
                    <th scope="col">NIF</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellidos</th>
                    <th scope="col">Domicilio</th>
                    <th scope="col">Fecha de Nacimiento</th>
                    <th scope="col">Votado</th>
                </tr>
            </thead>
            <tbody>
                <% HttpSession sesion = request.getSession(true);
                    ArrayList<Votante> ListadoCenso = (ArrayList) session.getAttribute("ListadoCenso");
                    for (Votante objVotante : ListadoCenso) {
                %>

                <tr>
                    <th scope="row"><%= objVotante.getNif()%></th>
                    <td><%= objVotante.getNombre()%></td>
                    <td><%= objVotante.getApellidos()%></td>
                    <td><%= objVotante.getDomicilio()%></td>
                    <td><%= objVotante.getFechaNacString()%></td>
                    <td><%= objVotante.getVotado()%></td>
                </tr>
                <% }%>
                <tr>
                    <td colspan="6"><a class="boton_personalizado" href="Menu.jsp">ATRÁS</a></td>
                </tr>
            </tbody>

        </table>

    </body>

</body>
</html>
