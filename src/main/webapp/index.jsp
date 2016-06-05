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
        <link href="css/construcao-style.css" rel="stylesheet"/>
        <link href="css/contato-style.css" rel="stylesheet">
        <link href="css/contato-responsive.css" rel="stylesheet">
        <link href="css/inicio-style.css" rel="stylesheet">
        <link href="css/sobre-style.css" rel="stylesheet">
        <link href="css/sobre-responsive.css" rel="stylesheet">
        <link href="css/organizacao-style.css" rel="stylesheet">
        <link href="css/organizacao-responsive.css" rel="stylesheet">
        <link href="css/programacao-style.css" rel="stylesheet">
        <link href="css/submissoes-style.css" rel="stylesheet"/>
        <link href="css/anais-style.css" rel="stylesheet">
        <link href="css/anais-responsive.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>

    <body>
        <div id="container-fullpage">
            <header id="header" class="blackboard-background">
                <div class="construcao-background"></div>
                <div id="menu-principal-button" class="menu-button-with-img low-white-transparence" >
                    <img  class="low-opacity" src="img/menu/menu-icon.png" />
                </div>

                <a href="#inicio">
                    <div id="logo-small" class="menu-button-with-img low-white-transparence">
                        <img class="low-opacity" src="img/logo/logo-ecmat2016-75x75.png">
                    </div>
                </a>
                <nav class="menu-principal-box">
                    <ul class="principal-list">
                        <li id="exit-menu-principal-button" class="menu-button-with-img" >
                            <img src="img/menu/exit-menu-icon.png"/>
                        </li>

                        <li class="principal-list-item page-link item-bordered"><a class="item-title" href="#inicio">Inicio</a></li>
                        <li class="principal-list-item item-bordered principal-list-item-withsublist">
                            <a href="#" class="item-title list-item-withsublist-title">Evento  <span class="glyphicon glyphicon-triangle-bottom"></span></a>
                            <ul class="drop-menu blackboard-background">
                                <li class="drop-menu-item page-link" ><a href="#sobre">Sobre</a></li>
                                <li class="drop-menu-item page-link" ><a href="#programacao">Programação</a></li>
                                <li class="drop-menu-item page-link" ><a href="#organizacao">Organização</a></li>
                                <li class="drop-menu-item page-link disabled" ><a href="#construcao">Galeria</a></li>
                                <li class="drop-menu-item page-link disabled" ><a href="#construcao">Certificados</a></li>
                            </ul>
                        </li>
                        <li class="principal-list-item page-link item-bordered" ><a class="item-title" href="#submissoes">Submissões</a></li>


                        <li class="principal-list-item menu-button-with-img low-opacity" id="logo-central" ><a href="#inicio">
                                <img src="img/logo/logo-ecmat2016-75x75.png"></a>
                        </li>

                        <li class="principal-list-item page-link item-bordered" ><a class="item-title" href="#anais">Anais</a></li>

                        <li class="principal-list-item page-link item-bordered" ><a class="item-title contact" href="#contato">Contato</a></li>
                        <li class="principal-list-item page-link item-bordered disabled" ><a class="item-title contact" href="#construcao">Inscrição</a></li>
                        <!--<li class="principal-list-item page-link item-bordered disabled" ><a href="#construcao">Inscrição</a></li>-->
<!--                        <li class="principal-list-item item-bordered principal-list-item-withsublist">
                            <a href="#" class="list-item-withsublist-title">Inscrição  <span class="glyphicon glyphicon-triangle-bottom"></span></a>
                            <ul class="item-title drop-menu blackboard-background">
                                <li class="drop-menu-item page-link disabled" ><a href="#construcao">Entrar</a></li>
                                <li class="drop-menu-item page-link disabled" ><a href="#construcao">Criar Conta</a></li>
                                                                <li class="drop-menu-item page-link disabled" ><a href="#construcao">Minha Conta</a></li>
                                                                <li class="drop-menu-item page-link disabled" ><a href="#construcao">Sair</a></li>
                            </ul>
                        </li>-->
                    </ul>
                </nav>
                <div class="issn-box">
                    <div class="issn blackboard-background">
                        ISSN XXXX-XXX
                    </div>
                </div>
            </header>

            <div class="background blackboard-background"></div>

            <section id="section">
                <%@ include file="pages/inicio.jsp" %>
                <%@ include file="pages/sobre.jsp" %>
                <%@ include file="pages/contato.jsp" %>
                <%@ include file="pages/programacao.jsp" %>
                <%@ include file="pages/organizacao.jsp" %>
                <%@ include file="pages/construcao.jsp" %>
                <%@ include file="pages/submissoes.jsp" %>
                <%@ include file="pages/anais.jsp" %>

            </section>

            <footer id="footer">
                <p class="text-center">
                    Desenvolvido por <a href="https://github.com/Hero-Code" target="_blank" style="display: inline; background-color: black; padding: 5px; font-family: WC_RoughTrad; border-radius: 5px; margin-left: 5px;"><strong>HeroCode</strong></a>
                </p>
            </footer>
        </div>

        <!-- Jquery Script -->
        <script src="js/jquery-2.2.2.min.js"></script>
        <!-- Bootstrap JavaScript -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- Custom Script for this tamplate -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDS3zJXOooBXqk6jFZRRrF-N6RbpXikIzg"></script>
        <script src="js/menu-controll-script.js"></script>
        <script src="js/page-controll-script.js"></script>
        <script src="js/organizacao-controll-script.js"></script>
        <script src="js/programacao-table-controll-script.js"></script>
    </body>
</html>


