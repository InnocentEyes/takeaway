<%--
  Created by IntelliJ IDEA.
  User: qzlaaa
  Date: 2021/8/19
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%--页面未写完--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>商品页面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/pageJs/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function(){
            $('#myButton').on('click', function () {
                var $btn = $(this).button('loading');
                // business logic...
                $btn.button('reset');
            })
        })
    </script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/goods.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="查询更多商品">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">登录/注册</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">我的信息</a></li>
                        <li><a href="#">我的订单</a></li>
                        <li><a href="#">购物车</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">返回首页</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 first">
            <img src="${pageContext.request.contextPath}/static/css/img/other/9XpPN9Je3m.png" >
        </div>
    </div>
    <div class="summary-line"></div>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-top: 50px;">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>
                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="https://www.mobygames.com/images/covers/l/330413-uncharted-4-a-thief-s-end-playstation-4-front-cover.jpg" style="width: 100%; height: 500px;">
                        <div class="carousel-caption">
                            限时精品
                        </div>
                    </div>
                    <div class="item">
                        <img src="https://lumiere-a.akamaihd.net/v1/images/lego-star-wars-skywalker-saga-main_c0051eca.jpeg?region=0%2C0%2C1000%2C999&width=960" style="width: 100%; height: 500px;">
                        <div class="carousel-caption">
                            限时精品
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
    <div class="summary-line"></div>
    <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <div class="goods_img col-xs-8 col-sm-8 col-md-8 col-lg-8" >
                <img src="${pageContext.request.contextPath}/static/css/img/other/show.jpg" >
            </div>
            <div class="collect col-xs-8 col-sm-8 col-md-8 col-lg-8"style="border: 2px solid #000000;">
                <a href="javascript:void(0)">收藏</a>
            </div>
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" style="border: 2px solid black; margin-top: 100px;">
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border: 2px solid #000000; text-align: center; margin-top: 30px;">
                <font>游戏</font>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="display: block; border: 2px solid black;">
                <h3>游戏名称 <span class="label label-default">New</span></h3>
            </div>
            <div class="summary-line"></div>
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border: 2px solid #000000; text-align: center;margin-top: 75px;">
                <font>游戏价格</font>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="display: block; border: 2px solid black;margin-top: 70px;">
									<span class="p-price">
										<span>￥</span>
										<span class="price">价格</span>
										<a href="javascript:void(0)">降价通知</a>
									</span>
            </div>
            <div class="summary-line"></div>
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border: 2px solid #000000; text-align: center; margin-top: 70px;">
                <font>配送地点</font>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="display: block; border: 2px solid black; margin-top: 70px;">
                <select>
                    <option>省份</option>
                </select>
                <select>
                    <option>城市</option>
                </select>
                <select>
                    <option>县城</option>
                </select>
            </div>
            <div class="summary-line"></div>
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="border: 2px solid #000000; text-align: center;margin-top: 70px;">
                <font>重量</font>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" style="display: block; border: 2px solid black;margin-top: 70px;">

            </div>
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="border: 2px solid black; margin-top: 70px;">
                <button type="button" id="myButton" data-loading-text="订单处理中" class="btn btn-primary" style="margin-left: 200px;">
                    加入购物车
                </button>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 100px;">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="border-radius: 20px;">
            <div class="jumbotron">
                <h1>欢迎来到游戏商城!</h1>
                <br>
                <p>本游戏商城提供各种游戏的售卖以及游戏周边的售卖!<br>
                    欢迎大家分享本游戏商城感谢您的合作!<br>
                </p>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="be-comment-block">
        <h1 class="comments-title">评论 (4)</h1>
        <div class="be-comment">
            <div class="be-img-comment">
                <a href="blog-detail-2.html">
                    <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="" class="be-ava-comment">
                </a>
            </div>
            <div class="be-comment-content">

									<span class="be-comment-name">
										<a href="blog-detail-2.html">邱泽林</a>
										</span>
                <span class="be-comment-time">
										<i class="fa fa-clock-o"></i>
										May 27, 2015 at 3:14am
									</span>

                <p class="be-comment-text">
                    这个商城真是酷毙了!
                </p>
            </div>
        </div>
        <div class="be-comment">
            <div class="be-img-comment">
                <a href="blog-detail-2.html">
                    <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="" class="be-ava-comment">
                </a>
            </div>
            <div class="be-comment-content">
								<span class="be-comment-name">
									<a href="blog-detail-2.html">吴棉锋</a>
								</span>
                <span class="be-comment-time">
									<i class="fa fa-clock-o"></i>
									May 27, 2015 at 3:14am
								</span>
                <p class="be-comment-text">
                    邱泽林真是酷毙了!
                </p>
            </div>
        </div>
        <div class="be-comment">
            <div class="be-img-comment">
                <a href="blog-detail-2.html">
                    <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="" class="be-ava-comment">
                </a>
            </div>
            <div class="be-comment-content">
								<span class="be-comment-name">
									<a href="blog-detail-2.html">邱汉钊</a>
								</span>
                <span class="be-comment-time">
									<i class="fa fa-clock-o"></i>
									May 27, 2015 at 3:14am
								</span>
                <p class="be-comment-text">
                    邱泽林帅呆了!
                </p>
            </div>
            <div class="be-comment">
                <div class="be-img-comment">
                    <a href="blog-detail-2.html">
                        <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="" class="be-ava-comment">
                    </a>
                </div>
                <div class="be-comment-content">
								<span class="be-comment-name">
									<a href="blog-detail-2.html">詹伟泰</a>
								</span>
                    <span class="be-comment-time">
									<i class="fa fa-clock-o"></i>
									May 27, 2015 at 3:14am
								</span>
                    <p class="be-comment-text">
                        邱泽林帅呆了!
                    </p>
                </div>
            </div>
            <form class="form-block">
                <div class="row">
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group fl_icon">
                            <div class="icon"><i class="fa fa-user"></i></div>
                            <input class="form-input" type="text" placeholder="用户名">
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 fl_icon">
                        <div class="form-group fl_icon">
                            <div class="icon"><i class="fa fa-envelope-o"></i></div>
                            <input class="form-input" type="text" placeholder="用户邮箱">
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div class="form-group">
                            <textarea class="form-input" required="" placeholder="发表你的评论吧!"></textarea>
                        </div>
                    </div>
                    <a class="btn btn-primary pull-right">提交</a>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <nav aria-label="Page navigation">
                <ul class="pagination" style="position: relative; left: 400px;">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<div class="container-fluid pb-0 mb-0 justify-content-center text-light ">
    <footer>
        <div class="row my-5 justify-content-center py-5">
            <div class="col-11">
                <div class="row ">
                    <div class="col-xl-8 col-md-4 col-sm-4 col-12 my-auto mx-auto a">
                        <h3 class="text-muted mb-md-0 mb-5 bold-text">Pepper.</h3>
                    </div>
                    <div class="col-xl-2 col-md-4 col-sm-4 col-12">
                        <h6 class="mb-3 mb-lg-4 bold-text "><b>MENU</b></h6>
                        <ul class="list-unstyled">
                            <li>Home</li>
                            <li>About</li>
                            <li>Blog</li>
                            <li>Portfolio</li>
                        </ul>
                    </div>
                    <div class="col-xl-2 col-md-4 col-sm-4 col-12">
                        <h6 class="mb-3 mb-lg-4 text-muted bold-text mt-sm-0 mt-5"><b>ADDRESS</b></h6>
                        <p class="mb-1">605, RATAN ICON BUILDING</p>
                        <p>SEAWOODS SECTOR</p>
                    </div>
                </div>
                <div class="row ">
                    <div class="col-xl-8 col-md-4 col-sm-4 col-auto my-md-0 mt-5 order-sm-1 order-3 align-self-end">
                        <p class="social text-muted mb-0 pb-0 bold-text"> <span class="mx-2"><i class="fa fa-facebook" aria-hidden="true"></i></span> <span class="mx-2"><i class="fa fa-linkedin-square" aria-hidden="true"></i></span> <span class="mx-2"><i class="fa fa-twitter" aria-hidden="true"></i></span> <span class="mx-2"><i class="fa fa-instagram" aria-hidden="true"></i></span> </p><small class="rights"><span>&#174;</span> Pepper All Rights Reserved.</small>
                    </div>
                    <div class="col-xl-2 col-md-4 col-sm-4 col-auto order-1 align-self-end ">
                        <h6 class="mt-55 mt-2 text-muted bold-text"><b>ANIRUDH SINGLA</b></h6><small> <span><i class="fa fa-envelope" aria-hidden="true"></i></span> anirudh@gmail.com</small>
                    </div>
                    <div class="col-xl-2 col-md-4 col-sm-4 col-auto order-2 align-self-end mt-3 ">
                        <h6 class="text-muted bold-text"><b>RISHABH SHEKHAR</b></h6><small><span><i class="fa fa-envelope" aria-hidden="true"></i></span> rishab@gmail.com</small>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</div>

</body>
</html>

