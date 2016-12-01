<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %> 
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %> 
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="basePath" value="<%=basePath%>"></c:set>
<c:set var="path" value="<%=path%>"></c:set>
<script>
	var path="<%=path%>";
	var basePath="<%=basePath%>";
</script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.7.js"></script>