<!DOCTYPE html>
<!-- 
    Document   : redefinir.jsp
    Created on : 14/05/2016, 03:11:11
    Author     : Wensttay, Victor Hugo
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="io.github.herocode.ecmat.enums.PaymentStatus"%>
<%@page import="io.github.herocode.ecmat.entity.ShortCourseItemView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="pt">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Encontro Cajazeirense de Matemática">
        <meta name="author" content="Wensttay">
        <meta name="author" content="Victor Hugo">
        <title>ECMAT 2016 | Minicursos e Oficinas</title>

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

        <style>
            .background-clean{
                background-color: rgba(0,0,0,0.0) !important;
            }
            .selected-course{
                background-color: rgba(255,255,255,0.2);
            }
            .full-enrollment{
                background-color: rgba(255,0,0, 0.2); 
            }

            .shortcource-title{
                text-align: left;
            }

            .unsub-course-btn{
                border: 2px solid rgba(255,0,0, 0.4); 
                background-color: rgba(255,0,0, 0.4); 
                color: rgba(255,255,255, 1);
            }

            .unsub-course-btn:hover{
                border: 2px solid rgba(255,0,0, 0.8); 
                background-color: rgba(255,0,0, 0.8); 
                color: rgba(255,255,255, 1);
            }

            .course-btn{
                text-align: center;
                width: 120px;
                height: 50px;
                border-radius: 5px; 
                float: right; 
                font-size: 20px;
                padding: 10px 10px 5px 10px;
                cursor: pointer;
            }

            .sub-course-btn{
                border: 2px solid rgba(107,142,35, 0.4);
                background-color: rgba(107,142,35, 0.4);
                color: rgba(255,255,255, 1);
            }

            .sub-course-btn:hover{
                border: 2px solid rgba(107,142,35, 0.8);
                background-color: rgba(107,142,35, 0.8);
                color: rgba(255,255,255, 1);
            }

            .big-margin-top{
                margin-top: 150px;
            }

            .shortcourse-header-font-size{
                font-size: 24px;
            }

            .shortcourse-div{
                padding: 16px 20px;
            }

            .shortcourse-div .shortcource-name{
                float: left;
                font-size: 16px;
                margin-top: 15px;
                max-width: 700px;
            }

            .shortcourse-div .shortcource-enrollment{
                float: right; font-size: 20px; padding: 12px;
            }

            .focus{
                color: yellow;
            }
        </style>
    </head>

    <body>
        <%@ include file="pages/alert_error_model.jsp" %>
        <%@ include file="pages/alert_success_model.jsp" %> 
        <div id="container-fullpage">
            <div class="background blackboard-background"></div>

            <header class="erro-header-box blackboard-background">
                <a href="index.jsp">
                    <div class="erro-header-item">
                        <img class="erro-logo default-low-opacity" src="img/logo/logo-ecmat2016-75x75.png">
                    </div>
                </a>
                <c:if test="${!empty sessionScope.participant}">
                    <div>
                        <a style="font-size: 18px; font-weight: bold;float:right; margin-right: 50px; margin-top: 60px;" 
                           title="Clique para ir para a página da Organização." 
                           class="default-low-color-white-transparence" href="Logut">Sair</a>
                    </div>
                    <div>
                        <a style="font-size: 18px; font-weight: bold;float:right; margin-right: 50px; margin-top: 60px;" 
                           title="Clique para ir para a página da Organização." 
                           class="default-low-color-white-transparence" href="ParticipantPanel">Painel Principal</a>
                    </div>
                </c:if>
                <c:if test="${empty sessionScope.participant}">
                    <div>
                        <a style="font-size: 18px; font-weight: bold;float:right; margin-right: 50px; margin-top: 60px;" 
                           title="Clique para ir para a página da Organização." 
                           class="default-low-color-white-transparence" href="/#cadastro">Cadastro</a>
                    </div>
                    <div>
                        <a style="font-size: 18px; font-weight: bold;float:right; margin-right: 50px; margin-top: 60px;" 
                           title="Clique para ir para a página da Organização." 
                           class="default-low-color-white-transparence" href="/#login">Login</a>
                    </div>
                </c:if>
            </header>

            <section>
                <article class="big-margin-top">
                    <div class="container text-center">

                        <div id="morningShortCoursesHeader" class="row medium-margin-bottom">
                            <p class="article-title default-border-color default-low-color-white-transparence col-lg-12 ">Minicursos e Oficinas</p> 
                        </div>

                        <div class="container medium-margin-bottom">
                            <p class="shortcourse-header-font-size">Turno da Manhã <span class="focus">( Dia 25/08 | Inicio: 9:15 )</span></p>

                            <c:forEach items="${morningShortCourseItems}" var="mSCI" varStatus="status">

                                <div 
                                    <c:if test="${status.last}">
                                        id="aftermoonShortCoursesHeader"
                                    </c:if>
                                    class="panel-group col-lg-12 ">

                                    <div class="panel default-border 
                                         <c:if test="${!empty sessionScope.participant and mSCI.userIsRegistred}">
                                        selected-course
                                        </c:if>
                                        <c:if test="${empty sessionScope.participant or !mSCI.userIsRegistred}">
                                            background-clean
                                        </c:if>
                                        ">

                                        <div class="background-clean shortcourse-div">  
                                            <a href="${mSCI.url}" class="shortcource-title" target="_blank">
                                                <p class="panel-title shortcource-name">
                                                    <span class="focus">${mSCI.shortCourseType.typeName}:</span> ${mSCI.title} 
                                                    </br><span class="focus">Duração:</span> ${mSCI.duration}
                                                    </br><span class="focus">---> CLIQUE PARA VER MAIS <---</span></p>
                                            </a>
                                            <c:if test="${!empty sessionScope.participant}">
                                                <c:if test="${mSCI.userIsRegistred}">
                                                    <button class="course-btn unsub-course-btn" name="shortCourseId" value="${mSCI.id}">Cancelar</button>
                                                </c:if>
                                                <c:if test="${!mSCI.userIsRegistred}">
                                                    <div class="course-btn sub-course-btn" name="shortCourseId" value="${mSCI.id}">Participar</div>
                                                </c:if>
                                            </c:if>    
                                            <p class="shortcource-enrollment">
                                                Vagas: <span id="${mSCI.id}"></span>/${mSCI.maxEnrollment}</p>
                                            <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                        </div>

                                    </div>
                                </div>
                            </c:forEach>    
                        </div>

                        <div class="container medium-margin-bottom">
                            <p class="shortcourse-header-font-size">Turno da Tarde <span class="focus">( Dia 25/08 | Inicio: 13:30 )</span></p>

                            <c:forEach items="${aftermoonShortCourseItems}" var="mSCI" varStatus="status">
                                <div 
                                    <c:if test="${status.last}">
                                        id="nightShortCoursesHeader"
                                    </c:if>
                                    class="panel-group col-lg-12 ">

                                    <div class="panel default-border 
                                         <c:if test="${!empty sessionScope.participant and mSCI.userIsRegistred}">
                                        selected-course
                                        </c:if>
                                        <c:if test="${empty sessionScope.participant or !mSCI.userIsRegistred}">
                                            background-clean
                                        </c:if>
                                        ">

                                        <div class="background-clean shortcourse-div"> 
                                            <a href="${mSCI.url}" class="shortcource-title" target="_blank">
                                                <p class="panel-title shortcource-name">
                                                    <span class="focus">${mSCI.shortCourseType.typeName}:</span> ${mSCI.title} 
                                                    </br><span class="focus">Duração:</span> ${mSCI.duration}
                                                    </br><span class="focus">---> CLIQUE PARA VER MAIS <---</span></p>
                                            </a>
                                            <c:if test="${!empty sessionScope.participant}">
                                                <c:if test="${mSCI.userIsRegistred}">
                                                    <button class="course-btn unsub-course-btn" name="shortCourseId" value="${mSCI.id}">Cancelar</button>
                                                </c:if>
                                                <c:if test="${!mSCI.userIsRegistred}">
                                                    <div class="course-btn sub-course-btn" name="shortCourseId" value="${mSCI.id}">Participar</div>
                                                </c:if>
                                            </c:if>    
                                            <p class="shortcource-enrollment">
                                                Vagas: <span id="${mSCI.id}"></span>/${mSCI.maxEnrollment}</p>
                                            <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                        </div>

                                    </div>
                                </div>
                            </c:forEach>    
                        </div>

                        <div class="container medium-margin-bottom">
                            <p class="shortcourse-header-font-size">Turno da Noite <span class="focus">( Dia 25/08 | Inicio: 17:45 )</span></p>

                            <c:forEach items="${nightShortCourseItems}" var="mSCI">
                                <div class="panel-group col-lg-12 ">

                                    <div class="panel default-border 
                                         <c:if test="${!empty sessionScope.participant and mSCI.userIsRegistred}">
                                        selected-course
                                        </c:if>
                                        <c:if test="${empty sessionScope.participant or !mSCI.userIsRegistred}">
                                            background-clean
                                        </c:if>
                                        ">

                                        <div class="background-clean shortcourse-div">   
                                            <a href="${mSCI.url}" class="shortcource-title" target="_blank">
                                                <p class="panel-title shortcource-name">
                                                    <span class="focus">${mSCI.shortCourseType.typeName}:</span> ${mSCI.title} 
                                                    </br><span class="focus">Duração:</span> ${mSCI.duration}
                                                    </br><span class="focus">---> CLIQUE PARA VER MAIS <---</span></p>
                                            </a>
                                            <c:if test="${!empty sessionScope.participant}">
                                                <c:if test="${mSCI.userIsRegistred}">
                                                    <button class="course-btn unsub-course-btn" name="shortCourseId" value="${mSCI.id}">Cancelar</button>
                                                </c:if>
                                                <c:if test="${!mSCI.userIsRegistred}">
                                                    <div class="course-btn sub-course-btn" name="shortCourseId" value="${mSCI.id}">Participar</div>
                                                </c:if>
                                            </c:if>    
                                            <p class="shortcource-enrollment">
                                                Vagas: <span id="${mSCI.id}"></span>/${mSCI.maxEnrollment}</p>
                                            <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>    
                        </div>
                        <div class="row notice">
                            <p style="font-family: WC_RoughTrad;">* Os minicursos e as inscrições para os mesmos estarão disponíveis em breve, fique atento !</p>
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
        
        <script src="js/jquery-2.2.2.min.js" type="text/javascript"></script>
        <!-- Bootstrap JavaScript -->
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        
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

            $('.unsub-course-btn').click(function (e) {
                e.preventDefault();
                alert(this.val());
//                $.post('RequestPasswordRecovery', this., function (response) {
//                    var success = response.success;
//                    var error = response.error;
//
//                    if (success !== undefined) {
//                        show_success(success);
//                    } else {
//                        show_error(error);
//                    }
//                });
            });
            
            $('#input-success-modal').click(function (){
                location.reload();
            });
            
            $('#input-error-modal').click(function (){
                location.reload();
            });
            
            $('.sub-course-btn').click(function (e) {
                e.preventDefault();
                var ShortCourseId = this.getAttribute("value");
                var url = "ShortCourseRegister?ShortCourseId=" + ShortCourseId;
                $.ajax({
                    url: url,
                    cache: false,
                    type: "GET",
                    success: function (response) {
                        var success = response.success;
                        var error = response.error;
                        
                        if (success !== undefined) {
                            show_success(success);
                        } else {
                            show_error(error);
                        }
                        
                        
                    },
                });
            });
        </script>
    </body>
</html>



