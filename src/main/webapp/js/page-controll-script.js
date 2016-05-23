/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    $(anchor).fadeIn(1000);
});


$('.scroll-button-right').click(function () {
    var leftScroll = $(this).parent().find('.organization-box .organization-list').scrollLeft();
    var mod = leftScroll % 214;
    var sizeOfScroll = 214 - mod;
    
    $(this).parent().find('.organization-box .organization-list').animate({scrollLeft: '+=' + sizeOfScroll + 'x'}, 500); 
});

$('.scroll-button-left').click(function () {
    var leftScroll = $(this).parent().find('.organization-box .organization-list').scrollLeft();
    var mod = leftScroll % 214;
    var sizeOfScroll = 214 - mod;

    $(this).parent().find('.organization-box .organization-list').animate({scrollLeft: '-=' + sizeOfScroll + 'x'}, 500);
});

var lastScrollLeft = 0;
$('.organization-box .organization-list').scroll(function () {
    var documentScrollLeft = $(this).scrollLeft();
    if (lastScrollLeft !== documentScrollLeft) {
        lastScrollLeft = documentScrollLeft;

        if (documentScrollLeft === $(this).width() / 2) {
            $(this).parent().parent().find('.scroll-button-right').addClass('disabled');
        } else {
            $(this).parent().parent().find('.scroll-button-right').removeClass('disabled');
        }

        if (documentScrollLeft === 0) {
            $(this).parent().parent().find('.scroll-button-left').addClass('disabled');
        } else {
            $(this).parent().parent().find('.scroll-button-left').removeClass('disabled');
        }

    }
});