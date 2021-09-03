<%--
  Created by IntelliJ IDEA.
  User: qzlzzz
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
    <script src="${pageContext.request.contextPath}/static/js/pageJs/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/pageJs/Filickity.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/pageJs/banner.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajax/first.js"></script>
</head>
<body>
<div id="container">
    <div id="top"></div>
    <div id="header">
        <div class="header_left_box">
            <a id="login_register" href="${pageContext.request.contextPath}/index.jsp">登录/注册</a>
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
            <img src="${pageContext.request.contextPath}/static/css/img/other/9XpPN9Je3m.png"/>
        </div>
    </div>
    <div id="nav">
        <nav class="navMenu">
            <a href="#">HOME</a>
            <a id="0101" href="javascript:void(0)">战术游戏</a>
            <a id="0201" href="javascript:void(0)">RPG游戏</a>
            <a id="0301" href="javascript:void(0)">竞技游戏</a>
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
                    <div id="goods_id_one" class="img_1">
                        <img id="goods_img_one" src="${pageContext.request.contextPath}/static/css/img/game_img/0201/02010001.png" >
                        <h3 id="goods_name_one">巫师三</h3>
                        <span id="goods_price_one">127</span>元<br/>
                        <br/>
                        <button id="btn_one"> ->shop </button>
                    </div>
                    <div id="goods_id_two" class="img_2">
                        <img id="goods_img_two" src="${pageContext.request.contextPath}/static/css/img/game_img/0201/02010002.png" />
                        <h3 id="goods_name_two">刺客信条奥德赛</h3>
                        <span id="goods_price_two">298</span>元<br/>
                        <br/>
                        <button id="btn_two"> ->shop </button>
                    </div>
                </div>
                <div class="box_left">
                    <div id="goods_id_three" class="img_1 "><img id="goods_img_three" src="${pageContext.request.contextPath}/static/css/img/game_img/0201/02010003.png" ><h3 id="goods_name_three">赛博朋克2077</h3>
                        <span id="goods_price_three">298</span>元<br/>
                        <button id="btn_three"> ->shop </button>
                    </div>
                    <div id="goods_id_four" class="img_3"><img id="goods_img_four" src="${pageContext.request.contextPath}/static/css/img/game_img/0201/02010004.png" ><h3 id="goods_name_four">古墓丽影</h3>
                        <span id="goods_price_four">242</span>元<br/>
                        <button id="btn_four"> ->shop </button>
                    </div>
                    <div id="goods_id_five" class="img_2 "><img id="goods_img_five" src="${pageContext.request.contextPath}/static/css/img/game_img/0201/02010005.png" ><h3 id="goods_name_five">刺客信条-英灵殿</h3>
                        <span id="goods_price_five">198</span>元<br/>
                        <br/>
                        <button id="btn_five" type="button"> ->shop </button>
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
                    <li><img src="${pageContext.request.contextPath}/static/css/img/other/kefu.jpg" ></li>
                    <li><font color="white" style="margin-left: 40px;">客服电话:110</font></li>
                </ol></li>

            </ul>
        </div>
        <div id="final">
            <img src="${pageContext.request.contextPath}/static/css/img/other/9XpPN9Je3m.png" >
            <h6>随便写写</h6>
        </div>
    </div>
</div>
</body>
</html>
