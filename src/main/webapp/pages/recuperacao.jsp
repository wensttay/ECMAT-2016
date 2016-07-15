<%-- 
    Document   : inicio
    Created on : 14/05/2016, 03:20:57
    Author     : Wensttay
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article class="container-base" id="recuperacao">
    <div class="container text-center">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="col-md-12">
                    <h1>Recuperar Senha</h1>
                    <form action="RequestPasswordRecovery" method="POST" class="form-horizontal" style="font-family: arial;"role="form">
                        <label class="col-sm-2 col-xs-2">Email:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="email" type="text" class="form-control" style="font-size: 14px;">
                        </div>
                        <div class="form-group col-sm-12 col-xs-12">
                            <input type="submit" style="float: right;" class="btn btn-default" >
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
    </div>
</article>
