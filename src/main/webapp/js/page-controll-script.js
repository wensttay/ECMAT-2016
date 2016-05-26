$(document).ready(function myFunction() {
    var anchor = window.top.location.hash;
    var anchorAux = anchor.substring(1, anchor.length);

    var anchorElementAux = document.getElementById(anchorAux);

    if (anchorElementAux === null) {
        anchor = '#inicio';
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
});