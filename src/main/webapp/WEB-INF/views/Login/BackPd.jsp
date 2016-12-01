<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/base.jsp"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<title>注册用户</title>
	
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
    <link rel="stylesheet" href="<%=basePath%>static/css/compiled/signup.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
    <div class="header">
        <a href="index.html">
            <img src="<%=basePath%>static/img/logo.png" class="logo" />
        </a>
    </div>
    <div class="login-wrapper">
        <div class="box">
            <div class="content-wrap">
                <h6>找回密码</h6>
                <form action="<%=basePath%>/Login/ru" method="post">
                <input class="form-control" type="text" id="userGender" name="userGender"   placeholder="注册邮箱">
	                <input class="form-control" type="text" id="userName" name="userName" placeholder="用户名">
	                <input class="form-control" type="password" id="userPassword" name="userPassword"  placeholder="新密码">
	                <input class="form-control" type="text"	id="userAddress" name="userAddress" placeholder="住址">
	                <input class="form-control" type="text" id="userPhone" name="userPhone" placeholder="手机号码">
	                <button class="btn-glow primary login" type="submit">确认</button>
                </form>               
            </div>
        </div>

        <div class="already">
            <p>已有账号?</p>
            <a href="<%=basePath%>/Login/lg">登 陆</a>
        </div>
    </div>

	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<%=basePath%>static/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>static/js/theme.js"></script>
</body>
</html>