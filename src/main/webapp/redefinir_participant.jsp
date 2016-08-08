<!DOCTYPE html>
<!-- 
    Document   : redefinir.jsp
    Created on : 14/05/2016, 03:11:11
    Author     : Wensttay, Victor Hugo
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="io.github.herocode.ecmat.enums.Titrations"%>
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
                            <c:if test="${requestScope.is_valid == true}">
                                <h1 style="text-align: center">Por favor, confirme seus dados abaixo: </h1>
                                <br>
                                <div class="col-md-3"></div>
                                <div class="col-md-6">
                                    <form id="form-redefinir-participant" method="POST" class="form-horizontal" style="font-family: arial;" role="form">

                                        <div class="form-group col-sm-12 col-xs-12">
                                            <label class="col-sm-3 col-xs-12 label-cadastro">Nome Completo:</label>
                                            <div class="col-sm-9 col-xs-12">
                                                <input name="name" type="text" class="form-control" style="font-size: 14px;" required="required">
                                            </div>
                                        </div>

                                        <div class="form-group col-sm-12 col-xs-12">
                                            <label class="col-sm-3 col-xs-12 label-cadastro">Nascimento:</label>
                                            <div class="col-sm-9 col-xs-12">
                                                <input name="birth-date" placeholder="DD-MM-YYYY" type="date" class="form-control" style="font-size: 14px;" 
                                                       max="2015-01-01" min="1876-01-01"> 
                                            </div>
                                        </div>

                                        <div class="form-group col-sm-12 col-xs-12">
                                            <label class="col-sm-3 col-xs-12 label-cadastro">Titulação:</label>
                                            <div class="col-sm-9 col-xs-12">
                                                <select name="titration" class="form-control">
                                                    <c:forEach items="${Titrations.values()}" var="titration">
                                                        <option>${titration.titration}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group col-sm-12 col-xs-12" style="margin-bottom: 0;">
                                            <label class="col-sm-3 col-xs-12 label-cadastro">DDD:</label>
                                            <div class="col-sm-2 col-xs-12" style="margin-bottom: 15px">
                                                <input name="ddd" type="text" class="form-control" pattern="\[0-9]{2}\"
                                                       title="Digite o DDD, apenas números"
                                                       style="font-size: 14px;" 
                                                       onkeypress="javascript: add_mask(this, number_only);" maxlength="2"> 
                                            </div>
                                            <label class="col-sm-3 col-xs-12 label-cadastro">Telefone:</label>
                                            <div class="col-sm-4 col-xs-12" style="margin-bottom: 15px">
                                                <input name="phone" class="form-control" style="font-size: 14px;" type="tel" required="required" 
                                                       title="Digite o Telefone"
                                                       maxlength="12"
                                                       onkeypress="javascript: add_mask(this, number_only);">
                                            </div>
                                        </div>

                                        <div class="form-group col-sm-12 col-xs-12">
                                            <label class="col-sm-3 col-xs-12 label-cadastro">Senha:</label>
                                            <div class="col-sm-9 col-xs-12">
                                                <input name="password" type="password" class="form-control" style="font-size: 14px;"
                                                       placeholder="Ao menos 6 dígitos alfanuméricos"> 
                                            </div>
                                        </div>

                                        <div class="form-group col-sm-12 col-xs-12">
                                            <div class="col-sm-12 col-xs-12">
                                                <input type="submit" id="input-redefinir-participant" style="float: right;" class="btn btn-default" value="Registrar" >
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-md-3"></div>
                            </c:if>
                            <c:if test="${requestScope.is_valid == false}">
                                <h1 style="text-align: center">Token Expirado!</h1>
                                <div class="erro-box default-low-opacity">
                                    <div class="col-lg-3 col-md-3 col-sm-3"></div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 text-center">
                                        <br>
                                        <span>Este token está expirado, solicite novamente uma nova senha de acesso.</span>
                                    </div>
                                    <div class="col-lg-3 col-md-3 col-sm-3"></div>
                                </div>
                            </c:if>
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

                                                           $('#input-redefinir-participant').click(function (e) {
                                                               e.preventDefault();

                                                               $.post('ParticipantRecoverUpdate?token=${requestScope.token}', $('#form-redefinir-participant').serialize(), function (response) {
                                                                   var error = response.error;

                                                                   if (error !== undefined) {
                                                                       show_error(error);
                                                                   } else {
                                                                       show_success('Obrigado por confirmar seus dados ! Pedimos desculpas pelo incoveniente.');
                                                                       $('#row').hide();
                                                                   }
                                                               });

                                                           });
                                                           
                                                           
                                                           $('#input-success-modal').click(function (e) {
                                                               e.preventDefault();

                                                               window.location.replace("/#login");

                                                           });


        </script>
    </body>
</html>



