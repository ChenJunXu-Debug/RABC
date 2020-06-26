<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <%Map<String, List> map = (Map)request.getAttribute("map");%>
<%int in = map.get("in").size();%>
<%int o = map.get("out").size();%>
<%int none = map.get("none").size();%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="50%">
			<c:forEach items="${map.in}" var="goods" varStatus="status">
				<c:if test="${status.index == 0}">
					<tr>
						<td rowspan="${fn:length(map.in)}">内部</td>
						<td>${goods.name}</td>
						<td>${goods.price}</td>
						<td>${goods.desc}</td>	
					</tr>
				</c:if>
				<c:if test="${status.index > 0}">
					<tr>
						<td>${goods.name}</td>
						<td>${goods.price}</td>
						<td>${goods.desc}</td>	
					</tr>
				</c:if>
			</c:forEach>
			<c:forEach items="${map.out}" var="goods" varStatus="status">
				<c:if test="${status.index == 0}">
					<tr>
						<td rowspan="${fn:length(map.out)}">外部</td>
						<td>${goods.name}</td>
						<td>${goods.price}</td>
						<td>${goods.desc}</td>	
					</tr>
				</c:if>
				<c:if test="${status.index > 0}">
					<tr>
						<td>${goods.name}</td>
						<td>${goods.price}</td>
						<td>${goods.desc}</td>	
					</tr>
				</c:if>
			</c:forEach>
			
	</table>
	<table align="center" width="50%">
		<c:forEach items="${map.none}" var="goods" varStatus="status">
					<tr>
						<td>${goods.name}</td>
						<td>${goods.price}</td>
						<td>${goods.desc}</td>	
					</tr>
			</c:forEach>
	</table>
	<script type="text/javascript">
	</script>
</body>
</html>