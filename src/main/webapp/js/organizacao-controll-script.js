
/**
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com> 
 */

$('.scroll-button-right').click(function () {
    var leftScroll = $(this).parent().find('.organization-box .organization-list').scrollLeft();
    var peopleBoxWidth = $(this).parent().find('.organization-box .organization-list .people-box:first-child').width();
    var peopleBoxPadding = $(this).parent().find('.organization-box .organization-list .people-box:first-child').css("padding-right").replace("px", "");
    peopleBoxWidth += (peopleBoxPadding * 2);
    var mod = leftScroll % peopleBoxWidth;
    var sizeOfScroll = peopleBoxWidth - mod;

    $(this).parent().find('.organization-box .organization-list').animate({scrollLeft: '+=' + sizeOfScroll + 'px'}, 500);
});

$('.scroll-button-left').click(function () {
    var leftScroll = $(this).parent().find('.organization-box .organization-list').scrollLeft();
    var peopleBoxWidth = $(this).parent().find('.organization-box .organization-list .people-box:first-child').width();
    var peopleBoxPadding = $(this).parent().find('.organization-box .organization-list .people-box:first-child').css("padding-right").replace("px", "");
    peopleBoxWidth += (peopleBoxPadding * 2);
    var mod = leftScroll % peopleBoxWidth;
    var sizeOfScroll = peopleBoxWidth;
   
    if (mod > 1) {
        sizeOfScroll = mod;
    }
    
    $(this).parent().find('.organization-box .organization-list').animate({scrollLeft: '-=' + sizeOfScroll + 'px'}, 500);
});


var lastScrollLeft = 0;
$('.organization-box .organization-list').scroll(function () {
    var documentScrollLeft = $(this).scrollLeft();
    if (lastScrollLeft !== documentScrollLeft) {
        lastScrollLeft = documentScrollLeft;

        var thisWidth = $(this).width();
        var numblerOfPeoples = $(this).find('.people-box').length;
        var firstPeople = $(this).find('.people-box:first-child');
        var withOfPeople = firstPeople.width() + firstPeople.css("padding-right").replace("px", "") * 2;

        var realWidth = numblerOfPeoples * withOfPeople;

        if (thisWidth === realWidth || lastScrollLeft >= (realWidth - thisWidth)) {
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

$(document).ready(function () {
    changeScrollsVisibitily();
});

$(window).resize(function () {
    changeScrollsVisibitily();
});

function changeScrollsVisibitily() {
    $('.organization-list').each(function () {
        var documentScrollLeft = $(this).scrollLeft();
        var thisWidth = $(this).width();
        var numblerOfPeoples = $(this).find('.people-box').length;
        var firstPeople = $(this).find('.people-box:first-child');
        var withOfPeople = firstPeople.width() + firstPeople.css("padding-right").replace("px", "") * 2;
        var realWidth = numblerOfPeoples * withOfPeople;

        if (thisWidth === realWidth || lastScrollLeft >= (realWidth - thisWidth)) {
            $(this).parent().parent().find('.scroll-button-right').addClass('disabled');
        } else {
            $(this).parent().parent().find('.scroll-button-right').removeClass('disabled');
        }

        if (documentScrollLeft === 0) {
            $(this).parent().parent().find('.scroll-button-left').addClass('disabled');
        } else {
            $(this).parent().parent().find('.scroll-button-left').removeClass('disabled');
        }
    });
}