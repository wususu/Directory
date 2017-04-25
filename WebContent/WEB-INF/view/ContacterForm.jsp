<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form commandName="contacterAndImage" action="${pageContext.request.contextPath}/addContacter" method="post" enctype="multipart/form-data">
<fieldset>
			<legend>添加联系人</legend>
	<p>
	<label for="image">头像:</label>
	<form:input type="file"  name="image" path="image.picture"/>
	</p>
	
	<p>
	<label for="name">姓名:</label>
	<form:input name="name" path="contacter.name" />
	</p>
	<p>
	<label for="remarks">备注:</label>
	<form:input name="remarks" path="contacter.remarks" />
	</p>
	<p>	
	<label for="homeTel">家庭电话:</label>
	<form:input name="homeTel" path="contacter.homeTel"/>
	</p>
	<p>
	<label for="cellphone">移动电话:</label>
	<form:input name="cellphone" path="contacter.cellphone"/>
	</p>
	<p>
	<label for="wechat">微信号:</label>
	<form:input name="wechat" path="contacter.wechat"/>
	</p>
	<p>
	<label for="mail">电子邮箱:</label>
	<form:input name="mail" path="contacter.mail"/>
	</p>
	<p>
	<label for="birthDay">出生日期:</label>
	<form:input name="birthDay" path="contacter.birthDay" type="date"/>
	</p>
	<p>
	<label for="work">工作单位:</label>
	<input name="contacterwithimage.contacter.work"/>
	</p>
	<p>
	<label for="address">地址:</label>
	<input name="contacterwithimage.contacter.address"/>
	</p>
	<p>
	<label for="zipCode">邮编:</label>
	<input name="contacterwithimage.contacter.zipCode"/>
	</p>
	<input id="submit" type="submit" value="添加"/>
</fieldset>

</form:form>
</body>
</html>