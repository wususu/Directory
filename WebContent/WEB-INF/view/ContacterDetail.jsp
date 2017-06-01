<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="ui raised very padded text container segment contacter_detail_container">


	<div class="no example">
  <table class="ui large very padded definition table">
    <tbody >
      <h2 class="ui dividing header">Contacter Information</h4>
    <button class="ui right  button yellow floated  edit-button">Edit</button>
        <button class="ui right  button red floated  contacter-delete-button">Delete</button>
    
    <div class="contacter_detail detail-font-size"></div>
  	<h2 class="ui dividing header"> Groups</h4>
	   <div class="contacter_detail_groups detail-font-size">
	   
	   </div>
	
  </tbody>
        <h2 class="ui dividing header"> Add to Groups</h4>
   <div class="list ui group-checkbox">
      <div class="item">
        <div class="ui child checkbox">
          <input type="checkbox" name="apple">
          <label>Apple</label>
        </div>
      </div>
      <div class="item">
        <div class="ui child checkbox">
          <input type="checkbox" name="orange">
          <label>Orange</label>
        </div>
      </div>
      <div class="item">
        <div class="ui child checkbox">
          <input type="checkbox" name="pear">
          <label>Pear</label>
        </div>
      </div>
</div>
   <p><button class="ui blue button add-group-button" id="" >Add Groups</button></p>
  </table>
 

</div>
</div>