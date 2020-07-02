<%-- 
    Document   : Escrutinio
    Created on : 29-abr-2020, 18:58:30
    Author     : Anabe
--%>

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
            @import "https://fonts.googleapis.com/css?family=Bungee+Shade";

            *,
            :after,
            :before {
                box-sizing: border-box;
            }

            :focus {
                outline: none;
            }
            body{
                font-family: "Roboto";
                color: #384047;
                background-image: linear-gradient( rgba(0, 0, 0, 0), rgba(245, 243, 243, 0.63)), url("../FOTOS/españa.jpg");
                background-position: center; 
                background-repeat: no-repeat;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                position: relative;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
            }


            div {
                margin: 3rem auto;
                max-width: 660px;
                width: 100%;
                display: flex;
                flex-flow: row wrap;
                justify-content: center;
            }
            button {
                overflow: visible;
                border: 0;
                padding: 0;
                margin: 1.8rem;
            }
            .btn.striped-shadow span {
                display: block;
                position: relative;
                z-index: 2;
                border: 5px solid;
            }
            .btn.striped-shadow.white span {
                border-color: #800;
                color: #5f0101;
            }

            .btn.striped-shadow.blue span {
                border-color: #4183d7;

                color: #4183d7;
            }
            .btn.striped-shadow.dark span {
                border-color: #393939;
                color: #393939;
            }

            .btn {
                font-family: "Bungee Shade", sans-serif;
                height: 80px;
                line-height: 65px;
                display: inline-block;
                letter-spacing: 1px;
                position: relative;
                font-size: 1.35rem;
                transition: opacity 0.3s, z-index 0.3s step-end, -webkit-transform 0.3s;
                transition: opacity 0.3s, z-index 0.3s step-end, transform 0.3s;
                transition: opacity 0.3s, z-index 0.3s step-end, transform 0.3s,
                    -webkit-transform 0.3s;
                z-index: 1;
                background-color: transparent;
                cursor: pointer;
            }

            .btn {
                width: 250px;
                height: 58px;
                line-height: 38px;
            }

            button.btn.striped-shadow.white:after,
            button.btn.striped-shadow.white:before {
                background-image: linear-gradient( 135deg, transparent 0, transparent 5px, #750808 5px, #460505 10px, #ffffff00 10px );
            }

            button.btn.striped-shadow.blue:after,
            button.btn.striped-shadow.blue:before {
                background-image: linear-gradient(
                    135deg,
                    transparent 0,
                    transparent 5px,
                    #4183d7 5px,
                    #4183d7 10px,
                    transparent 10px
                    );
            }

            button.btn.striped-shadow.dark:after,
            button.btn.striped-shadow.dark:before {
                background-image: linear-gradient(
                    135deg,
                    transparent 0,
                    transparent 5px,
                    #393939 5px,
                    #393939 10px,
                    transparent 10px
                    );
            }

            button.btn.striped-shadow:hover:before {
                max-height: calc(100% - 10px);
            }

            button.btn.striped-shadow:after {
                width: calc(100% - 4px);
                height: 8px;
                left: -10px;
                bottom: -9px;
                background-size: 15px 8px;
                background-repeat: repeat-x;
            }
            button.btn.striped-shadow:after,
            button.btn.striped-shadow:before {
                content: "";
                display: block;
                position: absolute;
                z-index: 1;
                transition: max-height 0.3s, width 0.3s, -webkit-transform 0.3s;
                transition: transform 0.3s, max-height 0.3s, width 0.3s;
                transition: transform 0.3s, max-height 0.3s, width 0.3s,
                    -webkit-transform 0.3s;
            }

            .btn.striped-shadow:hover {
                -webkit-transform: translate(-12px, 12px);
                -ms-transform: translate(-12px, 12px);
                transform: translate(-12px, 12px);
                z-index: 3;
            }

            button.btn.striped-shadow:hover:after,
            button.btn.striped-shadow:hover:before {
                -webkit-transform: translate(12px, -12px);
                -ms-transform: translate(12px, -12px);
                transform: translate(12px, -12px);
            }
            button.btn.striped-shadow:before {
                width: 8px;
                max-height: calc(100% - 5px);
                height: 100%;
                left: -12px;
                bottom: -5px;
                background-size: 8px 15px;
                background-repeat: repeat-y;
                background-position: 0 100%;
            }
            h1{
                text-align: center;
                font-size: 40px;
                padding-top: 50px;
            }

        </style>
    </head>
    <body>
        <h1>SELECCIONA EL ESTADO DEL ESCRUTINIO</h1>
        <form action="../ControladorEscrutinio" method="POST">
            <div>
                <button class="btn striped-shadow white" value="Abierto" name="Abierto"><span>Abierto</span></button>
                <button class="btn striped-shadow blue" value="Cerrado" name="Cerrado"><span>Cerrado</span></button>
                <button class="btn striped-shadow dark" value="Finalizar" name="Finalizar"><span>Finalizar</span></button>
            </div>
        </form>


    </body>
</html>
