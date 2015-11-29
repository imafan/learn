/**
 * Created by imafan on 2015/11/29 0029.
 */

requirejs.config({
   baseUrl : "/js",   //如果指定了baseUrl，那么在该模块引用别的模块都是相对于baseUrl
   paths: {
       jquery: "jquery-1.11.2.min"
   }
}) ;

requirejs(["jquery","learn_2/backtop"],function($,backtop){
    /*var scroll = new scrollto.ScrollTo({
        speed: 2000
    });

    $("#backTop").on("click", $.proxy(scroll.move,scroll));*/

    new backtop.BackTop($("#backTop"),{
        mode : "move",
        speed: 3000
    })  ;

    /*$(window).on("scroll",function(){
        checkPosition($(window).height());
    })
     checkPosition($(window).height());
    function checkPosition(pos){
        if( $(window).scrollTop() > pos){
            $("#backTop").fadeIn();
        }else{
            $("#backTop").fadeOut();
        }
    }*/
});