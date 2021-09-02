<%--
  Created by IntelliJ IDEA.
  User: qzlzzz
  Date: 2021/8/10
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册登录页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css"/>
</head>
<body>
<div class="container">
    <div class="hero">
        商城系统
    </div>
    <div class="welcome">
        <div class="pinkbox">
            <!-- 注册 -->
            <div class="signup nodisplay">
                <h1>Register</h1>
                <form autocomplete="off" method="post" action="${pageContext.request.contextPath}/register">
                    <input id="register_userName" name="nick" type="text" placeholder="Username" />
                    <input id="register_userEmail"  name="email" type="email" placeholder="Email">
                    <input id="register_userPassword"  name="password" type="password" placeholder="Password">
                    <input type="password" placeholder="Confirm Password">
                    <button class="button sumbit" id="register">Create Account</button>
                </form>
            </div>

            <!-- 登录 -->
            <div class="signin">
                <h1>Sign In</h1>
                <form class="more-padding" autocomplete="off" method="post" action="${pageContext.request.contextPath}/login">
                    <input id="sign_userName" name="nick" type="text" placeholder="Username">
                    <input id="sign_userPassword" name="password" type="password" placeholder="Password">
                    <div class="checkbox">
                        <input type="checkbox" id="remember" /><label for="remember">Remember me</label>
                    </div>
                    <button class="buttom sumbit" id="sign">Login</button>
                </form>
            </div>
        </div>

        <div class="leftbox">
            <h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
            <p class="desc">Pick your perfect <span>bouquet</span></p>
            <img class="flower smaller" src="${pageContext.request.contextPath}/static/css/img/other/webp.webp" />
            <p class="account">Have an account?</p>
            <button class="button" id="signin">Login</button>
        </div>

        <div class="rightbox">
            <h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
            <p class="desc">Pick your perfect <span>bouquet</span></p>
            <img class="flower" src="${pageContext.request.contextPath}/static/css/img/other/webp.webp"/>
            <p class="account">Don't have an account?</p>
            <button class="button" id="signup">Sign Up</button>
        </div>
    </div>
</div>

<!-- partial -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/pageJs/jquery-3.6.0.js"></script>
<script src="${pageContext.request.contextPath}/static/js/pageJs/index.js"></script>
</body>
</html>