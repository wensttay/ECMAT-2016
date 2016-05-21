/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(".program-day-box .img-box").click(function () {
    $(this).parent().find('.img-box').css('display', 'none');
    $(this).parent().parent().find('.hour-box-list').slideDown(1000);
});

$(".program-day-box .title").click(function () {
    if ($(this).parent().find('.img-box').css('display') === 'none') {
        $(this).parent().find('.hour-box-list').slideUp(1000);
        $(this).parent().find('.img-box').slideDown(800);
    } else {
        $(this).parent().find('.img-box').css('display', 'none');
        $(this).parent().parent().find('.hour-box-list').slideDown(1000);
    }

});