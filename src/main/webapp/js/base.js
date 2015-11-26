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

var loader = new SVGLoader( document.getElementById( 'loader' ), { speedIn : 200, easingIn : mina.linear } );
function loadContent(url, fn){
    $("#content").hide();
    loader.show();
    $("#content").load(url,function(res){

        //loader.hide();
        //$("#content").show();
        if(fn && typeof fn == "function"){
            fn.call(this,arguments);
        }
    });
}