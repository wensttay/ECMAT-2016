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

        <!--This make favicon for all devices-->
        <link rel="apple-touch-icon" sizes="57x57" href="img/favicons/apple-touch-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="img/favicons/apple-touch-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="img/favicons/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="img/favicons/apple-touch-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="img/favicons/apple-touch-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="img/favicons/apple-touch-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="img/favicons/apple-touch-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="img/favicons/apple-touch-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="img/favicons/apple-touch-icon-180x180.png">
        <link rel="icon" type="image/png" href="img/favicons/favicon-32x32.png" sizes="32x32">
        <link rel="icon" type="image/png" href="img/favicons/android-chrome-192x192.png" sizes="192x192">
        <link rel="icon" type="image/png" href="img/favicons/favicon-96x96.png" sizes="96x96">
        <link rel="icon" type="image/png" href="img/favicons/favicon-16x16.png" sizes="16x16">
        <link rel="manifest" href="img/favicons/manifest.json">
        <link rel="mask-icon" href="img/favicons/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="apple-mobile-web-app-title" content="ECMAT 2016">
        <meta name="application-name" content="ECMAT 2016">
        <meta name="msapplication-TileColor" content="#242424">
        <meta name="msapplication-TileImage" content="img/favicons/mstile-144x144.png">
        <meta name="theme-color" content="#242424">


        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/construcao-style.css" rel="stylesheet" type="text/css"/>
        <link href="css/contato-style.css" rel="stylesheet" type="text/css" />
        <link href="css/contato-responsive.css" rel="stylesheet" type="text/css" />
        <link href="css/inicio-style.css" rel="stylesheet" type="text/css" />
        <link href="css/sobre-style.css" rel="stylesheet" type="text/css" />
        <link href="css/sobre-responsive.css" rel="stylesheet" type="text/css" />
        <link href="css/organizacao-style.css" rel="stylesheet" type="text/css" />
        <link href="css/organizacao-responsive.css" rel="stylesheet" type="text/css" />
        <link href="css/programacao-style.css" rel="stylesheet" type="text/css" />
        <link href="css/submissoes-style.css" rel="stylesheet" type="text/css" />
        <link href="css/anais-style.css" rel="stylesheet" type="text/css" />
        <link href="css/anais-responsive.css" rel="stylesheet" type="text/css" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <div id="container-fullpage">
            <header id="header" class="blackboard-background default-border-bottom">
                <div class="construcao-background"></div>
                <div id="menu-principal-button" class="menu-button-with-img" >
                    <img width="75px" height="75px" title="Clique para abrir o menu lateral." class="button-img default-low-opacity" src="img/menu/menu-icon.png"/>
                </div>

                <a title="Clique para voltar a página inicial." href="#inicio">
                    <div id="logo-small" class="menu-button-with-img">
                        <img width="75px" height="75px" class="button-img default-low-opacity" src="img/logo/logo-ecmat2016-75x75.png">
                    </div>
                </a>
                <nav class="menu-principal-box">
                    <ul class="principal-list">
                        <li id="exit-menu-principal-button" class="menu-button-with-img" >
                            <img width="75px" height="75px" title="Clique para sair do menu lateral." class="button-img default-low-opacity" src="img/menu/exit-menu-icon.png"/>
                        </li>

                        <li class="principal-list-item page-link item-bordered">
                            <a title="Clique para voltar a página inicial." class="default-low-color-white-transparence item-title" href="#inicio">Inicio</a>
                        </li>
                        <li class="principal-list-item item-bordered principal-list-item-withsublist">
                            <a href="#" class="default-low-color-white-transparence item-title list-item-withsublist-title">Evento  <span class="glyphicon glyphicon-triangle-bottom"></span></a>
                            <ul class="drop-menu default-border-color blackboard-background">
                                <li class="drop-menu-item default-border-color page-link" >
                                    <a title="Clique para ir para a página de Sobre." class="default-low-color-white-transparence" href="#apresentacao">Apresentação</a>
                                </li>
                                <li class="drop-menu-item default-border-color page-link" >
                                    <a title="Clique para ir para a página da Programação." class="default-low-color-white-transparence" href="#programacao">Programação</a>
                                </li>
                                <li class="drop-menu-item default-border-color page-link" >
                                    <a title="Clique para ir para a página da Organização." class="default-low-color-white-transparence" href="#organizacao">Organização</a>
                                </li>
                                <li class="drop-menu-item default-border-color page-link disabled" >
                                    <a title="Clique para ir para a página da Galeria." class="default-low-color-white-transparence" href="#construcao">Galeria</a>
                                </li>
                                <li class="drop-menu-item default-border-color page-link disabled" >
                                    <a title="Clique para ir para a página de Certificados." class="default-low-color-white-transparence" href="#construcao">Certificados</a>
                                </li>
                            </ul>
                        </li>
                        <li class="principal-list-item page-link item-bordered" >
                            <a title="Clique para ir para a página de Submissões." class="default-low-color-white-transparence item-title" href="#submissoes">Submissões</a>
                        </li>

                        <li class="principal-list-item menu-button-with-img" id="logo-central" >
                            <a title="Clique para voltar a página inicial." class="button-img default-low-opacity" href="#inicio">
                                <img width="75px" height="75px" alt="Simbolodo do ECMAT" src="img/logo/logo-ecmat2016-75x75.png">
                            </a>
                        </li>

                        <li class="principal-list-item page-link item-bordered" >
                            <a title="Clique para ir para a página de Anais." class="default-low-color-white-transparence item-title" href="anais">Anais</a>
                        </li>

                        <li class="principal-list-item page-link item-bordered" >
                            <a title="Clique para ir para a página de Contato." class="default-low-color-white-transparence item-title" href="#contato">Contato</a>
                        </li>
                        <li class="principal-list-item page-link item-bordered disabled" >
                            <a title="Clique para ir para a página de Inscrição." class="default-low-color-white-transparence item-title" href="#inscricao">Inscrição</a>
                        </li>
                    </ul>
                </nav>
            </header>

            <div class="background blackboard-background"></div>

            <section id="section">
                <%@ include file="pages/inicio.jsp" %>
                <%@ include file="pages/submissoes.jsp" %>
                <%@ include file="pages/apresentacao.jsp" %>
                <%@ include file="pages/programacao.jsp" %>
                <%@ include file="pages/contato.jsp" %>  
                <%@ include file="pages/construcao.jsp" %>
                <%@ include file="pages/organizacao.jsp" %>
                <%@ include file="pages/inscricao.jsp" %>
                <%@ include file="pages/cadastro.jsp" %>
                <%@ include file="pages/recuperacao.jsp" %>
                <%@ include file="pages/painel.jsp" %>
                <%@ include file="pages/alert_error_model.jsp" %>
            </section>

            <footer id="footer">
                <p class="text-center">
                    Desenvolvido por <a title="Clique para ir para a página da HeroCode." href="https://github.com/Hero-Code" target="_blank" style="display: inline; background-color: black; padding: 5px; font-family: WC_RoughTrad; border-radius: 5px; margin-left: 5px;"><strong>HeroCode</strong></a>
                </p>
            </footer>
        </div>

        <!-- Jquery Script -->
        <script src="js/jquery-2.2.2.min.js" type="text/javascript"></script>
        <!-- Bootstrap JavaScript -->
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- Custom Script for this tamplate -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDS3zJXOooBXqk6jFZRRrF-N6RbpXikIzg" type="text/javascript"></script>
        <script src="js/menu-controll-script.js" type="text/javascript"></script>
        <script src="js/page-controll-script.js" type="text/javascript"></script>
        <script src="js/organizacao-controll-script.js" type="text/javascript"></script>
        <script src="js/programacao-table-controll-script.js" type="text/javascript"></script>
    </body>
</html>


