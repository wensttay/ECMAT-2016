
/**
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com> 
 */

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