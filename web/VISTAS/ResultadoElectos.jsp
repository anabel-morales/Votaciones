<%-- 
    Document   : ResultadoElectos
    Created on : 29-abr-2020, 16:21:59
    Author     : Anabe
--%>

<%@page import="Modelo.Electo"%>
<%@page import="java.util.ArrayList"%>
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
                background-image: url("../FOTOS/electo2.jpg");
                background-position: top; 
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
                padding-bottom: 20px;
                color: white;

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
        <div class="aa_htmlTable">
            <h2 class="aa_h2">RESULTADO ELECTOS</h2>
            <table>
                <thead>
                    <tr>
                        <th>Logo</th>
                        <th>Siglas</th>
                        <th>Nombre completo</th>
                    </tr>
                </thead>
                <tbody>
                    <% ArrayList<Electo> ArrayElectos = (ArrayList) session.getAttribute("ArrayElectos");
                        for (Electo objElecto : ArrayElectos) {
                    %>
                    <tr>
                        <td><img src="<%= objElecto.getLogo()%>" alt="logo"/></td>
                        <td><%= objElecto.getSiglas()%></td>
                        <td><%= objElecto.getNombre_elegido()%></td>
                    </tr>
                    <% }%>
                    <tr>
                        <td colspan="4"><a class="boton_personalizado" href="Menu.jsp">ATRÁS</a></td>
                    </tr>
                </tbody>
            </table>
        </div>

    </body>
</html>
