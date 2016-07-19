<%-- 
    Document   : inicio
    Created on : 14/05/2016, 03:20:57
    Author     : Wensttay
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page import="io.github.herocode.ecmat.enums.Titrations"%>
<%@page import="io.github.herocode.ecmat.enums.States"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article class="container-base" id="cadastro">
    <div class="container text-center">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="col-md-12">
                    <h1>Cadastro</h1>
                    <form action="ParticipantRegister" method="POST" class="form-horizontal" style="font-family: arial;" role="form">

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-2 col-xs-12">Nome:</label>
                            <div class="col-sm-10 col-xs-12">
                                <input name="name" type="text" class="form-control" style="font-size: 14px;">
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-2 col-xs-12">Aniversário:</label>
                            <div class="col-sm-10 col-xs-12">
                                <input name="birth-date" placeholder="DD-MM-YYYY" type="date" class="form-control" style="font-size: 14px;" 
                                       min="2015-01-01" max="1876-01-01"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-2 col-xs-12">Titulação:</label>
                            <div class="col-sm-10 col-xs-12">
                                <select name="titration" class="form-control">
                                    <c:forEach items="${Titrations.values()}" var="titration">
                                        <option>${titration.titration}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-2 col-xs-12">CPF:</label>
                            <div class="col-sm-10 col-xs-12">
                                <input name="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" 
                                       title="Digite o CPF no formato nnn.nnn.nnn-nn"
                                       type="text" class="form-control" style="font-size: 14px;"
                                       onkeypress="javascript: add_mask(this, cpf_mask);"  maxlength="14"
                                       placeholder="Apenas números"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12" style="margin-bottom: 0;">
                            <label class="col-sm-2 col-xs-12">DDD:</label>
                            <div class="col-sm-2 col-xs-12" style="margin-bottom: 15px">
                                <input name="ddd" type="text" class="form-control" pattern="\[0-9]{2}\"
                                       title="Digite o DDD, apenas números"
                                       style="font-size: 14px;" 
                                       onkeypress="javascript: add_mask(this, number_only);" maxlength="2"> 
                            </div>
                            <label class="col-sm-3 col-xs-12">Telefone:</label>
                            <div class="col-sm-5 col-xs-12" style="margin-bottom: 15px">
                                <input name="phone" class="form-control" style="font-size: 14px;" type="tel" required="required" 
                                       title="Digite o Telefone no formato nnnn-nnnn"
                                       maxlength="15" pattern="[0-9]{4,6}[0-9]{3,4}$" 
                                       onkeypress="javascript: add_mask(this, number_only);">
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12" style="margin-bottom: 0;">
                            <label class="col-sm-2 col-xs-12">Estado:</label>
                            <div class="col-sm-3 col-xs-12" style="margin-bottom: 15px">
                                <select name="state" class="form-control">
                                    <c:forEach items="${States.values()}" var="state">
                                        <option>${state.name()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <label class="col-sm-2 col-xs-12">Cidade:</label>
                            <div class="col-sm-5 col-xs-12" style="margin-bottom: 15px">
                                <input name="city" type="text" class="form-control" style="font-size: 14px;"> 
                            </div>
                        </div>


                        <div class="form-group col-sm-12 col-xs-12" style="margin-bottom: 0;">
                            <label class="col-sm-2 col-xs-12">Endereço:</label>
                            <div class="col-sm-6 col-xs-12" style="margin-bottom: 15px">
                                <input name="street" type="text" class="form-control" style="font-size: 14px;"> 
                            </div>
                            <label class="col-sm-2 col-xs-12">Numero:</label>
                            <div class="col-sm-2 col-xs-12" style="margin-bottom: 15px">
                                <input name="number" type="number" class="form-control" style="font-size: 14px;"
                                       onkeypress="javascript: add_mask(this, number_only);"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12" style="margin-bottom: 0;">
                            <label class="col-sm-2 col-xs-12">CEP:</label>
                            <div class="col-sm-4 col-xs-12" style="margin-bottom: 15px">
                                <input name="postal-code" pattern="\d{5}?\d{3}" type="text" class="form-control" style="font-size: 14px;"
                                       onkeypress="javascript: add_mask(this, number_only);"> 
                            </div>
                            <label class="col-sm-2 col-xs-12">Bairro:</label>
                            <div class="col-sm-4 col-xs-12" style="margin-bottom: 15px">
                                <input name="district" type="text" class="form-control" style="font-size: 14px;"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-2 col-xs-12">Email:</label>
                            <div class="col-sm-10 col-xs-12">
                                <input name="email" type="email" class="form-control" style="font-size: 14px;" required="required" class="input-text" 
                                       title="Digite o Email no formato nome@email.com"
                                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" >
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-2 col-xs-12">Senha:</label>
                            <div class="col-sm-10 col-xs-12">
                                <input name="password" type="password" class="form-control" style="font-size: 14px;"
                                       placeholder="6 dígitos alfanuméricos"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <div class="col-sm-12 col-xs-12">
                                <input type="submit" style="float: right;" class="btn btn-default" value="Registrar" >
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-md-3"></div>
        </div>
    </div>
</article>
