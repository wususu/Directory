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
<form:form commandName="contacter" action="${pageContext.request.contextPath}/updateContacter" method="post" >
<fieldset>
			<legend>添加联系人</legend>
	<p>
	<form:input name="pic" type="hidden"  path="pic"/>
	<form:input name="id" type="hidden" path="id"/>
	<label for="name">姓名:</label>
	<form:input name="name" path="name" />
	</p>
	<p>
	<label for="remarks">备注:</label>
	<form:input name="remarks" path="remarks" />
	</p>
	<p>	
	<label for="homeTel">家庭电话:</label>
	<form:input name="homeTel" path="homeTel"/>
	</p>
	<p>
	<label for="cellphone">移动电话:</label>
	<form:input name="cellphone" path="cellphone"/>
	</p>
	<p>
	<label for="wechat">微信号:</label>
	<form:input name="wechat" path="wechat"/>
	</p>
	<p>
	<label for="mail">电子邮箱:</label>
	<form:input name="mail" path="mail"/>
	</p>
	<p>
	<label for="birthDay">出生日期:</label>
	<form:input name="birthDay" path="birthDay" type="date"/>
	</p>
	<p>
	<label for="work">工作单位:</label>
	<form:input name="work" path="work"/>
	</p>
	<p>
	<label for="address">地址:</label>
	<form:input name="address" path="address"/>
	</p>
	<p>
	<label for="zipCode">邮编:</label>
	<form:input name="zipCode" path="zipCode"/>
	</p>
	<input id="submit" type="submit" value="添加"/>
</fieldset>

</form:form>
</body>
</html>