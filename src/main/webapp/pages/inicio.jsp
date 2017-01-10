<%-- 
    Document   : inicio.jsp
    Created on : 14/05/2016, 03:20:57
    Author     : Wensttay de Sousa Alencar <yattsnew@gmail.com>
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article class="container-base  exibindo" id="inicio">
    <div class="container text-center">
        <div class="row">

            <div class="evento-box default-dashed-border medium-margin-bottom col-md-12">    
                <h1 class="evento-nome default-low-color-white-transparence">III <span title="Encontro Cajazeirense de Matemática">ECMAT</span></h1>
                <h3 class="default-low-color-white-transparence">Terceiro Encontro Cajazeirense de Matemática</h3>
            </div>

            <div class="col-md-12">
                <div class="evento-info-box col-md-4 col-sm-4">
                    <a title="Clique para confirir o calendário de atividades." href="#programacao" class="evento-link default-low-opacity">
                        <h3>Dias 24 a 26 de Agosto</h3>
                        <img width="150px" height="150px" alt="Representação ilustrativa de um Calendário" class="evento-info-img medium-margin-bottom off-load" src="img/other/calendario.png"/>
                    </a>
                </div>
                <div class="evento-info-box col-md-4 col-sm-4">
                    <a title="Clique para conferir os contatos e a localização do envento." href="#contato" class="evento-link default-low-opacity">
                        <h3>IFPB - Campus Cajazeiras</h3>
                        <img width="150px" height="150px" alt="Representação ilustrativa de um ponto geográfico" class="evento-info-img medium-margin-bottom off-load" src="img/other/posicao.png"/>
                    </a>
                </div>
                <div class="evento-info-box col-md-4 col-sm-4">
                    <a class="disabled" title="Clique para conferir a página de inscrição." href=<c:if test="${empty sessionScope.participant}">#inicio</c:if>
                        <c:if test="${!empty sessionScope.participant}">/ParticipantPanel</c:if>
                        class="evento-link default-low-opacity">
                        <h3>Inscrições encerradas !</h3>
                        <img class="default-low-opacity" width="150px" height="150px" alt="Representação ilustrativa de um papel de inscrição" class="evento-info-img medium-margin-bottom off-load" src="img/other/inscricao.png"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</article>
