/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(myFunction());

$('a[href^="#"]').bind('click', function (evento) {
    var destino = $(this).attr('href'), $destino = $(destino);

    var elementos = document.getElementsByClassName('exibindo');
    var origem = elementos[0], $origem = $(origem);

    if ( $destino.length && !$origem.is($destino)) {
        $origem.fadeOut(function () {

            $origem.removeClass('exibindo');
            $origem.addClass('invisivel');

            $destino.removeClass('invisivel');
            $destino.addClass('exibindo');
            $destino.fadeIn(400);
        });
    }
});

function myFunction() {
    var anchor = window.top.location.hash;
    var anchorAux = anchor.substring(1, anchor.length);

    var anchorElementAux = document.getElementById(anchorAux);

    if (anchorElementAux === null) {
        anchor = '#inicio';
    }

    var elementoVisivel = document.getElementsByClassName('exibindo');
    $(elementoVisivel).addClass('invisivel');
    $(elementoVisivel).removeClass('exibindo');

    $(anchor).removeClass('invisivel');
    $(anchor).addClass('exibindo');

    var elementosInvisiveis = document.getElementsByClassName('invisivel');

    for (var i = elementosInvisiveis.length - 1; i >= 0; i--) {
        elementosInvisiveis[i].style.display = 'none';
    }
    ;
}

$('li.principal-list-item-withsublist').mouseenter(function () {
    $(this).find("ul").css("visibility", "visible");
});

$('li.principal-list-item-withsublist').mouseleave(function () {
    $(this).find("ul").css("visibility", "hidden");
});