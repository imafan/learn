<div class="page-sidebar-wrapper">
    <div id="sidebar" class="page-sidebar">
        <ul class="">
            <li>
                <a href="#">
                    <span class="title">Dashboard</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li>
                <a href="#">帖子管理</a>
            </li>
            <li>
                <a href="#">帖子管理</a>
            </li>
        </ul>
    </div>

</div>

<script>
    $(function(){
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
</script>