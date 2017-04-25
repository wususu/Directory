<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Save Product</title>
</head>
<body>
	<div id="global">
		<h4>The product has been saved</h4>
	
			<h5>Details:</h5>
			Product Name: ${product.name }<br/>
			Description: ${product.description }<br/>
			Price: $${product.price }
			<p>Following files are uploaded successfully.</p>
			<ol>
			<c:forEach items="${product.images }" var="image">
				<li>${image.originalFilename }
			<img width="100" src="<c:url value="/image/"/>${image.originalFilename}"/>
			</li>
			</c:forEach>
			</ol>
	</div>
</body>
</html>