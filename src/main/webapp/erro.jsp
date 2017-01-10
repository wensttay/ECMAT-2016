<%-- 
    Document   : erro.jsp
    Created on : 14/05/2016, 03:11:11
    Author     : Victor Hugo <victor.hugo.origins@gmail.com>
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <meta name="description" content="Encontro Cajazeirense de Matemática">
        <meta name="author" content="Wensttay">
        <meta name="author" content="Victor Hugo">
        <title>ECMAT 2016 | Erro 404</title>

         Bootstrap core CSS 
        <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        
        This make favicon for all devices
        <link rel="apple-touch-icon" sizes="57x57" href="${pageContext.request.contextPath}/img/favicons/apple-touch-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="${pageContext.request.contextPath}/img/favicons/apple-touch-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/img/favicons/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/img/favicons/apple-touch-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/img/favicons/apple-touch-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="${pageContext.request.contextPath}/img/favicons/apple-touch-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/img/favicons/apple-touch-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="${pageContext.request.contextPath}/img/favicons/apple-touch-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/img/favicons/apple-touch-icon-180x180.png">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicons/favicon-32x32.png" sizes="32x32">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicons/android-chrome-192x192.png" sizes="192x192">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicons/favicon-96x96.png" sizes="96x96">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicons/favicon-16x16.png" sizes="16x16">
        <link rel="manifest" href="${pageContext.request.contextPath}/img/favicons/manifest.json">
        <link rel="mask-icon" href="${pageContext.request.contextPath}/img/favicons/safari-pinned-tab.svg" color="#5bbad5">
        <meta name="apple-mobile-web-app-title" content="ECMAT 2016">
        <meta name="application-name" content="ECMAT 2016">
        <meta name="msapplication-TileColor" content="#242424">
        <meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/img/favicons/mstile-144x144.png">
        <meta name="theme-color" content="#242424">

         Custom styles for this template 
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/erro-style.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/css/erro-responsive.css" rel="stylesheet">

    </head>

    <body>
        <div id="container-fullpage">
            <div class="background blackboard-background background-error"></div>

            <header class="erro-header-box blackboard-background">
                <a href="index.jsp">
                    <div class="erro-header-item">
                        <img class="erro-logo default-low-opacity" src="${pageContext.request.contextPath}/img/logo/logo-ecmat2016-75x75.png">
                    </div>
                </a>  
            </header>

            <section id="error-section">
                <article class="erro-article">
                    <div class="container">
                        <div class="row">
                            <div class="erro-box default-low-opacity">
                                <div class="col-lg-1 col-md-2 col-sm-1"></div>
                                <div class="col-lg-5 col-md-4 col-sm-5 text-center erro-img-box">
                                    <img class="erro-img" src="${pageContext.request.contextPath}/img/other/error404.png">
                                </div>
                                <div class="col-lg-5 col-md-4 col-sm-5 text-center">
                                    <h1 class="erro-title">"Algo de errado não está certo!"</h1>
                                    <h2 class="erro-message medium-margin-bottom">Tente verificar se a URL foi digitada corretamente, 
                                        pois de acordo com nossos cálculos ela não consta no nosso sistema</h2>
                                </div>
                                <div class="col-lg-1 col-md-2 col-sm-1"></div>
                            </div>
                        </div>
                    </div>
                </article>
            </section>

            <footer id="footer">
                <p class="text-center">
                    Desenvolvido por <a href="https://github.com/Hero-Code" target="_blank" style="display: inline; background-color: black; padding: 5px; font-family: WC_RoughTrad; border-radius: 5px; margin-left: 5px;"><strong>HeroCode</strong></a>
                </p>
            </footer>
        </div>
    </body>
</html>
