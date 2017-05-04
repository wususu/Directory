<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


   
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

.contactertab{

position: absolute;
    margin: auto;
    top: 0; left: 0; right: 0; bottom: 0;
    overflow: auto;
}
.ui.vertical.menu{
float:right!important;
}
</style>
</head>
<body>

<div class="ui attached stackable menu">
  <div class="ui container">
    <a class="item">
      <i class="home icon"></i> Home
    </a>
    <a class="item">
      <i class="grid layout icon"></i> Browse
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
    Inbox
    <div class="ui teal left pointing label">1</div>
  </a>


  </div>
  <div class="item">
    <div class="ui transparent icon input">
      <input type="text" placeholder="Search mail...">
      <i class="search icon"></i>
    </div>
  </div>
</div>


<div class="ui raised very padded text container segment contactertab">
<div class="ui three column grid contacters_cards">
    </div>

 <tfoot>
    <tr><th colspan="3">
      <div class="ui right floated pagination menu">
        <a class="icon item">
          <i class="left chevron icon"></i>
        </a>
        <a class="item">1</a>
        <a class="item">2</a>
        <a class="item">3</a>
        <a class="item">4</a>
        <a class="icon item">
          <i class="right chevron icon"></i>
        </a>
      </div>
    </th>
  </tr></tfoot>
</div>

</body>

</html>