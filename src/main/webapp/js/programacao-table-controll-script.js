$(".program-day-box .img-box").click(function () {
    $(this).parent().find('.img-box').css('display', 'none');
    $(this).parent().parent().find('.hour-box-list').slideDown();
});

$(".program-day-box .title").click(function () {
    if ($(this).parent().find('.img-box').css('display') === 'none') {
        $(this).parent().find('.hour-box-list').slideUp();
        $(this).parent().find('.img-box').slideDown();
    } else {
        $(this).parent().find('.img-box').css('display', 'none');
        $(this).parent().parent().find('.hour-box-list').slideDown();
    }

});