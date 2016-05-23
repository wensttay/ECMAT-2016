<%-- 
    Document   : Organizacao
    Created on : 16/05/2016, 18:52:45
    Author     : Victor Hugo
--%>
<style>
    .organization{
        border: 5px dashed rgba(255,255,255,0.8);
        border-radius: 20px;
        padding: 30px;
        margin-bottom: 100px;
    }

    .organization-box{
        margin: 0 auto;
        display: table;
    }

    .organization-list{
        margin: 0;
        padding: 0;
        overflow-x: scroll;
    }

    .list-size-4{
        width: calc(214px * 4);
    }
    .list-size-3{
        width: calc(214px * 3);
    }
    .list-size-2{
        width: calc(214px * 2);
    }
    .list-size-1{
        width: calc(214px * 1);
    }

    ::-webkit-scrollbar{
        display: none;
    }

    @media screen and (max-width: 1200px){
        .list-size-4{
            width: calc(214px * 3);
        }
        .list-size-3{
            width: calc(214px * 3);
        }
        .list-size-2{
            width: calc(214px * 2);
        }
        .list-size-1{
            width: calc(214px * 1);
        }
    }
    @media screen and (max-width: 993px){
        .list-size-4{
            width: calc(214px * 2);
        }
        .list-size-3{
            width: calc(214px * 2);
        }
        .list-size-2{
            width: calc(214px * 2);
        }
        .list-size-1{
            width: calc(214px * 1);
        }
    }
    @media screen and (max-width: 610px){
        .list-size-4{
            width: calc(214px * 1);
        }
        .list-size-3{
            width: calc(214px * 1);
        }
        .list-size-2{
            width: calc(214px * 1);
        }
        .list-size-1{
            width: calc(214px * 1);
        }
    }

    .people-box,
    .scroll-button{
        height: 200px;
    }

    .people-box{
        display: table-cell;
        width: 200px;
        padding: 15px;
    }

    .people{
        margin: 0;
        padding: 0;
        width: 100%;
        background-color: rgba(255, 255, 255, 1);
        padding: 7px;
        cursor: pointer;
    }

    .people .small-profile:hover{
        opacity: 1;
    }

    .people .small-profile .photo{
        max-height: 170px;
        min-height: 170px;
        max-width: 170px;
        min-width: 170px;
        text-align: center;
    }
    .people .small-profile .photo img{
        height: 100%;
        /*width: 100%;*/
        max-width:100%;
        max-height:100%;
        -webkit-filter: grayscale();
        filter: grayscale(1);
    }

    .people .small-profile .photo img:hover{
        -webkit-filter: none;
        filter: none;
    }

    .people .small-profile .name{
        width: 100%;
        color: black;
        text-align: center;
        font-size: 18px;
        font-weight: bold;
        font-family: DESYREL;
        padding: 1em 0 1em 0;
    }
    .people .small-profile .name p{
        height: 40px;
    }

    .scroll-button{
        font-size: 100px;
        padding: calc(1em - 30px) 0 calc(1em - 30px) 0;
        margin: 0;
        color: rgba(255,255,255, 0.8);
        cursor: pointer;
    }

    .scroll-button a{
        padding:0px;
        margin:0px;
    }

    .scroll-button-left{
        float: left;
    }
    .scroll-button-right{
        float: right;
    }

    @media screen and (max-width: 820px){
        .scroll-button-left{
            position: absolute;
            float: none;
            left: 0;
        }
        .scroll-button-right{
            position: absolute;
            float: none;
            right: 0;
        }
    }

</style>



<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article class="container-base invisivel sobre-font" id="organizacao">
    <div class="container">
        <div class="row">
            <p class="text-center article-title col-sm-12">Desenvolvedores</p>
        </div>
        <div class="row">
            <div class="organization">
                <a class="scroll-button scroll-button-left disabled"> < </a>
                <a class="scroll-button scroll-button-right"> > </a>
                <div class="organization-box">
                    <ul class="organization-list list-size-4">
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/sem_foto.png"/>
                                    </div>
                                    <div class="name">
                                        <p>Antônia Edivaneide de Sousa Gonzaga</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/sem_foto.png"/>
                                    </div>
                                    <div class="name">
                                        <p>Wensttay de Sousa Alencar</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/wens.jpg"/>
                                    </div>
                                    <div class="name">
                                        <p>Wensttay de Sousa Alencar</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/victor.jpg"/>
                                    </div>
                                    <div class="name">
                                        <p>Victor Hugo da Silva Ribeiro</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/victor.jpg"/>
                                    </div>
                                    <div class="name">
                                        <p>Victor Hugo da Silva Ribeiro</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/victor.jpg"/>
                                    </div>
                                    <div class="name">
                                        <p>Victor Hugo da Silva Ribeiro</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>

                </div> 
            </div>
        </div>


        <div class="row">
            <p class="text-center article-title col-sm-12">Desenvolvedores</p>
        </div>
        <div class="row">
            <div class="organization">
                <a class="scroll-button scroll-button-left disabled"> < </a>
                <a class="scroll-button scroll-button-right"> > </a>
                <div class="organization-box">
                    <ul class="organization-list list-size-4">
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/sem_foto.png"/>
                                    </div>
                                    <div class="name">
                                        <p>Antônia Edivaneide de Sousa Gonzaga</p>
                                    </div>
                                    <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/sem_foto.png"/>
                                    </div>
                                    <div class="name">
                                        <p>Wensttay de Sousa Alencar</p>
                                    </div>
                                    <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/wens.jpg"/>
                                    </div>
                                    <div class="name">
                                        <p>Wensttay de Sousa Alencar</p>
                                    </div>
                                    <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/victor.jpg"/>
                                    </div>
                                    <div class="name">
                                        <p>Victor Hugo da Silva Ribeiro</p>
                                    </div>
                                    <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/victor.jpg"/>
                                    </div>
                                    <div class="name">
                                        <p>Victor Hugo da Silva Ribeiro</p>
                                    </div>
                                    <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                </div>
                            </div>
                        </li>
                        <li class="people-box">
                            <div class="people">
                                <div class="small-profile">
                                    <div class="photo">
                                        <img src="img/organizacao/victor.jpg"/>
                                    </div>
                                    <div class="name">
                                        <p>Victor Hugo da Silva Ribeiro</p>
                                    </div>
                                    <span style="clear: both; content: ''; display: block; margin: 0;"></span>
                                </div>
                            </div>
                        </li>
                    </ul>

                </div> 
            </div>
        </div>
    </div>
</article>