<%-- 
    Document   : inicio
    Created on : 14/05/2016, 03:20:57
    Author     : Wensttay
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article class="container-base" id="cadastro">
    <div class="container text-center">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="col-md-12">
                    <h1>Cadastro</h1>
                    <form action="ParticipantRegister" method="POST" class="form-horizontal" style="font-family: arial;"role="form">
                        <label class="col-sm-2 col-xs-2">Nome:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="name" type="text" class="form-control" style="font-size: 14px;">
                        </div>
                        <label class="col-sm-2 col-xs-2">Aniversário:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="birth" type="date" class="form-control" style="font-size: 14px;"> 
                        </div>
                        <label class="col-sm-2 col-xs-2">Titulação:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <select name="titration" class="form-control">
                                <option></option>
                            </select>
                        </div>

                        <label class="col-sm-2 col-xs-2">CPF:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="cpf" type="text" class="form-control" style="font-size: 14px;"> 
                        </div>
                        <label class="col-sm-2 col-xs-2">DDD:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="ddd" type="number" class="form-control" style="font-size: 14px;"> 
                        </div>
                        <label class="col-sm-2 col-xs-2">Telefone:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="phone" class="form-control" style="font-size: 14px;" type="tel" required="required" maxlength="15" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" />
                        </div>
                        <label class="col-sm-2 col-xs-2">Email:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="email" type="email" class="form-control" style="font-size: 14px;" required="required" class="input-text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" />
                        </div>
                        <label class="col-sm-2 col-xs-2">Senha:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="password" type="password" class="form-control" style="font-size: 14px;"> 
                        </div>
                        <label class="col-sm-2 col-xs-2">Endereço:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="street" type="text" class="form-control" style="font-size: 14px;"> 
                        </div>
                        <label class="col-sm-2 col-xs-2">Numero:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="number" type="number" class="form-control" style="font-size: 14px;"> 
                        </div>
                        <label class="col-sm-2 col-xs-2">Bairro:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="district" type="text" class="form-control" style="font-size: 14px;"> 
                        </div>
                        <label class="col-sm-2 col-xs-2">Cidade:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="city" type="text" class="form-control" style="font-size: 14px;"> 
                        </div>
                        <label class="col-sm-2 col-xs-2">CEP:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <input name="postal-code" type="number" class="form-control" style="font-size: 14px;"> 
                        </div>
                        <label class="col-sm-2 col-xs-2">Estado:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <select name="state" class="form-control">
                                <option></option>
                            </select>
                        </div>
                        <label class="col-sm-2 col-xs-2">Pais:</label>
                        <div class="form-group col-sm-10 col-xs-10">
                            <select name="country" class="form-control">
                                <option></option>
                            </select>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <input type="submit" style="float: right;" class="btn btn-default" value="Registrar" >
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-md-3"></div>
        </div>
    </div>
</article>
