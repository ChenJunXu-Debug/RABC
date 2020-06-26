<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--菜单权限--%>
<c:if test="${fn:length(trees) > 0}">
	<ul>
	<c:forEach items="${trees}" var="root">
		<%--一级目录--%>
		<li>${root.name}
			<c:if test="${root.childs != null && fn:length(root.childs) > 0}">
				<ul>
				<c:forEach items="${root.childs}" var="child">
					<%--二级目录--%>
					<li>${child.name}
						<c:if test="${child.childs != null && fn:length(child.childs) > 0}">
							<ul>
								<c:forEach items="${child.childs}" var="son">
									<%--3级菜单--%>
									<li>${son.name}</li>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</c:forEach>
				</ul>
			</c:if>
		</li>
	</c:forEach>
	</ul>
</c:if>
<c:if test="${fn:length(trees) == 0}">
<h1>暂无任何菜单权限</h1>
</c:if>
<%--按钮权限--%>
<c:forEach items="${permissions}" var="permission">
	${permission == 'PAGE1_BUTTON_SELECT' ? '<input type="button" value="page1查询">' : ''}
	${permission == 'PAGE1_BUTTON_INSERT' ? '<input type="button" value="page1增加">' : ''}
	${permission == 'PAGE1_BUTTON_DELETE' ? '<input type="button" value="page1删除">' : ''}
	${permission == 'PAGE1_BUTTON_UPDATE' ? '<input type="button" value="page1修改">' : ''}
	${permission == 'PAGE2_BUTTON_SELECT' ? '<input type="button" value="page2查询">' : ''}
	${permission == 'PAGE2_BUTTON_INSERT' ? '<input type="button" value="page2增加">' : ''}
	${permission == 'PAGE2_BUTTON_DELETE' ? '<input type="button" value="page2删除">' : ''}
	${permission == 'PAGE2_BUTTON_UPDATE' ? '<input type="button" value="page2修改">' : ''}
</c:forEach>
	<script type="text/javascript">
	</script>
</body>
</html>