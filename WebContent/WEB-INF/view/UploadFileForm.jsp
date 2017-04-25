<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> upload</title>
</head>
<body>
	<form:form commandName="product" action="upload_file_save" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>Add a product</legend>
			<p>
				<label for="name">Product Name:</label>
				<form:input path="name" id="name" />
				<form:errors path="name" />
			</p>
			<p>
				<label for="description">Description:</label>
				<form:input path="description" id="description" />
			</p>
			<p>
				<label for="price">Price:</label>
				<form:input path="price" id="price" />
			</p>
			<p>
				<label for="image">Product Image:</label>
				<input type="file" name="images[0]"/>
			</p>
			<p>
				<input id="reset" type="reset" tabindex="4"/>
				<input id="submit" type="submit" tabindex="5" value="Add Product"/>
			</p>
		</fieldset>
	</form:form>
</body>
</html>