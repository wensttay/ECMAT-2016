<%-- 
    Document   : sobre
    Created on : 14/05/2016, 03:21:22
    Author     : Wensttay
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    .responsive-container {
        position: relative;
        width: 100%;
    }

    .dummy {
        padding-top: 100%; /* forces 1:1 aspect ratio */
    }

    .container-ajust {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        font: 0/0 a;
        text-align:center; /* Align center inline elements */
    }

    .container-ajust:before {
        display: inline-block;
        vertical-align: middle;
        content: ' ';
        height: 100%;
    }

    .container-ajust img, .container-ajust p{
        vertical-align: middle;
        display: inline-block;
    }

</style>

<article class="container-base invisivel sobre-font" id="sobre">
    <div class="container">
        <div class="row"> 
            <div class="col-md-2"></div>
            <div class="col-md-8 text-justify"> 
                <div class="text-center article-title"><p>Sobre</p></div>


                <div class="sobre-paragraph col-md-12 col-sm-12">
                    <p>
                        O Encontro Cajazeirense de Matemática (ECMAT) trata-se de um evento promovido pela Coordenação do Curso de Licenciatura em Matemática do Instituto Federal de Educação, Ciência e Tecnologia da Paraíba – IFPB/Campus Cajazeiras e tem, como um de seus objetivos, a divulgação das atividades desenvolvidas pelos alunos do curso de Licenciatura em Matemática ofertado pelo referido campus.
                    </p>
                </div>

                <div class="sobre-paragraph col-md-6 col-sm-6">
                    <div class="responsive-container">
                        <div class="dummy"></div>

                        <div class="container-ajust">
                            <img src="img/logo-clean.png" width="60%">
                        </div>
                    </div>
                </div>
                
                <div class="sobre-paragraph col-md-6 col-sm-6">
                    <p>
                        Além disso, o evento, que já está em sua terceira edição, visa também estreitar os laços entre alunos e professores da região, buscando cada vez mais incentivar a todos pelo estudo da Matemática e áreas afins de uma forma mais dinâmica e interativa através de palestras, minicursos, exposições e apresentações de artigos.    
                    </p>
                </div>

                <div class="sobre-paragraph col-md-12 col-sm-12">
                    <p>
                        O III ECMAT acontecerá nos dias 24, 25 e 26 de agosto de 2016.
                        Nesse dia, matemáticos ligados à área da educação devem promover dinâmicas, bem como demonstrar que a Matemática é de grande importância para a evolução da sociedade através de atividades variadas que abordem as suas inúmeras utilizações.
                    </p>
                </div>
                <div class="sobre-paragraph col-md-12 col-sm-12">
                    <p>
                        Nesse dia, matemáticos ligados à área da educação devem promover dinâmicas, bem como demonstrar que a Matemática é de grande importância para a evolução da sociedade através de atividades variadas que abordem as suas inúmeras utilizações.
                    </p>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
</article>