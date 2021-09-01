<%--
  Created by IntelliJ IDEA.
  User: qzlaaa
  Date: 2021/8/12
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%--未完成--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/first.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/Filickity.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/banner.js"></script>
    <script type="text/javascript">
        $(function (){
            $.ajax({
                url:"${pageContext.request.contextPath}/loginAndRegister",
                dataType:"text",
                type:"get",
                success:function (res){
                    $("#login_register").html(res);
                }
            })
        })
    </script>
</head>
<body>
<div id="container">
    <div id="top"></div>
    <div id="header">
        <div class="header_left_box">
            <a id="login_register">登录/注册</a>
        </div>
        <div class="header_right_box_one">
            <a href="javascript:void(0)">我的账户</a>
        </div>
        <div class="header_right_box_two">
            <a href="javascript:void(0)">购物车</a>
        </div>
        <div class="header_left_box_three">
            <a href="javascript:void(0)">收藏夹</a>
        </div>
    </div>
    <div id="search">
        <div class="left animate__bounceIn">
            <img src="${pageContext.request.contextPath}/static/css/img/9XpPN9Je3m.png"/>
        </div>
    </div>
    <div id="nav">
        <nav class="navMenu">
            <a href="#">HOME</a>
            <a id="0100" href="#">战术游戏</a>
            <a id="0200" href="#">RPG游戏</a>
            <a id="0300" href="#">竞技游戏</a>
            <div class="dot"></div>
        </nav>
    </div>
    <div id="goods">

    </div>

    <div id="banner">
        <div id="banner_header">
            限时打折
        </div>
        <div class="carousel">
            <div class="slider">

                <div class="card">
                    <div class="card-bg" style="background-image: url(https://coverfiles.alphacoders.com/737/73733.jpg);">
                    </div>
                </div>

                <div class="card">
                    <div class="card-bg" style="background-image: url(https://media.playstation.com/is/image/SCEA/star-wars-jedi-fallen-order-square-art-01-ps4-us-29may19?$native_nt$);">
                    </div>
                </div>


                <div class="card">
                    <div class="card-bg" style="background-image: url(https://lumiere-a.akamaihd.net/v1/images/lego-star-wars-skywalker-saga-main_c0051eca.jpeg?region=0%2C0%2C1000%2C999&width=960);">
                    </div>
                </div>

                <div class="card">
                    <div class="card-bg" style="background-image: url(https://droidjournal.com/wp-content/uploads/2020/04/ghost-of-tsushima.jpg);">
                    </div>
                </div>


                <div class="card">
                    <div class="card-bg" style="background-image: url(https://www.rockstargames.com/V/img/global/order/mobile-cover.jpg);">
                    </div>
                </div>

                <div class="card">
                    <div class="card-bg" style="background-image: url(https://i.pinimg.com/originals/14/21/72/14217228af3726b095b9805b991e1c16.jpg);">
                    </div>
                </div>
                <div class="card">
                    <div class="card-bg" style="background-image: url(https://media.playstation.com/is/image/SCEA/star-wars-jedi-fallen-order-square-art-01-ps4-us-29may19?$native_nt$);">
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div id="service">
        <div class="box">
            <div class="box_top">
                每月精选游戏
            </div>
            <div class="box_main">
                <div class="box_right">
                    <div class="img_1">
                        <img src="https://droidjournal.com/wp-content/uploads/2020/04/ghost-of-tsushima.jpg" >
                        <p>对马岛之魂</p>
                        <img style="width: 20px; height: 20px; margin-top: 10px;" src="${pageContext.request.contextPath}/static/css/img/car.jpg" ><a href="javascript:void(0)">购买</a>
                    </div>
                    <div class="img_2">
                        <img src="https://i.pinimg.com/originals/14/21/72/14217228af3726b095b9805b991e1c16.jpg" >
                        <p>蜘蛛侠</p>
                        <img style="width: 20px; height: 20px; margin-top: 10px;" src="${pageContext.request.contextPath}/static/css/img/car.jpg" ><a href="javascript:void(0)">购买</a>
                    </div>
                </div>
                <div class="box_left">
                    <div class="img_1 "><img src="${pageContext.request.contextPath}/static/css/img/game_two.png" ><p>鬼泣</p>
                        <img style="width: 20px; height: 20px; margin-top: 10px;" src="${pageContext.request.contextPath}/static/css/img/car.jpg" ><a href="javascript:void(0)">购买</a>
                    </div>
                    <div class="img_3"><img src="${pageContext.request.contextPath}/static/css/img/game_one.png" ><p>GTA5</p>
                        <img style="width: 20px; height: 20px; margin-top: 10px;" src="${pageContext.request.contextPath}/static/css/img/car.jpg" ><a href="javascript:void(0)">购买</a>
                    </div>
                    <div class="img_2 "><img src="${pageContext.request.contextPath}/static/css/img/game_three.png" ><p>我的世界</p>
                        <img style="width: 20px; height: 20px; margin-top: 10px;" src="${pageContext.request.contextPath}/static/css/img/car.jpg" ><a href="javascript:void(0)">购买</a>
                    </div>
                </div>
            </div>

        </div>
        <div id="footer">
            <ul>
                <li><ol>
                    <li><a href="javascript:void(0)">关于我们</a></li>
                    <li><a href="javascript:void(0)">关于游戏</a></li>
                    <li><a href="javascript:void(0)">新闻中心</a></li>
                    <li><a href="javascript:void(0)">人才招聘</a></li>
                </ol></li>
                <li><ol>
                    <li><a href="javascript:void(0)">推荐游戏</a></li>
                    <li><a href="javascript:void(0)">对马岛之魂</a></li>
                    <li><a href="javascript:void(0)">蜘蛛侠</a></li>
                    <li><a href="javascript:void(0)">金色沙滩</a></li>
                </ol></li>
                <li><ol>
                    <li><a href="javascript:void(0)">购物相关</a></li>
                    <li><a href="javascript:void(0)">周边产品</a></li>
                    <li><a href="javascript:void(0)">线下体验店</a></li>
                    <li><a href="javascript:void(0)">客户服务政策</a></li>
                </ol></li>
                <li><ol>
                    <li><a href="javascript:void(0)">会员中心</a></li>
                    <li><a href="javascript:void(0)">会员注册</a></li>
                    <li><a href="javascript:void(0)">会员登录</a></li>
                </ol></li>
                <li><ol>
                    <li><a href="javascript:void(0)"><span class="xl"></span>新浪微博</a></li>
                    <li><a href="javascript:void(0)"><span class="tx"></span>腾讯微博</a></li>
                    <li><a href="javascript:void(0)"><span class="rr"></span>人人网</a></li>
                    <li><a href="javascript:void(0)"><span class="qq"></span>QQ</a></li>
                </ol></li>
                <li><ol>
                    <li><a href="javascript:void(0)">关于我们</a></li>
                    <li><a href="javascript:void(0)">关于游戏</a></li>
                    <li><a href="javascript:void(0)">新闻中心</a></li>
                    <li><a href="javascript:void(0)">人才招聘</a></li>
                </ol></li>
                <li style="margin-left: 50px;"><ol>
                    <li><img src="${pageContext.request.contextPath}${pageContext.request.contextPath}/static/css/img/kefu.jpg" ></li>
                    <li><font color="white" style="margin-left: 40px;">客服电话:110</font></li>
                </ol></li>

            </ul>
        </div>
        <div id="final">
            <img src="${pageContext.request.contextPath}${pageContext.request.contextPath}/static/css/img/9XpPN9Je3m.png" >
            <h6>随便写写</h6>
        </div>
    </div>
</div>
</body>
</html>
