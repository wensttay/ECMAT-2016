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
                    <form id="form-cadastro" method="POST" class="form-horizontal" style="font-family: arial;" role="form">

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-3 col-xs-12 label-cadastro">Nome Completo:</label>
                            <div class="col-sm-9 col-xs-12">
                                <input name="name" type="text" class="form-control" style="font-size: 14px;" required="required">
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-3 col-xs-12 label-cadastro">Nascimento:</label>
                            <div class="col-sm-9 col-xs-12">
                                <input name="birth-date" placeholder="DD-MM-YYYY" type="date" class="form-control" style="font-size: 14px;" 
                                       max="2015-01-01" min="1876-01-01"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-3 col-xs-12 label-cadastro">Titulação:</label>
                            <div class="col-sm-9 col-xs-12">
                                <select name="titration" class="form-control">
                                    <c:forEach items="${Titrations.values()}" var="titration">
                                        <option>${titration.titration}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-3 col-xs-12 label-cadastro">CPF:</label>
                            <div class="col-sm-9 col-xs-12">
                                <input name="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" 
                                       title="Digite o CPF no formato nnn.nnn.nnn-nn"
                                       type="text" class="form-control" style="font-size: 14px;"
                                       onkeypress="javascript: add_mask(this, cpf_mask);"  maxlength="14"
                                       placeholder="Apenas números"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12" style="margin-bottom: 0;">
                            <label class="col-sm-3 col-xs-12 label-cadastro">DDD:</label>
                            <div class="col-sm-2 col-xs-12" style="margin-bottom: 15px">
                                <input name="ddd" type="text" class="form-control" pattern="\[0-9]{2}\"
                                       title="Digite o DDD, apenas números"
                                       style="font-size: 14px;" 
                                       onkeypress="javascript: add_mask(this, number_only);" maxlength="2"> 
                            </div>
                            <label class="col-sm-3 col-xs-12 label-cadastro">Telefone:</label>
                            <div class="col-sm-4 col-xs-12" style="margin-bottom: 15px">
                                <input name="phone" class="form-control" style="font-size: 14px;" type="tel" required="required" 
                                       title="Digite o Telefone"
                                       maxlength="12"
                                       onkeypress="javascript: add_mask(this, number_only);">
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12" style="margin-bottom: 0;">
                            <label class="col-sm-3 col-xs-12 label-cadastro">Estado:</label>
                            <div class="col-sm-3 col-xs-12" style="margin-bottom: 15px">
                                <select name="state" class="form-control">
                                    <c:forEach items="${States.values()}" var="state">
                                        <option 
                                            <c:if test="${state.name().equals('PB')}">selected</c:if>
                                                >
                                            ${state.name()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <label class="col-sm-2 col-xs-12 label-cadastro">Cidade:</label>
                            <div class="col-sm-4 col-xs-12" style="margin-bottom: 15px">
                                <input name="city" type="text" class="form-control" style="font-size: 14px;" maxlength="50"> 
                            </div>
                        </div>


                        <div class="form-group col-sm-12 col-xs-12" style="margin-bottom: 0;">
                            <label class="col-sm-3 col-xs-12 label-cadastro">Endereço:</label>
                            <div class="col-sm-5 col-xs-12" style="margin-bottom: 15px">
                                <input name="street" type="text" class="form-control" style="font-size: 14px;"> 
                            </div>
                            <label class="col-sm-2 col-xs-12 label-cadastro">Numero:</label>
                            <div class="col-sm-2 col-xs-12" style="margin-bottom: 15px">
                                <input name="number" class="form-control" style="font-size: 14px;"
                                       onkeypress="javascript: add_mask(this, number_only);" maxlength="5"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12" style="margin-bottom: 0;">
                            <label class="col-sm-3 col-xs-12 label-cadastro">CEP:</label>
                            <div class="col-sm-3 col-xs-12" style="margin-bottom: 15px">
                                <input name="postal-code" type="text" class="form-control" style="font-size: 14px;"
                                       onkeypress="javascript: add_mask(this, number_only);"
                                       maxlength="8"> 
                            </div>
                            <label class="col-sm-2 col-xs-12 label-cadastro">Bairro:</label>
                            <div class="col-sm-4 col-xs-12" style="margin-bottom: 15px">
                                <input name="district" type="text" class="form-control" maxlength="50" style="font-size: 14px;"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-3 col-xs-12 label-cadastro">Email:</label>
                            <div class="col-sm-9 col-xs-12">
                                <input name="email" type="email" class="form-control" style="font-size: 14px;" required="required" class="input-text" 
                                       title="Digite o Email no formato nome@email.com"
                                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" >
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <label class="col-sm-3 col-xs-12 label-cadastro">Senha:</label>
                            <div class="col-sm-9 col-xs-12">
                                <input name="password" type="password" class="form-control" style="font-size: 14px;"
                                       placeholder="Ao menos 6 dígitos alfanuméricos"> 
                            </div>
                        </div>

                        <div class="form-group col-sm-12 col-xs-12">
                            <div class="col-sm-12 col-xs-12">
                                <input type="submit" id="efetuar-cadastro" style="float: right;" class="btn btn-default" value="Registrar" >
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-md-3"></div>
        </div>
    </div>
</article>
