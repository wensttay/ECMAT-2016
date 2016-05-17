/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('#menu-principal-button').click(function () {
    $('iframe').css("display", 'none');
    $('.menu-principal-box').animate({"margin-right": '0px'});
    $("body").css("overflow", "hidden");
});

$('#exit-menu-principal-button').click(function () {
    $('.menu-principal-box').animate({"margin-right": '-100%'});
    $('iframe').css("display", 'block');
    $("body").css("overflow", "auto");
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


