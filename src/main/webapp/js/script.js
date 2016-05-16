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
            $('html, body').animate({scrollTop: 0}, 'slow');
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

$('#close-menu-button span').click(function () {
    $('.menu-principal-box').animate({"margin-right": '-100%'});
    $('iframe').css("display", 'block');
});

$('#menu-principal-button').click(function () {
    $('iframe').css("display", 'none');
    $('.menu-principal-box').animate({"margin-right": '0px'});
});

var windowSize = $(window).width();
$(document).ready(function () {
    menuControl();
});

$(window).resize(function () {
    menuControl();
});

function menuSlideRight() {
    $('.menu-principal-box').animate({"margin-right": '-100%'});
    $('iframe').css("display", 'block');
}
function dropDownSubmenu() {
    if ($(this).find("ul").css('display') === 'none') {
        $(this).find("ul").css("visibility", "visible");
        $(this).find('.list-item-withsublist-title span.glyphicon').removeClass('glyphicon-triangle-bottom');
        $(this).find('.list-item-withsublist-title span.glyphicon').addClass('glyphicon-triangle-top');
        $(this).find("ul").slideDown();
        $(this).find("ul").css("display", 'block');

    } else {
        $(this).find('.list-item-withsublist-title span.glyphicon').addClass('glyphicon-triangle-bottom');
        $(this).find('.list-item-withsublist-title span.glyphicon').removeClass('glyphicon-triangle-top');
        $(this).find("ul").slideUp();
//        $(this).find("ul").css("display", 'none');
    }
}
function mouseEnterSumenu() {
    $(this).find("ul").css("display", 'block');
    $(this).find("ul").css("visibility", "visible");
    $(this).find('.list-item-withsublist-title span.glyphicon').removeClass('glyphicon-triangle-bottom');
    $(this).find('.list-item-withsublist-title span.glyphicon').addClass('glyphicon-triangle-top');
}
function mouseLeaveSumenu() {
    $(this).find("ul").css("display", 'none');
    $(this).find("ul").css("visibility", "hidden");
    $(this).find('.list-item-withsublist-title span.glyphicon').addClass('glyphicon-triangle-bottom');
    $(this).find('.list-item-withsublist-title span.glyphicon').removeClass('glyphicon-triangle-top');
}

var menuControl = function () {
    windowSize = $(window).width();
    if (windowSize >= 820) {
        $("li.page-link").unbind("click", menuSlideRight);
        alert("TO GRANDAO");
        $('li.principal-list-item-withsublist').unbind("click", dropDownSubmenu);
        $('li.principal-list-item-withsublist').bind("mouseenter", mouseEnterSumenu);
        $('li.principal-list-item-withsublist').bind("mouseleave", mouseLeaveSumenu);
        $('.menu-principal-box').css("margin", '0 auto');
    } else {
        $("li.page-link").bind("click", menuSlideRight);
        
        if (!$('li.principal-list-item-withsublist').bind("click", dropDownSubmenu)) {
            $('li.principal-list-item-withsublist').bind("click", dropDownSubmenu);
        }
        $('li.principal-list-item-withsublist').unbind("mouseenter", mouseEnterSumenu);
        $('li.principal-list-item-withsublist').unbind("mouseleave", mouseLeaveSumenu);
        $('.menu-principal-box').css("margin-right", '-100%');
    }
};


