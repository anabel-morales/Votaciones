<%-- 
    Document   : BajaVotante
    Created on : 24-abr-2020, 22:57:27
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
        <style type="text/css">
            @import url("https://rsms.me/inter/inter-ui.css");
            ::selection {
                background: #2d2f36;
            }
            ::-webkit-selection {
                background: #2d2f36;
            }
            ::-moz-selection {
                background: #2d2f36;
            }
            body {
                background: white;
                font-family: "Inter UI", sans-serif;
            }
            .page {
                display: flex;
                flex-direction: column;
                height: calc(100% - 40px);
                position: absolute;
                place-content: center;
                width: calc(100% - 40px);
            }
            @media (max-width: 767px) {
                .page {
                    height: auto;
                    margin-bottom: 20px;
                    padding-bottom: 20px;
                }
            }
            .container {
                display: flex;
                height: 320px;
                margin: 0 auto;
                width: 640px;
            }
            @media (max-width: 767px) {
                .container {
                    flex-direction: column;
                    height: 630px;
                    width: 320px;
                }
            }
            .left {
                background: #e7eeff;;
                height: calc(100% - 40px);
                top: 20px;
                position: relative;
                width: 50%;
            }
            @media (max-width: 767px) {
                .left {
                    height: 100%;
                    left: 20px;
                    width: calc(100% - 40px);
                    max-height: 270px;
                }
            }
            .login {
                font-size: 38px;
                TEXT-ALIGN: center;
                font-weight: 900;
                margin: 50px 80px 0px;
            }
            .eula {
                color: #0f1844;
                text-align: center;
                font-size: 18px;
                line-height: 1.5;
                margin: 30px;
            }
            .right {
                background: #fbfbffdb;
                box-shadow: 0px 0px 40px 16px rgba(0, 0, 0, 0.22);
                position: relative;
                width: 50%;
            }
            @media (max-width: 767px) {
                .right {
                    flex-shrink: 0;
                    height: 100%;
                    width: 100%;
                    max-height: 350px;
                }
            }
            svg {
                position: absolute;
                width: 320px;
            }
            path {
                fill: none;
                stroke: url(#linearGradient);
                stroke-width: 4;
                stroke-dasharray: 240 1386;
            }
            .form {
                margin: 40px;
                position: absolute;
            }
            label {
                color: #c2c2c5;
                display: block;
                font-size: 14px;
                height: 16px;
                margin-top: 20px;
                margin-bottom: 5px;
            }
            input {
                background: transparent;
                border: 0;
                color: #000000;
                font-size: 24px;
                height: 30px;
                line-height: 30px;
                outline: none !important;
                width: 100%;
            }
            input::-moz-focus-inner {
                border: 0;
            }
            #submit {
                color: #707075;
                margin-top: 40px;
                transition: color 300ms;
            }
            #submit:focus {
                color: #f2f2f2;
            }
            #submit:active {
                color: #d0d0d2;
            }
            html{
                width: 100%;
                height: 100%;
            }
            * {
                margin: 0; padding: 0;
            }

        </style>
    </head>
    <body>
        <div class="page">
            <div class="container">
                <div class="left">
                    <div class="login">BAJA</div>
                    <div class="eula">¿Estás seguro de que quiere darse de baja? Recuerda que no podrás darte de baja si ya has votado.</div>
                </div>
                <div class="right">
                    <svg viewBox="0 0 320 300">
                    <defs>
                    <linearGradient inkscape:collect="always" id="linearGradient" x1="13" y1="193.49992" x2="307" y2="193.49992" gradientUnits="userSpaceOnUse">
                    <stop style="stop-color:#ff00ff;" offset="0" id="stop876" />
                    <stop style="stop-color:#ff0000;" offset="1" id="stop878" />
                    </linearGradient>
                    </defs>
                    <path d="m 40,120.00016 239.99984,-3.2e-4 c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35 -25.00016,35 h -239.99984 c 0,-0.0205 -25,4.01348 -25,38.5 0,34.48652 25,38.5 25,38.5 h 215 c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 h -190 c 0,0 -20,1.71033 -20,25 0,24.00396 20,25 20,25 h 168.57143" />
                    </svg>
                    <div class="form">
                        <form action="../ControladorBajaVotante" method="POST">
                            <% HttpSession sesion = request.getSession(true);
                        Votante objVotante = (Votante) sesion.getAttribute("objVotante"); %>
                        <label for="dni">NIF/NIE</label>
                        <input type="text" id="dni" name="dni" value="<%= objVotante.getNif() %>" required>
                        <label for="password">Contraseña</label>
                        <input type="password" id="password" name="contraseña" required>
                        <input type="submit" id="submit" value="DARSE DE BAJA">
                        <% %>
                        </form>
                    </div>
                </div>
            </div>
        </div>
       
    </body>
</html>