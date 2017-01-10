<%-- 
    Document   : alert_success_model.jsp
    Created on : 14/05/2016, 03:20:57
    Author     : Wensttay de Sousa Alencar <yattsnew@gmail.com>
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="successModal" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header align-center">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title text-success" style="font-family: WC_RoughTrad;">Operação Concluída</h4>
      </div>
      <div class="modal-body align-center">
        <p id="success-body" style="color:black; font-family: WC_RoughTrad;"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" id="input-success-modal" data-dismiss="modal" >Ok!</button>
      </div>
    </div>

  </div>
</div>