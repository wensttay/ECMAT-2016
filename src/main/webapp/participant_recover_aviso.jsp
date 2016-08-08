<!DOCTYPE html>
<!-- 
    Document   : redefinir.jsp
    Created on : 14/05/2016, 03:11:11
    Author     : Wensttay, Victor Hugo
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="pt">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Encontro Cajazeirense de Matemática">
        <meta name="author" content="Wensttay">
        <meta name="author" content="Victor Hugo">
        <title>ECMAT 2016 | Redefinir</title>

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
        <link href="css/erro-style.css" rel="stylesheet"/>
        <link href="css/erro-responsive.css" rel="stylesheet">

    </head>

    <body>
        <div id="container-fullpage">
            <div class="background blackboard-background"></div>

            <header class="erro-header-box blackboard-background">
                <a href="index.jsp">
                    <div class="erro-header-item">
                        <img class="erro-logo default-low-opacity" src="img/logo/logo-ecmat2016-75x75.png">
                    </div>
                </a>  
            </header>


            <section id="error-section">
                <%@ include file="pages/alert_error_model.jsp" %>
                <%@ include file="pages/alert_success_model.jsp" %>
                <article class="erro-article">
                    <div class="container">
                        <div class="row" id="row">
                            <h1 style="text-align: center">Atenção!</h1>
                            <div class="erro-box default-low-opacity">
                                <div class="col-lg-3 col-md-3 col-sm-3"></div>
                                <div class="col-lg-6 col-md-6 col-sm-6 text-center">
                                    <br>
                                    <span>Tivemos alguns problemas na sua conta, enviamos-lhe um e-mail para solucionarmos o imprevisto, por favor favor verifique sua caixa de entrada, span e lixeira.</span>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-3"></div>
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
        <script src="js/field_mask_validator.js" type="text/javascript"></script>
        <script type="text/javascript">

            function show_error(textError) {
                $('p#error-body').html(textError);
                $('#errorModal').modal({
                    show: 'true'
                });
            }

            function show_success(textError) {
                $('p#success-body').html(textError);
                $('#successModal').modal({
                    show: 'true'
                });
            }

            $('#input-success-modal').click(function (e) {
                e.preventDefault();

                window.location.replace("/#login");

            });

            $('#input-redefinir').click(function (e) {
                e.preventDefault();

                $.post('SaveNewPassword?token=${requestScope.token}', $('#form-redefinir').serialize(), function (response) {
                    var error = response.error;

                    if (error !== undefined) {
                        show_error(error);
                    } else {
                        show_success('Sua senha foi redefinida com sucesso !');
                        $('#row').hide();
                    }
                });

            });

        </script>
    </body>
</html>



