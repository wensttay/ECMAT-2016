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

    if ($destino.length && !$origem.is($destino)) {
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

$(document).ready(function () {
    menuControl();
});

$(window).resize(function () {
    menuControl();
});

var menuControl = function () {
    var windowSize = $(window).width();
    if (windowSize >= 805) {
        $('li.principal-list-item-withsublist').mouseenter(function () {
            $(this).find("ul").css("visibility", "visible");
        });

        $('li.principal-list-item-withsublist').mouseleave(function () {
            $(this).find("ul").css("visibility", "hidden");
        });

        $('.menu-principal-box').css("margin", '0 auto');
    } else {
        
        $('.page-link a').click(function () {
            $('.menu-principal-box').animate({"margin-right": '-100%'});
            $('iframe').css("display", 'block');
        });

        $('#menu-principal-button').click(function () {
            $('iframe').css("display", 'none');
            $('.menu-principal-box').animate({"margin-right": '0px'});

        });

        $('#close-menu-button span').click(function () {
            $('.menu-principal-box').animate({"margin-right": '-100%'});
            $('iframe').css("display", 'block');
        });

        $('li.principal-list-item-withsublist').click(function () {
            if ($(this).find("ul").css('display') === 'none') {
                $(this).find("ul").slideDown();
            } else {
                $(this).find("ul").slideUp();
            }
        });
    }
};


