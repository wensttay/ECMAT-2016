<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="io.github.herocode.ecmat.model.ShortCourseBusinessImpl"%>
<%@page import="io.github.herocode.ecmat.entity.ShortCourse"%>
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
        </style>
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

                        <div class="row medium-margin-bottom">
                            <p class="article-title default-border-color default-low-color-white-transparence col-lg-12 ">Minicursos e Oficinas</p> 
                        </div>
                        
                        <div class="container medium-margin-bottom">
                            <p style="font-size: 24px;">Turno da Manhã (Inicio: 7:00)</p>
                            <div class="panel-group col-lg-12 " id="accordion">
                                <div class="panel default-border selected-course">
                                    <a href="#" class="shortcource-title">
                                        <div class="background-clean" style="padding: 16px 20px;">                                          
                                            <p class="panel-title" style="float: left; font-size: 16px; margin-top: 15px;">Nome do Minicurso (Duração)</p>
                                            
                                            <!--<div class="course-btn sub-course-btn">Participar</div>-->
                                            <button class="course-btn unsub-course-btn">Cancelar</button>
                                            
                                            <p style="float: right; font-size: 20px; padding: 12px;">Vagas: 10/30</p>
                                            <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                        </div>
                                    </a>
                                </div>
                                <div class="panel default-border background-clean">
                                    <a href="#" class="shortcource-title">
                                        <div class="background-clean" style="padding: 16px 20px;">                                          
                                            <p class="panel-title" style="float: left; font-size: 16px; margin-top: 15px;">Nome do Minicurso (Duração)</p>
                                            
                                            <div class="course-btn sub-course-btn">Participar</div>
                                            <!--<button class="course-btn unsub-course-btn">Cancelar</button>-->
                                            
                                            <p style="float: right; font-size: 20px; padding: 12px;">Vagas: 10/30</p>
                                            <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>

                        <div class="container medium-margin-bottom">
                            <p style="font-size: 24px;">Turno da Tarde (Inicio: 14:00)</p>
                            <div class="panel-group col-lg-12 " id="accordion">
                                <div class="panel default-border selected-course">
                                    <a href="#" class="shortcource-title">
                                        <div class="background-clean" style="padding: 16px 20px;">                                          
                                            <p class="panel-title" style="float: left; font-size: 16px; margin-top: 15px;">Nome do Minicurso (Duração)</p>

                                            <button class="course-btn unsub-course-btn" >Cancelar</button>
                                            <p style="float: right; font-size: 20px; padding: 12px;">Vagas: 10/30</p>
                                            <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                        </div>
                                    </a>
                                </div>
                                <div class="panel default-border background-clean">
                                    <a href="#" class="shortcource-title">
                                        <div class="background-clean" style="padding: 16px 20px;">                                          
                                            <p class="panel-title" style="float: left; font-size: 16px; margin-top: 15px;">Nome do Minicurso (Duração)</p>
                                            <div class="course-btn sub-course-btn">Participar</div>
                                            <p style="float: right; font-size: 20px; padding: 12px;">Vagas: 10/30</p>
                                            <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>

                        <div class="container medium-margin-bottom">
                            <p style="font-size: 24px;">Turno da Noite (Inicio: 19:00)</p>
                            <div class="panel-group col-lg-12 " id="accordion">
                                <div class="panel default-border selected-course">
                                    <a href="#" class="shortcource-title">
                                        <div class="background-clean" style="padding: 16px 20px;">                                          
                                            <p class="panel-title" style="float: left; font-size: 16px; margin-top: 15px;">Nome do Minicurso (Duração)</p>

                                            <button class="course-btn unsub-course-btn" >Cancelar</button>
                                            <p style="float: right; font-size: 20px; padding: 12px;">Vagas: 10/30</p>
                                            <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                        </div>
                                    </a>
                                </div>
                                <div class="panel default-border background-clean">
                                    <a href="#" class="shortcource-title">
                                        <div class="background-clean" style="padding: 16px 20px;">                                          
                                            <p class="panel-title" style="float: left; font-size: 16px; margin-top: 15px;">Nome do Minicurso (Duração)</p>
                                            <div class="course-btn sub-course-btn">Participar</div>
                                            <p style="float: right; font-size: 20px; padding: 12px;">Vagas: 10/30</p>
                                            <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                        </div>
                                    </a>
                                </div>
                            </div>
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
            <script src="js/jquery-2.2.2.min.js" type="text/javascript"></script>
            <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        </div>
    </body>
</html>



