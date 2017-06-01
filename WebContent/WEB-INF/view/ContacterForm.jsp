<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<div class="ui raised very padded text container segment contacter_form_container">
<form:form  class="ui contacter_form " commandName="contacterAndImage"  method="post" enctype="multipart/form-data">

  <h4 class="ui dividing header">Contacter Information</h4>
  
  <div class="field">
 		 <label for="image">头像:</label>
 		 <div class="seven wide field">
		<form:input type="file"  name="image" path="image.picture"/>
		</div>
  </div>



  <h4 class="ui dividing header">Billing Information</h4>
  
  
    
  <div class="field">
    <label>Name</label>
      <div class="seven wide field">
      	<form:input name="name" path="contacter.name" placeholder="Name" />
      </div>
  </div>
  
    <div class="field">
    <label>Remarks</label>
      <div class="seven wide field">
      	<form:input name="Remarks" path="contacter.remarks" placeholder="Remarks" />
      </div>
  </div>
  

  
      <div class="field">
    <label>WeChat Number</label>
      <div class="seven wide field">
      	<form:input name="wechat" path="contacter.wechat" placeholder="WeChat" />
      </div>
  </div>
  
    <div class="seven wide field">
      <label>Home Tel</label>
      <form:input type="text" name="homeTel" path="contacter.homeTel" maxlength="16" placeholder="home tel"/>
    </div>
  
  <div class="seven wide field">
      <label>Phone Number</label>
      <form:input type="number" name="cellphone" path="contacter.cellphone" placeholder="cellphone #"/>
    </div>

  <div class="seven wide field">
      <label>E-mail</label>
      <form:input type="text" name="mail" path="contacter.mail" maxlength="16" placeholder="mail #"/>
    </div>
    
      <div class="seven wide field">
      <label>Birthday</label>
      <form:input type="date" name="birthday" path="contacter.birthDay" maxlength="16" />
    </div>
    
      <div class="field">
    <label>Address</label>
      <div class="seven wide field">
        <form:input  name="address" path="contacter.address" placeholder="Address"/>
      </div>
  	</div>
  	
  	  <div class="seven wide field">
      <label>Work</label>
      <form:input type="text" name="work" path="contacter.work" maxlength="16" />
    </div>
    
    <div class="seven wide field">
      <label>Zip Code</label>
      <form:input type="number" name="zipCode" path="contacter.zipCode" placeholder="Zip Code #"/>
    </div>
    
  <h4 class="ui dividing header">Billing Information</h4>

  <input type="submit" class="ui button submit_add_contacter" tabindex="0">Submit Order</div>
</form:form>
</div>
