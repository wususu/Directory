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
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<script src="css/semantic/dist/semantic.min.js"></script>
<style type="text/css">
.contacter_detail_container .contacter_form_container{
	display:none;
}

.ui.vertical.menu .item:before{
	width: 0;
	hight:0;
}
.contactertab{

position: absolute;
    margin: auto;
    top: 0; left: 0; right: 0; bottom: 0;
    overflow: auto;
}
.ui.vertical.menu{
float:right!important;
}
.page-footer-inner{
	text-align: center;
	margin-left: 1rem;
	    height: 150px;
}
.detail-font-size{
	font-size: x-large;
}
.ui.vertical.menu{
	position: fixed;
}
.ui.red.button{
	float: right;
}
</style>
</head>
<body>


<div class="ui attached stackable menu">
  <div class="ui container">
    <a class="item list_contacter">
      <i class="home icon"></i> Home
    </a>
    <a class="item add_contacter">
      <i class="grid layout icon"></i> 添加联系人
    </a>
    <a class="item">
      <i class="mail icon"></i> Messages
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
    <div class="right item">
      <div class="ui input"><input type="text" placeholder="Search..."></div>
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


<footer class="page-footer " style="">
  <div class="page-footer-inner" style="">
    <br>
    <p><a href="/">Contacter List by design</a> is written by <br class="mobile"><a href="/about/vvv">Janke Wu</a> <br class="mobile">and powered by <a href="http://workflower.fi">spring</a>.<br class="mobile"><a href="/posts">Articles</a> / <a href="/projects">Projects</a> / <a href="/feed"><abbr>rss</abbr> feed</a></p>
  </div>
</footer>


</body>

</html>