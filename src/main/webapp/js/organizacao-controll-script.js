/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('.scroll-button-right').click(function () {
    var leftScroll = $(this).parent().find('.organization-box .organization-list').scrollLeft();
    var peopleBoxWidth = $(this).parent().find('.organization-box .organization-list .people-box:first-child').width();
    var peopleBoxPadding = $(this).parent().find('.organization-box .organization-list .people-box:first-child').css("padding-right").replace("px", "");
    peopleBoxWidth  += (peopleBoxPadding * 2);
    var mod = leftScroll % peopleBoxWidth;
    var sizeOfScroll = peopleBoxWidth - mod;
    
    $(this).parent().find('.organization-box .organization-list').animate({scrollLeft: '+=' + sizeOfScroll + 'px'}, 500); 
});

$('.scroll-button-left').click(function () {
    var leftScroll = $(this).parent().find('.organization-box .organization-list').scrollLeft();
    var peopleBoxWidth = $(this).parent().find('.organization-box .organization-list .people-box:first-child').width();
    var peopleBoxPadding = $(this).parent().find('.organization-box .organization-list .people-box:first-child').css("padding-right").replace("px", "");
    peopleBoxWidth  += (peopleBoxPadding * 2);
    var mod = leftScroll % peopleBoxWidth;
    var sizeOfScroll = peopleBoxWidth - mod;

    $(this).parent().find('.organization-box .organization-list').animate({scrollLeft: '-=' + sizeOfScroll + 'px'}, 500);
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

//$('.people').click(function (){
//    $(this).css('background-color', 'rgba(0,0,0, 0.2');
//    $(this).find('.photo-box').slideUp();
//    $(this).find('.name').css('margin-top', '+= 35px').css('color', 'white');
//});