<%--
  Created by IntelliJ IDEA.
  User: ck
  Date: 2018/6/21
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的活动</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../../../lib/weui.css">
    <link rel="stylesheet" href="../../../../css/jquery-weui.css">
    <script src="../../../../lib/jquery-2.1.4.js"></script>
    <script src="../../../../js/jquery-weui.js"></script>


    <style>

        .weui_navbar_item.weui_bar_item_on {
            background-color: #46fff2;
        }
    </style>
</head>
<body>
<div class="hd">
    <h2 class="page_title" style="text-align:center">我的活动</h2>
</div>
<div class="weui_tab">
    <div class="weui_navbar">
        <a href="#tab1" class="weui_navbar_item weui_bar_item_on">
            全部活动
        </a>
        <a href="#tab2" class="weui_navbar_item">
            待开始的活动
        </a>
        <a href="#tab3" class="weui_navbar_item">
            已完成的活动
        </a>
    </div>
    <!--<div class="weui_tab_bd">
        <p>主体内容放这里</p>
    </div>-->

    <style>
        .clear{clear: both;}
        .margin_50{margin-top: 52px;}
        .pad_6{padding-left: 6px;padding-right: 6px;}
        .mag_item{width: 100%;height: auto;}
        .mag_item img{width: 100%;height: auto;border: 0;}
    </style>
    <div class="clear margin_50"></div>
    <div class="weui_tab_bd">
        <div id="tab1" class="weui_tab_bd_item weui_tab_bd_item_active pad_6">
            <div class="weui_grids">
                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_button.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动时间
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_panel.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动类型
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_tab.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动主题
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_toast.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动地点
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_toast.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动总结
                    </p>
                </a>

                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_toast.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动评价
                    </p>
                </a>
            </div>
        </div>
        <div id="tab2" class="weui_tab_bd_item">
            <div class="weui_grids">
                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_button.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动时间
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_panel.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动类型
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_tab.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动主题
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_toast.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动地点
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_toast.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动总结
                    </p>
                </a>

                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_toast.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动评价
                    </p>
                </a>
            </div>
        </div>
        <div id="tab3" class="weui_tab_bd_item">
            <div class="weui_grids">
                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_button.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动时间
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_panel.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动类型
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_tab.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动主题
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_toast.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动地点
                    </p>
                </a>



                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_toast.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动总结
                    </p>
                </a>

                <a href="javascript:;" class="weui_grid">
                    <div class="weui_grid_icon">
                        <img src="./images/icon_nav_toast.png" alt="">
                    </div>
                    <p class="weui_grid_label">
                        活动评价
                    </p>
                </a>
            </div>
        </div>

    </div>
</div>

<script>
    $(function() {

        var i=0;
        $(".weui_navbar a").bind("click", function(){

            //css操作
            alert(i++);
            //操作导航栏
            $(".weui_bar_item_on").removeClass('weui_bar_item_on');
            //console.log($(this).find("a"));
            $(this).addClass("weui_bar_item_on");

            //操作内容切换
            $(".weui_tab_bd .weui_tab_bd_item_active").removeClass('weui_tab_bd_item_active');
            var data_toggle =jQuery(this).attr("href");
            $(data_toggle).addClass("weui_tab_bd_item_active");
            // $(this).addClass("weui_tab_bd_item_active");

        });
    });
</script>
</body>
</html>
