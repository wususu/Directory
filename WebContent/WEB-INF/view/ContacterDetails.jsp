<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="global">
		<h4>联系人</h4>
			<h5>Details:</h5>
			<img src="/Demo/image/${contacter.id}" width="150" height="150"/><br/>
			 Name: ${contacter.name }<br/>
			备注: ${contacter.remarks }<br/>
			家庭电话: ${contacter.homeTel }<br/>
			移动电话: ${ contacter.cellphone}<br/>
			wechat: ${ contacter.wechat }<br/>
			电子邮箱: ${contacter.mail } <br/>
			生日: ${contacter.birthDay } <br/>
			工作单位: ${contacter.work } <br/>
			家庭住址: ${contacter.address } <br/>
			邮政编码: ${contacter.zipCode }<br/>
	</div>
</body>
</html>