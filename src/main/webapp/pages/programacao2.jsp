<%-- 
    Document   : programacao2
    Created on : 17/05/2016, 03:49:18
    Author     : Wensttay
--%>

<style>
    .program-conteiner{
        margin-bottom: 35px;
    }
    .program-day-box{
        border-radius: 20px;
        border: 5px solid rgba(255, 255, 255, 0.8);
        color: rgba(255, 255, 255, 0.8);
    }

    .program-day-box .title{
        color: rgba(255, 255, 255, 1);
        background-color: rgba(255, 255, 255, 0.2);
        opacity: 1;
        padding: 10px;
        border-bottom: 5px solid rgba(255, 255, 255, 0.8);
        margin-bottom: 0;
        font-size: 24px;
    }

    .program-day-box .title,
    .program-day-box .hour-box,
    .program-day-box .hour-box .row-box{
        width: 100%;
    }

    .program-day-box .hour-box{
        padding: 20px;
        border-bottom: 5px solid rgba(255, 255, 255, 0.8);
    }
    .program-day-box .hour-box:last-child{
        border-bottom: none;
    }
    .program-day-box .hour-box:hover{
        background-color: rgba(255, 255, 255, 0.2);
        color: rgba(255, 255, 255, 1);
        opacity: 1;
    }

    .program-day-box .hour-box .row-box:first-child{
        font-size: 18px;
        padding-left: 0;
    }
    .program-day-box .hour-box .row-box{
        font-size: 12px;
        padding-left: 20px;
        padding-right: 20px;
    }



</style>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article class="container-base invisivel sobre-font" id="programacao">

    <div class="container">
        <div class="row">
            
            <div class="col-lg-1 col-md-1 col-sm-1"></div>
            <div class="col-lg-10 col-md-10 col-sm-10">
                <p class="text-center article-title col-sm-12">Programação</p>

                <div class="col-lg-4 col-md-4 col-sm-12 program-conteiner"> <!-- Open Box Size of Day Box -->
                    <div class="program-day-box"> <!-- Open Program-Day-Box -->
                        <p class="text-center title">Dia 24/08</p>
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 18:00 até 19:00</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Credenciamento</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 19:00 até 20:00</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Solenidade de abertura</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 20:00 até 21:00</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Palesdiva de Abertura</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 21:00 até --:--</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Coffee Break</div>
                        </div> <!-- Close Hour-Box Event -->
                    </div> <!-- Close Program-Day-Box -->
                </div> <!-- Close Box Size of Day Box -->

                <div class="col-lg-4 col-md-4 col-sm-12"> <!-- Open Box Size of Day Box -->
                    <div class="program-day-box"> <!-- Open Program-Day-Box -->
                        <p class="text-center title">Dia 25/08</p>
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 13:30 até 15:30</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Minicursos</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Oficinas</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 15:30 até 15:45</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Coffee Break</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 15:45 até 17:45</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Minicursos</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Oficinas</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 19:00 até 20:20</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Mesas Redondas</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 20:20 até 20:40</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Coffee Break</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 20:40 até 22:00</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Mesas Redondas</div>
                        </div> <!-- Close Hour-Box Event -->
                    </div> <!-- Close Program-Day-Box -->
                </div> <!-- Close Box Size of Day Box -->
                
                
                <div class="col-lg-4 col-md-4 col-sm-12"> <!-- Open Box Size of Day Box -->
                    <div class="program-day-box"> <!-- Open Program-Day-Box -->
                        <p class="text-center title">Dia 26/08</p>
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 07:30 até 09:00</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Palesdiva</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 09:00 até 09:15</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Coffee Break</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 09:15 até 11:30</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Minicursos</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Oficinas</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Amosdivas de jogos e oudivas atividades envolvendo Matemática</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 13:00 até 15:00</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Apresentação de divabalhos Orais</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 15:00 até 15:30</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Apresentação de Pôster</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 15:30 até 15:45</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Coffee Break</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 15:45 até 16:15</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Cerimônia de endivega de premiação da Olimpíada Cajazeirense de
                                Matemática</div>
                        </div> <!-- Close Hour-Box Event -->
                        <div class="hour-box"> <!-- Open Hour-Box Event -->
                            <div class="row-box"><span class="glyphicon glyphicon-time"></span> 16:15 até 18:00</div>
                            <div class="row-box"><span class="glyphicon glyphicon-minus"></span> Palesdiva de Encerramento</div>
                        </div> <!-- Close Hour-Box Event -->
                    </div> <!-- Close Program-Day-Box -->
                </div> <!-- Close Box Size of Day Box -->
            </div>
            <div class="col-lg-1 col-md-1 col-sm-1"></div>
        </div>
    </div>


</article>

