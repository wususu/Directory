<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<div style="display:none;" class="ui raised very padded text container segment contacter-update-form-container">
  <h4 class="ui dividing header">image Information</h4>

<form method="post" class="edit-image-form" enctype="multipart/form-data">
    头像：<input type="file" class="button ui " name="img" />修改头像<br/>
    <input type="image" class= "edit-image ui medium circular image" />
      <input type="button" class="button ui change-image-button" value="保存头像修改">
  
     </form>


<form  class="ui update_contacter_form "  method="post" enctype="multipart"/form-data>

  <h4 class="ui dividing header">Contacter Information</h4>

    
  <div class="field">
    <label>Name</label>
      <div class="seven wide field">
      	<input name="name" id="name" placeholder="Name" />
      </div>
  </div>
  
    <div class="field">
    <label>Remarks</label>
      <div class="seven wide field">
      	<input name="Remarks" id="remarks" placeholder="Remarks" />
      </div>
  </div>
  

  
      <div class="field">
    <label>WeChat Number</label>
      <div class="seven wide field">
      	<input name="weChat" id="wechat" placeholder="WeChat" />
      </div>
  </div>
  
    <div class="seven wide field">
      <label>Home Tel</label>
      <input type="text" name="homeTel" id="homeTel" maxlength="16" placeholder="home tel"/>
    </div>
  
  <div class="seven wide field">
      <label>Phone Number</label>
      <input type="number" name="cellphone" id="cellphone" maxlength="32" placeholder="cellphone #"/>
    </div>

  <div class="seven wide field">
      <label>E-mail</label>
      <input type="text" name="mail" id="mail" maxlength="16" placeholder="mail #"/>
    </div>
    
      <div class="seven wide field">
      <label>Birthday</label>
      <input type="date" name="birthday" id="birthday"  maxlength="16" />
    </div>
    
      <div class="field">
    <label>Address</label>
      <div class="seven wide field">
        <input  name="address" id="address" placeholder="Address"/>
      </div>
  	</div>
  	
  	  <div class="seven wide field">
      <label>Work</label>
      <input type="text" name="work" id="work" value="" maxlength="16" />
    </div>

  <input type="submit" value="保存修改信息" class="submit_update_contacter ui button s" tabindex="0">Submit</div>
</form>
</div>
