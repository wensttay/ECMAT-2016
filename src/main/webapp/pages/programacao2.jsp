<%-- 
    Document   : programacao2
    Created on : 17/05/2016, 03:49:18
    Author     : Wensttay
--%>

<style>
    
    .all-days-box{
        padding: 0;
        margin: 0 5%;
    }
    .programcao-day-box{
        border-radius: 20px;
        border: 5px solid rgba(255, 255, 255, 0.8);
        padding: 0;
    }

    .programcao-day-box .title{
        background-color: rgba(255, 255, 255, 0.2);
        opacity: 1;
        padding: 10px;
        border-bottom: 5px solid rgba(255, 255, 255, 0.8);
        margin-bottom: 0;
    }
    .programcao-day-box table{
        margin: 0;
        border: none;
        display: block !important;
    }

    .programcao-day-box table tbody,
    .programcao-day-box table tbody tr,
    .programcao-day-box table tbody tr td{
        display: block;
    }

    .programcao-day-box table tbody tr{
        padding:20px;
        width: 100%;
        border-bottom: 5px solid rgba(255, 255, 255, 0.8);  
    }
    .programcao-day-box table tbody tr:last-child{
        border-bottom:  none;
    }
    .programcao-day-box table tbody tr:hover{
        background-color: rgba(255, 255, 255, 0.2);
        color: white;
        opacity: 1;
    }
    .programcao-day-box table tbody tr td:first-child{
        margin-left: 0;
    }
    .programcao-day-box table tbody tr td{
        width: calc(100% - 40px);
        margin-top: 5px;
        border: none;
        outline: none;
        margin-left: 20px;
        margin-right: 20px;
    }

</style>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article class="container-base invisivel sobre-font" id="programacao">

    <div class="container">
        <div class="row">
                        <div class="col-md-1"></div>
            <div class="col-lg-12 col-md-12 col-sm-12">
                <p class="text-center article-title col-sm-12">Programação</p>
                <div class="col-md-12 all-days-box">
                    <div class="col-lg-3 col-md-3 col-sm-12 programcao-day-box">
                        <p class="text-center title">24/08</p>
                        <table>
                            <tbody>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 18:00 até 19:00</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Credenciamento</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 19:00 até 20:00</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Solenidade de abertura</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 20:00 até 21:00</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Palestra de Abertura</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 21:00 até --:--</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Coffee Break</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-lg-3 col-md-3 col-sm-12 programcao-day-box">
                        <p class="text-center title">25/08</p>
                        <table>
                            <tbody>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 13:30 até 15:30</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Minicursos</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Oficinas</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 15:30 até 15:45</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Coffee Break</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 15:45 até 17:45</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Minicursos</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Oficinas</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 19:00 até 20:20</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Mesas Redondas</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 20:20 até 20:40</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Coffee Break</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 20:40 até 22:00</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Mesas Redondas</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-lg-3 col-md-3 col-sm-12 programcao-day-box">
                        <p class="text-center title">26/08</p>
                        <table>
                            <tbody>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 07:30 até 09:00</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Palestra</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 09:00 até 09:15</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Coffee Break</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 09:15 até 11:30</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Minicursos</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Oficinas</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Amostras de jogos e outras atividades envolvendo Matemática</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 13:00 até 15:00</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Apresentação de Trabalhos Orais</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 15:00 até 15:30</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Apresentação de Pôster</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 15:30 até 15:45</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Coffee Break</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 15:45 até 16:15</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Cerimônia de entrega de premiação da Olimpíada Cajazeirense de
                                        Matemática</td>
                                </tr>
                                <tr>
                                    <td><span class="glyphicon glyphicon-time"></span> 16:15 até 18:00</td>
                                    <td><span class="glyphicon glyphicon-minus"></span> Palestra de Encerramento</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>

</article>

