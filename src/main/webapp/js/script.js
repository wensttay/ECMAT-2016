
function init() {
    // Basic options for a simple Google Map
    // For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
    var mapOptions = {
        // How zoomed in you want the map to start at (always required)
        zoom: 17,
        // The latitude and longitude to center the map (always required)
        center: new google.maps.LatLng(-6.889654, -38.544916), // New York
        // How you would like to style the map. 
        // This is where you would paste any style found on Snazzy Maps.
        //            styles: [{"featureType":"all","elementType":"labels.text.fill","stylers":[{"saturation":36},{"color":"#000000"},{"lightness":40}]},{"featureType":"all","elementType":"labels.text.stroke","stylers":[{"visibility":"on"},{"color":"#000000"},{"lightness":16}]},{"featureType":"all","elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"featureType":"administrative","elementType":"geometry.fill","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"administrative","elementType":"geometry.stroke","stylers":[{"color":"#000000"},{"lightness":17},{"weight":1.2}]},{"featureType":"landscape","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"poi","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":21}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"color":"#000000"},{"lightness":17}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"color":"#000000"},{"lightness":29},{"weight":0.2}]},{"featureType":"road.arterial","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":18}]},{"featureType":"road.local","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":16}]},{"featureType":"transit","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":19}]},{"featureType":"water","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":17}]}]
        //            styles: [{"elementType":"geometry","stylers":[{"hue":"#ff4400"},{"saturation":-68},{"lightness":-4},{"gamma":0.72}]},{"featureType":"road","elementType":"labels.icon"},{"featureType":"landscape.man_made","elementType":"geometry","stylers":[{"hue":"#0077ff"},{"gamma":3.1}]},{"featureType":"water","stylers":[{"hue":"#00ccff"},{"gamma":0.44},{"saturation":-33}]},{"featureType":"poi.park","stylers":[{"hue":"#44ff00"},{"saturation":-23}]},{"featureType":"water","elementType":"labels.text.fill","stylers":[{"hue":"#007fff"},{"gamma":0.77},{"saturation":65},{"lightness":99}]},{"featureType":"water","elementType":"labels.text.stroke","stylers":[{"gamma":0.11},{"weight":5.6},{"saturation":99},{"hue":"#0091ff"},{"lightness":-86}]},{"featureType":"transit.line","elementType":"geometry","stylers":[{"lightness":-48},{"hue":"#ff5e00"},{"gamma":1.2},{"saturation":-23}]},{"featureType":"transit","elementType":"labels.text.stroke","stylers":[{"saturation":-64},{"hue":"#ff9100"},{"lightness":16},{"gamma":0.47},{"weight":2.7}]}]
        styles: [{"stylers": [{"hue": "#ff1a00"}, {"invert_lightness": true}, {"saturation": -100}, {"lightness": 33}, {"gamma": 0.5}]}, {"featureType": "water", "elementType": "geometry", "stylers": [{"color": "#2D333C"}]}]
                //            styles: [{"featureType":"all","elementType":"geometry","stylers":[{"color":"#dddddd"}]},{"featureType":"all","elementType":"labels.text.fill","stylers":[{"gamma":0.01},{"lightness":20}]},{"featureType":"all","elementType":"labels.text.stroke","stylers":[{"saturation":-31},{"lightness":100},{"weight":3},{"gamma":0.8}]},{"featureType":"all","elementType":"labels.icon","stylers":[{"visibility":"on"}]},{"featureType":"administrative.locality","elementType":"labels.text.fill","stylers":[{"color":"#050505"}]},{"featureType":"administrative.locality","elementType":"labels.text.stroke","stylers":[{"color":"#fef3f3"},{"weight":"3.01"}]},{"featureType":"administrative.neighborhood","elementType":"labels.text.fill","stylers":[{"color":"#0a0a0a"},{"visibility":"off"}]},{"featureType":"administrative.neighborhood","elementType":"labels.text.stroke","stylers":[{"color":"#fffbfb"},{"weight":"3.01"},{"visibility":"off"}]},{"featureType":"landscape","elementType":"geometry","stylers":[{"lightness":100},{"saturation":30}]},{"featureType":"poi.attraction","elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"featureType":"poi.park","elementType":"geometry","stylers":[{"lightness":100},{"saturation":-20}]},{"featureType":"road","elementType":"geometry","stylers":[{"lightness":10},{"saturation":-30}]},{"featureType":"road","elementType":"geometry.stroke","stylers":[{"saturation":25},{"lightness":25}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"color":"#a1a1a1"}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"color":"#292929"}]},{"featureType":"road.highway","elementType":"labels.text.fill","stylers":[{"visibility":"on"},{"color":"#202020"}]},{"featureType":"road.highway","elementType":"labels.text.stroke","stylers":[{"visibility":"on"},{"color":"#ffffff"}]},{"featureType":"road.highway","elementType":"labels.icon","stylers":[{"visibility":"simplified"},{"hue":"#0006ff"},{"saturation":"-100"},{"lightness":"13"},{"gamma":"0.00"}]},{"featureType":"road.arterial","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"color":"#686868"}]},{"featureType":"road.arterial","elementType":"geometry.stroke","stylers":[{"visibility":"on"},{"color":"#8d8d8d"}]},{"featureType":"road.arterial","elementType":"labels.text.fill","stylers":[{"visibility":"on"},{"color":"#353535"},{"lightness":"6"}]},{"featureType":"road.arterial","elementType":"labels.text.stroke","stylers":[{"visibility":"on"},{"color":"#ffffff"},{"weight":"3.45"}]},{"featureType":"road.local","elementType":"geometry.fill","stylers":[{"color":"#d0d0d0"}]},{"featureType":"road.local","elementType":"geometry.stroke","stylers":[{"lightness":"2"},{"visibility":"on"},{"color":"#999898"}]},{"featureType":"road.local","elementType":"labels.text.fill","stylers":[{"color":"#383838"}]},{"featureType":"road.local","elementType":"labels.text.stroke","stylers":[{"color":"#faf8f8"}]},{"featureType":"water","elementType":"all","stylers":[{"lightness":-20}]}]
    };

    // Get the HTML DOM element that will contain your map 
    // We are using a div with id="map" seen below in the <body>
    var mapElement = document.getElementById('map');

    // Create the Google Map using our element and options defined above
    var map = new google.maps.Map(mapElement, mapOptions);

    // Let's also add a marker while we're at it
    var marker = new google.maps.Marker({
        position: new google.maps.LatLng(-6.889654, -38.544916),
        map: map,
        title: 'IFPB - Campus Cajazeiras: \n\ - Rua José Dantas Nobres, 131 - Lot. Jardim Oasis, \n\ Cajazeiras - PB, 58900-000'
    });
}

