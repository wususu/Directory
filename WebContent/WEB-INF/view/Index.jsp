<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="js/myjs.js" ></script>
<link rel="stylesheet" type="text/css" href="css/semantic/dist/semantic.min.css">

<script src="css/semantic/dist/semantic.min.js"></script>
<link  rel="stylesheet" type="text/css" href="css/mycss.css">
</head>
<body>


<div class="ui attached stackable menu">
  <div class="ui container">
    <a class="item list_contacter">
      <i class="home icon"></i> 联系人
    </a>
    <a class="item add_contacter">
      <i class="grid layout icon"></i> 添加联系人
    </a>
    <a class="item group-admin">
      <i class="mail icon"></i> 分组管理
    </a>
        <a class="item add_contacter">
      <i class="grid layout icon"></i> 添加分组
    </a>
    <div class="ui simple dropdown item">
      More
      <i class="dropdown icon"></i>
      <div class="menu">
        <a class="item"><i class="edit icon"></i> Edit Profile</a>
        <a class="item"><i class="globe icon"></i> Choose Language</a>
        <a class="item"><i class="settings icon"></i> Account Settings</a>
      </div>
    </div>

    
    <div class="right item ui fluid category search">
  <div class="ui icon input">
    <input class="ui input promp search-contacters-tabs" type="text" placeholder="Search contacters...">
    <i class="search icon"></i>
    
  </div>
</div>
  </div>
</div>
<div class="ui search focus search-contactaers">
	<div class="results transition hidden search-contacters" style="display: block !important;">
		<div class="category find-like-number">
			<div class="name ">号码</div>
			
			
		</div>

		<div class="category find-like-name">
			<div class="name">姓名</div>
			
			</div>
		</div>
</div>
<div class="ui vertical menu groupstab">
<div class="groups_cards">
  <a class="active teal item">
    所有联系人
    <div class="ui teal left pointing label" id="contacter_count">1</div>
  </a>
   <a class="item">
   未分组
   	<div class="ui label"  id="unknow_count">12</div>
  </a>
  </div>
  
  
  <div class="item">
    <div class="ui transparent icon input">
      <input type="text" placeholder="Search mail...">
      <i class="search icon"></i>
    </div>
  </div>
</div>


<c:import url="ContacterForm.jsp"></c:import>  


<c:import url="ContacterDetail.jsp"></c:import>


<c:import url="GroupAdmin.jsp"></c:import>


<c:import url="ContacterUpdateForm.jsp"></c:import>

<div class="ui raised very padded text container segment contactertab">
<div class="ui three column grid contacters_cards">  </div>
 <tfoot>
    <tr>
    <th colspan="3">
      <div class="ui right floated pagination menu"> </div>
    </th>
  </tr>
  </tfoot>
</div>


<c:import url="Fotter.jsp"></c:import>



</body>

</html>