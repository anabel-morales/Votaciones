<%-- 
    Document   : ListarPartidos
    Created on : 28-abr-2020, 23:24:34
    Author     : Anabe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Partido"%>
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
            body {
                display: table;
                width: 100%;
                text-align: center;
                font-family:"Roboto";
                background-image: url("../FOTOS/votacion.jpg");
                background-position: center; 
                background-repeat: no-repeat;
                flex-direction: column;
                min-height: 100vh;
                position: relative;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
            }
            * {
                -webkit-box-sizing: border-box; /* Safari/Chrome, other WebKit */
                -moz-box-sizing: border-box; /* Firefox, other Gecko */
                box-sizing: border-box; /* Opera/IE 8+ */
            }
            *{
                margin:0;
                padding:0;
            }

            .aa_h2 {
                font: 100 3rem/1 Roboto;
                text-transform: uppercase;
                padding-top: 40px;
                padding-bottom: 10px;

            }
            table {
                background: #fff;
            }
            table,
            thead,
            tbody,
            tfoot,
            tr,
            td,
            th {
                text-align: center;
                margin: auto;
                border: 1px solid #9089892b;
                padding: 1rem;
                /* width: 50%; */
                text-transform: uppercase;
            }
            .table {
                display: table;
                width: 50%;
            }
            .tr {
                display: table-row;
            }
            .thead {
                display: table-header-group;
            }
            .tbody {
                display: table-row-group;
            }
            .tfoot {
                display: table-footer-group;
            }
            .col {
                display: table-column;
            }
            .colgroup {
                display: table-column-group;
            }
            .td,
            .th {
                display: table-cell;
                width: 50%;
            }
            .caption {
                display: table-caption;
            }

            .table,
            .thead,
            .tbody,
            .tfoot,
            .tr,
            .td,
            .th {
                text-align: center;
                margin: auto;
                padding: 1rem;
            }
            .table {
                background: #fff;
                margin: auto;
                border: none;
                padding: 0;
                margin-bottom: 5rem;
            }

            .th {
                font-weight: 700;
                border: 1px solid #dedede;
                &:nth-child(odd) {
                    border-right: none;
                }
            }
            .td {
                font-weight: 300;
                border: 1px solid #dedede;
                border-top: none;
                &:nth-child(odd) {
                    border-right: none;
                }
            }
            img{
                width: 80px;
                height: 80px;
                border-radius:10px;
            }
            button{
                text-decoration: none;
                background: orange;
                color:white;
                font-size:20px;
                text-decoration: none;
                text-align: center;
                letter-spacing: .5px;
                padding:10px;
                cursor: pointer;
                border-radius: 15px;
            }
            button:hover{
                color: #1883ba;
                background-color: #ffffff;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="aa_htmlTable">
            <h2 class="aa_h2">ELIGE UN PARTIDO</h2>
            <form action="../ControladorVotar" method="POST">
                <table>
                    <thead>
                        <tr>
                            <th>Logo</th>
                            <th>Siglas</th>
                            <th>Nombre completo</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% ArrayList<Partido> ArrayPartidos = (ArrayList) session.getAttribute("ArrayPartidos");
                            for (Partido objPartido : ArrayPartidos) {
                        %>
                        <tr>
                            <td><img src="<%= objPartido.getLogo()%>" alt="logo"/></td>
                            <td><%= objPartido.getSiglas()%></td>
                            <td><%= objPartido.getNombrepartido()%></td>
                            <td><input type="radio" id="siglas" name="siglas" value="<%=objPartido.getSiglas()%>" checked></td>
                        </tr>
                        <% }%>
                        <tr>
                            <td colspan="4"><button value="submit" name="Votar">VOTAR</button></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>

    </body>
</html>
