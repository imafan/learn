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

    $("body").bind("ajaxSuccess", function (e, jqXHR, s, res) {
        console.info("e",e);
        console.info("jqXHR",jqXHR);
        console.info("s",s);
        console.info("res",res);
        if(res && res.result && res.result.code && res.result.code == "C002_MNG_0005"){
            window.location.href = base + '/admin/logout';
        }
    });
})


function loadContent(url, fn){

    //$.ajax({
    //    url: url,
    //    type: "get",
    //    success: function(res){
    //
    //    }
    //})
    $("#content").load(url,function(res){
        console.info("res",res);
        if(typeof res == "string"){
            try{
                var resObj = $.parseJSON(res);
                if(!resObj.success && resObj.codeMsg === "nologin"){
                    window.location.href = base + '/admin/logout';
                }
            }catch(e){

            }
        }

        if(fn && typeof fn == "function"){
            fn.call(this,arguments);
        }
    });
}