$(document).ready(function () {
    $(window).on('hashchange', function () {
        myFunction();
    });
    myFunction();
});

var mapReady = 0;
var oldAnchor = '#inicio';
function myFunction() {
    var anchor = window.top.location.hash;
    var anchorAux = anchor.substring(1, anchor.length);
    var anchorElementAux = document.getElementById(anchorAux);

    if (anchorElementAux === null) {
        anchor = oldAnchor;
    }

    if (window.top.location.hash !== "") {
        oldAnchor = window.top.location.hash;
    }

    $(anchor + ' .off-load').each(function () {
        $(this).removeClass('off-load');
    });
    
    if(anchor === '#contato' && mapReady === 0){
        init();
        mapReady = 1;
    }
    
    if (anchor === '#construcao') {
        var pageConstruct = document.getElementsByClassName('construcao-background');
        for (var i = pageConstruct.length - 1; i >= 0; i--) {
            pageConstruct[i].style.display = 'block';
        }
    } else {
        var pageConstruct = document.getElementsByClassName('construcao-background');

        for (var i = pageConstruct.length - 1; i >= 0; i--) {
            pageConstruct[i].style.display = 'none';
        }
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
}


$('a[href^="#"]').bind('click', function (evento) {
    var destino = $(this).attr('href'), $destino = $(destino);

    var elementos = document.getElementsByClassName('exibindo');
    var origem = elementos[0], $origem = $(origem);

    if ($destino.length && !$origem.is($destino)) {
        $origem.fadeOut(function () {

            if (destino === '#construcao') {
                var pageConstruct = document.getElementsByClassName('construcao-background');
                
                for (var i = pageConstruct.length - 1; i >= 0; i--) {
                    pageConstruct[i].style.display = 'block';
                }
            } else {
                var pageConstruct = document.getElementsByClassName('construcao-background');

                for (var i = pageConstruct.length - 1; i >= 0; i--) {
                    pageConstruct[i].style.display = 'none';
                }
            }

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
        $('.sublist-isOpen').find(".list-item-withsublist-title").css('border-top', 'none');
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


$(".programacao-day-box .programacao-day-img").click(function () {
    $(this).css('display', 'none');
    $(this).parent().find('.programacao-day-body').slideDown();
});

$(".programacao-day-box .programacao-title").click(function () {
    if ($(this).parent().find('.programacao-day-img').css('display') === 'none') {
        $(this).parent().find('.programacao-day-body').slideUp();
        $(this).parent().find('.programacao-day-img').slideDown();
    } else {
        $(this).parent().find('.programacao-day-img').css('display', 'none');
        $(this).parent().find('.programacao-day-body').slideDown();
    }

});

