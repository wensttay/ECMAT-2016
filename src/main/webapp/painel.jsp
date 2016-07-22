<!DOCTYPE html>
<!-- 
    Document   : redefinir.jsp
    Created on : 14/05/2016, 03:11:11
    Author     : Wensttay, Victor Hugo
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="io.github.herocode.ecmat.enums.PaymentStatus"%>
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
                <div>
                    <a style="font-size: 18px; font-weight: bold;float:right; margin-right: 50px; margin-top: 60px;" title="Clique para ir para a página da Organização." class="default-low-color-white-transparence" href="Logut">Sair</a>
                </div>
            </header>


            <section>
                <article style="margin-top: 150px;">
                    <div class="container text-center">

                        <div class="row">
                            <p class="estado_inscricao">Estado da inscrição:
                                <c:if test="${!empty sessionScope.participant and !sessionScope.participant.getPaymentStatus().equals(PaymentStatus.COMPLETE.code)}">
                                    <span style="color:yellow;">Pendente</span>
                                    <span>,
                                        <c:choose>
                                            <c:when test="${sessionScope.participant.getPaymentStatus().equals(PaymentStatus.IN_REVIEW.code)}">
                                                o pagamento está em análise.
                                            </c:when>
                                            <c:when test="${sessionScope.participant.getPaymentStatus().equals(PaymentStatus.AWAITING_PAYMENT.code)}">
                                                o pagamento ainda não foi efetuado.
                                            </c:when>
                                            <c:when test="${sessionScope.participant.getPaymentStatus().equals(PaymentStatus.IN_DISPUTE.code)}">
                                                o pagamento está em disputa.
                                            </c:when>
                                            <c:when test="${sessionScope.participant.getPaymentStatus().equals(PaymentStatus.AVAILABLE.code)}">
                                                o pagamento ainda não foi efetuado.
                                            </c:when>
                                            <c:when test="${sessionScope.participant.getPaymentStatus().equals(PaymentStatus.RETURNED.code)}">
                                                o pagamento foi retornado.
                                            </c:when>
                                            <c:when test="${sessionScope.participant.getPaymentStatus().equals(PaymentStatus.CANCELLED.code)}">
                                                o pagamento foi cancelado.
                                            </c:when>
                                        </c:choose>
                                    </span>
                                </c:if>
                                <c:if test="${sessionScope.participant.getPaymentStatus().equals(PaymentStatus.COMPLETE.code)}">
                                    <span style="color: lime">Concluída</span> !
                                </c:if>
                            </p>
                            <br><br><br>
                            <h1>Bem vindo(a), ${sessionScope.participant.getFirstName()}</h1>
                            <div class="col-md-3"></div>
                            <div class="col-md-6" style="margin-top: 50px !important;">
                                <!--<div class="col-xs-2"></div>-->
                                <c:if test="${!sessionScope.participant.getPaymentStatus().equals(PaymentStatus.COMPLETE.code)}">
                                    <div class="col-md-12">
                                        <p>
                                            parece que você ainda não concluiu sua inscrição,
                                            realize o pagamento da mesma e tenha acesso aos Minicursos que ocorrerão no evento !
                                        </p>
                                        <br>
                                        <a href="${sessionScope.participant.getPaymentUrl()}">
                                            <img src="img/other/pag-seguro-logo.png">
                                        </a>
                                    </div>
                                </c:if>
                                <!--<div class="col-xs-2"></div>-->
                            </div>
                            <div class="col-md-3"></div>
                        </div>
                        <div class="row notice">
                            <p style="font-family: WC_RoughTrad;">* Os minicursos e as inscrições para os mesmos estarão disponíveis em breve, fique atento !</p>
                        </div>
                    </div>
                </article>
            </section>
            <!--<div class="row">-->
            <!--</div>--> 
            <footer id="footer">
                <p class="text-center">
                    Desenvolvido por <a href="https://github.com/Hero-Code" target="_blank" style="display: inline; background-color: black; padding: 5px; font-family: WC_RoughTrad; border-radius: 5px; margin-left: 5px;"><strong>HeroCode</strong></a>
                </p>
            </footer>
        </div>
    </body>
</html>



