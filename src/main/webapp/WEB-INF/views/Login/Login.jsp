<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/base.jsp"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<title>用户登陆</title>

	
    <!-- bootstrap -->
    <link href="<%=basePath%>static/css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>static/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet">

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/compiled/icons.css">

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/lib/font-awesome.css">
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="<%=basePath%>static/css/compiled/signin.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

    <div class="login-wrapper">
        <a href="index.html">
            <img class="logo" src="<%=basePath%>static/img/logo-white.png">
        </a>

        <div class="box">
            <div class="content-wrap">
                <h6>登录</h6>
                <form action="<%=basePath%>/Login/lg" method="post">
	                <input class="form-control" type="text" name="userName"  placeholder="邮箱地址">
	                <input class="form-control" type="password" name="userPassword"  placeholder="密码">
	                <a href="#" class="forgot">忘记密码?</a>
	                <div class="remember">
	                    <input id="remember-me" type="checkbox" value="y" name="rememberPwd">
	                    <label for="remember-me">记住密码</label>
	                </div>
	                <div id="msg">
	                 ${error }
	                </div>
	                <button class="btn-glow primary login" type="submit">登录</button>
	               
	                <!-- <a class="btn-glow primary login" href="index.html"></a> -->
                </form>
            </div>
        </div>

        <div class="no-account">
            <p>还没账号?</p>
            <a href="<%=basePath%>/Login/ru">注册</a>
        </div>
    </div>

	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<%=basePath%>static/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>static/js/theme.js"></script>
	<script src="<%=basePath%>static/js/login/login.js"></script>
</body>
</html>
