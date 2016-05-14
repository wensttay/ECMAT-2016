/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var anchor = window.top.location.hash;
    var anchorAux = anchor.substring(1, anchor.length);

    var anchorElementAux = document.getElementById(anchorAux);

    if (anchorElementAux === null) {
        anchor = '#home';
    }


    var elementoVisivel = document.getElementsByClassName('exibindo');
    $(elementoVisivel).addClass('invisivel');
    $(elementoVisivel).removeClass('exibindo');

    $(anchor).removeClass('invisivel');
    $(anchor).addClass('exibindo');

    var elementosInvisiveis = document.getElementsByClassName('invisivel');

    for (var i = elementosInvisiveis.length - 1; i >= 0; i--) {
        elementosInvisiveis[i].style.display = 'none';
    };
});

$('a[href^="#"]').bind('click', function (evento) {
    // evento.preventDefault();
    // var origem = this.hash, $destino = $(origem);

    var destino = $(this).attr('href'), $destino = $(destino);

    var elementos = document.getElementsByClassName('exibindo');
    var origem = elementos[0], $origem = $(origem);

    if (!$origem.is($destino)) {
        $origem.fadeOut(function () {

            $origem.removeClass('exibindo');
            $origem.addClass('invisivel');

            $destino.removeClass('invisivel');
            $destino.addClass('exibindo');
            // $destino.css('display', 'block');
            $destino.fadeIn(400);

            // var section = document.getElementById('section');

            // if($(section).height() < $(window).height()){
            //     var section_height = document.getElementById('section').clientHeight;

            //     document.getElementById('footer').style.marginTop = $(window).height() - (section_height + document.getElementById('footer').clientHeight) + 'px';
            // }else{
            //     document.getElementById('footer').style.marginTop = '73px';
            // }    
        });
    }

});