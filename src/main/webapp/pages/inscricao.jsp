<%-- 
    Document   : inicio
    Created on : 14/05/2016, 03:20:57
    Author     : Wensttay
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article class="container-base" id="inscricao">
    <div class="container text-center">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="col-md-12">
                    <h1>Login</h1>
                    <form id="form-login" method="POST" class="form-horizontal" style="font-family: arial;"role="form">
                        <label class="col-sm-2 col-xs-2">Email:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="email" type="text" class="form-control" style="font-size: 14px;">
                        </div>
                        <label class="col-sm-2 col-xs-2">Senha:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="password" type="password" class="form-control" style="font-size: 14px;"> 
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <a href="#recuperacao" style="margin-left: 15px;"><small style="float: left">Esqueci minha Senha</small></a>
                            <button type="submit" id="efetuar-login" style="float: right;" class="btn btn-default" >Enviar</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6" style="margin-top: 50px !important;">
                <div class="col-xs-2"></div>
                <a href="#cadastro">
                    <div class="default-dashed-border col-xs-8" style="display: table;background-color: rgba(255,255,255,0.2);">
                        <h2>Criar uma Conta</h2>
                    </div>
                </a>
                <div class="col-xs-2"></div>
            </div>
            <div class="col-md-3"></div>
        </div>
    </div>
</article>


