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
        <title>ECMAT 2016 | Anais</title>
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
<!--                <div style="width: 100%; background-color: black; color: white; top: 0; z-index: 1000; margin-top: -20px;">
                    <div class="fix-vertical">
                        <a href="index" style="display: table">
                            <p style="padding: 5px; margin-left: 20px;"><<< Voltar para o Site</p>
                        </a>
                    </div>
                </div>-->
                <div id="menu-principal-button" class="menu-button-with-img" >
                    <img width="75px" height="75px" title="Clique para abrir o menu lateral." class="button-img default-low-opacity" src="img/menu/menu-icon.png"/>
                </div>

                <a title="Clique para voltar a página inicial." href="index">
                    <div id="logo-small" class="menu-button-with-img">
                        <img width="75px" height="75px" class="button-img default-low-opacity" src="img/logo/logo-ecmat2016-75x75.png">
                    </div>
                </a>
                <nav class="menu-principal-box">
                    <ul class="principal-list">
                        <div class="fix-vertical">
                            <li id="exit-menu-principal-button" class="menu-button-with-img" >
                                <img width="75px" height="75px" title="Clique para sair do menu lateral." class="button-img default-low-opacity" src="img/menu/exit-menu-icon.png"/>
                            </li>
                        </div>
                        <div class="fix-vertical">
                            <li class="principal-list-item page-link item-bordered">
                                <a title="Clique para voltar a página inicial." class="default-low-color-white-transparence item-title" href="#apresentacao">Apresentação</a>
                            </li>
                        </div>
                        <div class="fix-vertical">
                            <li class="principal-list-item page-link item-bordered">
                                <a title="Clique para voltar a página inicial." class="default-low-color-white-transparence item-title" href="#expediente">Expediente</a>
                            </li>
                        </div>
                        <div class="fix-vertical">
                            <li class="principal-list-item page-link item-bordered" >
                                <a title="Clique para ir para a página de Submissões." class="default-low-color-white-transparence item-title" href="#submissoes">Normas para publicações</a>
                            </li>
                        </div>
                        <div class="fix-vertical">
                            <li class="principal-list-item menu-button-with-img" id="logo-central" >
                                <a title="Clique para voltar a página inicial." class="button-img default-low-opacity" href="index">
                                    <img width="75px" height="75px" alt="Simbolodo do ECMAT" src="img/logo/logo-ecmat2016-75x75.png">
                                </a>
                            </li>
                        </div>
                        <div class="fix-vertical">
                            <li class="principal-list-item page-link item-bordered" >
                                <a title="Clique para ir para a página de Anais." class="default-low-color-white-transparence item-title" href="#edicao-atual">Edição atual</a>
                            </li>
                        </div>
                        <div class="fix-vertical">
                            <li class="principal-list-item page-link item-bordered disabled" >
                                <a title="Clique para ir para a página de Inscrição." class="default-low-color-white-transparence item-title" href="#edicoes-anteriores">Edições anteriores</a>
                            </li>
                        </div>
                        <div class="fix-vertical">
                            <li class="principal-list-item page-link item-bordered" >
                                <a title="Clique para ir para a página de Contato." class="default-low-color-white-transparence item-title" href="#contato">Contato</a>
                            </li>
                        </div>
                    </ul>
                </nav>
                <div class="issn-box">
                    <div title="(International Standard Serial Number)" class="issn blackboard-background">
                        Encontro Cajazeirense de Matemática - ISSN XXXX-XXX
                    </div>
                </div>
            </header>

            <div class="background blackboard-background"></div>

            <section id="section">
                <%@ include file="pages/submissoes.jsp" %>
                <%@ include file="pages/apresentacao.jsp" %> 
                <%@ include file="pages/contato.jsp" %>  
                <%@ include file="pages/edicoes-anteriores.jsp" %>
                <%@ include file="pages/expediente.jsp" %>
                <%@ include file="pages/edicao-atual.jsp" %>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div style="border: 5px solid white; display: table; padding: 15px; margin: 0 auto 30px;">
                                <p>
                                    Instituto Federal de Educação Ciência e Tecnologia da Paraíba/Campus
                                </p>
                                <p>
                                    Cajazeiras - IFPB
                                </p>
                                <p>
                                    Coordenação de Licenciatura em Matemática
                                </p>
                                <p>
                                    Rua José Antônio da Silva, 300, B. Jardim Oásis
                                </p>
                                <p>
                                    Cajazeiras -PB
                                </p>
                                <p>
                                    CEP: 58900-000
                                </p>
                                <p>
                                    Telefone: (83) 3532-4186/ (83) 99640-1322
                                </p>
                                <p>
                                    E-mail: clmat.cz@gmail.com
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
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


