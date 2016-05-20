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
            $destino.fadeIn(1000);
            $('html, body').animate({scrollTop: 0}, 'slow');
        });

    }
//    if ($('body').css('overflow') === 'hidden' && $(this).parent().hasClass('page-link')) {
//        $("body").css("overflow", "auto"); /* Show scrollbar body */
//    }
});

$('#menu-principal-button').click(function () {
    $('.div_mapa').css("display", 'none');
    $('.menu-principal-box').animate({"margin-right": '0px'});
//    $("body").css("overflow", "hidden"); /* Hidden scroll bar body to fix mobile bug */
});

$('#exit-menu-principal-button').click(function () {
    $('.menu-principal-box').animate({"margin-right": '-100%'});
    $('.div_mapa').css("display", 'block');
//    $("body").css("overflow", "auto"); /* Show scrollbar body */
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
    $('.div_mapa').css("display", 'block');
}

function dropDownSubmenu() {
    if ($(this).find("ul").css('display') === 'none') {

        $(this).find('.list-item-withsublist-title span.glyphicon').removeClass('glyphicon-triangle-bottom');
        $(this).find('.list-item-withsublist-title span.glyphicon').addClass('glyphicon-triangle-top');
        $(this).find("ul").css("visibility", "visible");
        $(this).find("ul").slideDown();
        $(this).find("ul").css("display", 'block');

        $('.sublist-isOpen').find("ul").slideUp();
        $('.sublist-isOpen').find('.list-item-withsublist-title span.glyphicon').addClass('glyphicon-triangle-bottom');
        $('.sublist-isOpen').find('.list-item-withsublist-title span.glyphicon').removeClass('glyphicon-triangle-top');

        $('.sublist-isOpen').removeClass('sublist-isOpen');
        $(this).addClass('sublist-isOpen');

    } else {
        $(this).removeClass('sublist-isOpen');
        $(this).find('.list-item-withsublist-title span.glyphicon').addClass('glyphicon-triangle-bottom');
        $(this).find('.list-item-withsublist-title span.glyphicon').removeClass('glyphicon-triangle-top');
        $(this).find("ul").slideUp();
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
        $('li.principal-list-item-withsublist').unbind("click", dropDownSubmenu);

        $('li.principal-list-item-withsublist').unbind("mouseenter", mouseEnterSumenu);
        $('li.principal-list-item-withsublist').bind("mouseenter", mouseEnterSumenu);

        $('li.principal-list-item-withsublist').unbind("mouseleave", mouseLeaveSumenu);
        $('li.principal-list-item-withsublist').bind("mouseleave", mouseLeaveSumenu);
        
        $('.menu-principal-box').css("margin", '0 auto');
    } else {

        $("li.page-link").unbind("click", menuSlideRight);
        $("li.page-link").bind("click", menuSlideRight);

        $('li.principal-list-item-withsublist').unbind("click", dropDownSubmenu);
        $('li.principal-list-item-withsublist').bind("click", dropDownSubmenu);

        $('li.principal-list-item-withsublist').unbind("mouseenter", mouseEnterSumenu);
        $('li.principal-list-item-withsublist').unbind("mouseleave", mouseLeaveSumenu);

        $('.menu-principal-box').css("margin-right", '-100%');
    }
};


