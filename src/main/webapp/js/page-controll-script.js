/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('a[href^="#"]').bind('click', function (evento) {
    var destino = $(this).attr('href'), $destino = $(destino);

    var elementos = document.getElementsByClassName('exibindo');
    var origem = elementos[0], $origem = $(origem);

    if ($destino.length && !$origem.is($destino)) {
        $origem.fadeOut(function () {

            $origem.removeClass('exibindo');
            $origem.addClass('invisivel');

            $destino.removeClass('invisivel');
            $destino.addClass('exibindo');
            $destino.fadeIn(400);
            $('html, body').animate({scrollTop: 0}, 'slow');
        });
    }
});

$(document).ready(function myFunction() {
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
});