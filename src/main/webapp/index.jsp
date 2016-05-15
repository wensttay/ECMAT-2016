<%-- 
    Document   : index.jsp
    Created on : 14/05/2016, 03:11:11
    Author     : Wensttay, Victor Hugo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="pt">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Encontro Cajazeirense de Matemática">
        <meta name="author" content="Wensttay">
        <meta name="author" content="Victor Hugo">
        <title>ECMAT 2016</title>
        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/contato-style.css" rel="stylesheet">
        <link href="css/inicio-style.css" rel="stylesheet">
        <link href="css/sobre-style.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
    </head>

    <body>
        <div id="container-fullpage">
            <header id="header" class="blackboard-background">
                <!--TROCAR IMAGEM POR UM ICONE DE GENTE-->
                <div id="menu-principal-button" ><br><img src="img/icons/menu-icon.png" width="30px" height="30px"/></div>
                <a href="#inicio">
                    <div id="logo-small" >
                        <img src="img/logo.png" width="75px" height="75px">
                    </div>
                </a>
                <nav class="menu-principal-box padding-high">
                    <ul class="principal-list">
                        <li id="close-menu-button"><span>X</span></li>
                        <li class="principal-list-item page-link item-bordered"><a class="principal-list-item" href="#inicio">Inicio</a></li>
                        <li class="principal-list-item item-bordered principal-list-item-withsublist">
                            <a href="#">Evento</a>
                            <ul class="drop-menu blackboard-background">
                                <li class="drop-menu-item page-link" ><a href="#sobre">Sobre</a></li>
                                <li class="drop-menu-item page-link" ><a href="#">Programação</a></li>
                                <li class="drop-menu-item page-link" ><a href="#">Organização</a></li>
                            </ul>
                        </li>
                        
                        <li class="principal-list-item page-link item-bordered" ><a href="#">Inscrição</a></li>
                        <li class="principal-list-item" id="logo-central" ><a href="#inicio"><img src="img/logo.png"></a></li>
                        <li class="principal-list-item page-link item-bordered" ><a href="#">Galeria</a></li>
                        <li class="principal-list-item item-bordered  principal-list-item-withsublist">
                            <a href="#">Documentos</a>
                            <ul class="drop-menu blackboard-background">
                                <li class="drop-menu-item page-link" ><a href="#">Anais</a></li>
                                <li class="drop-menu-item page-link" ><a href="#">Certificados</a></li>
                                <li class="drop-menu-item page-link" ><a href="#">Submissões</a></li>
                            </ul>
                        </li>
                        <li class="principal-list-item page-link item-bordered" ><a href="#contato">Contato</a></li>
                    </ul>
                </nav>
            </header>

            <div class="background blackboard-background"></div>

            <section id="section">
                <%@ include file="pages/inicio.jsp" %>
                <%@ include file="pages/sobre.jsp" %>
                <%@ include file="pages/contato.jsp" %>
            </section>

            <footer id="footer">
                <p class="text-center">
                    Desenvolvido por <strong>Rocinha Corporation</strong>
                </p>
            </footer>
        </div>
        
        <!-- Jquery Script -->
        <script src="js/jquery-2.2.2.min.js"></script>
        <!-- Bootstrap JavaScript -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- Custom Script for this tamplate -->
        <script src="js/script.js"></script>
        
    </body>
</html>


