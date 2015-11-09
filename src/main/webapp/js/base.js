/**
 * Created by imafan_work on 2015/11/6 0006.
 */
$(function(){
    $('#content').on('focus', '.form-control', function () {
        $(this).closest('.input-group, .form-group').addClass('focus');
    }).on('blur', '.form-control', function () {
        $(this).closest('.input-group, .form-group').removeClass('focus');
    });


    $("#searchBar").focus(function(){
        $(this).animate({width:'300px'}, 500);
    });
    $("#searchBar").blur(function(){
        $(this).animate({width: '200px'}, 500);
    });

    $("#sidebar ul li a").click(function(){
        $(this).parent().siblings().find("span.selected").remove();
        $(this).append("<span class='selected'></span>");
    })
})

function loadContent(url){
    $("#content").load(url,function(res){
        $("#content").fadeIn();
    });
}