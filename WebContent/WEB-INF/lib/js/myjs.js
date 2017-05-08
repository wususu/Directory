$(document).ready(function () {
	$(".contacter_form_container").hide();
	$(".contacter_detail_container").hide();
	click_action();
	
	var page = 1;

	$(".submit_add_contacter").click(function() {
		submit_contacter_form();
		return false;
	});
	
	$(".contacter").click(function() {
		
	})
	
	// Get Contacter Count
	$.ajax({
		type: 'GET',
		url: "contacter/count",
		success: function(data) {
			var html = pagination_dom(page, data.page);
			$("#contacter_count").html(data.count);
			$(".pagination").append(html);
			}
	});
	
	//Get  Contacter By Page
	$.ajax({
		type: "GET",
		url: "contacter/page/"+ page,
		success: function (data) {
			var contacters = data.contacter_list;
			$.each(contacters, function (key, value) {
					var id = value.id;
					var name = value.name;
					var cellphone = value.cellphone;
					var html = contacters_dom(id, name, cellphone);
					$(".contacters_cards").append(html);
			});
		}
	});
	
	//Get a Contacter By Id
	function get_contacter_by_id(id) {
		var url = "contacter/get/"+id;
		$.ajax({
			url: url,
			type: 'get',
			dataType: 'json',
			success: function(data) {
				console.log(data);
			}
		});
	}
	
	// Get All Groups
	$.ajax({
		type: 'GET',
		url: "groups/all",
		success: function (data) {
			var groups_list = data.groups_list;
			$.each(groups_list, function (key, value) {
				var id = value.id;
				var name = value.name;
				var count = value.count;
				var html = groups_dom(id, name, count);
				$(".groups_cards").append(html);
			})
		}
	});
	
	//Add Contacter 表单提交
	function submit_contacter_form(){
		var form = new FormData($(".contacter_form")[0]);
		for (var key of form.keys()) {
			   console.log(key); 
		}
		console.log(form);
		$.ajax({
			url:"contacter/save",
			type: "post",
			data: form,
			processData: false,
			contentType: false,
			success: function(data) {
				console.log(data);
			}
		});
		return false;
	}
	
	function click_action(){
		menu_click();
	}
	
	function menu_click(){
		$(".add_contacter").click(function() {
			$(".contactertab").hide();
			$(".contacter_detail_container").hide();
			$(".contacter_form_container").fadeIn("slow");
		});
		$(".list_contacter").click(function() {
			$(".contacter_detail_container").hide();
			$(".contacter_form_container").hide();
			$(".contactertab").fadeIn("slow");
		});
		$(document).on("click",".contacter_column",  function() {
			var id = $(this).attr("id");
			$(".contactertab").hide();
			$(".contacter_form_container").hide();
			$(".contacter_detail_container").fadeIn("slow");
			contacter_detail_page_action(id);
		});
	}
	
	function pagination_dom(current_page, page_num) {
		var html = '';
		if (current_page != 1) {
	       html += '<a class="icon item">'+
	          '<i class="left chevron icon"></i>'+
	        '</a>';
		}
		for (var i = 1; i <= page_num; i++) {
			html += '<a class="item page-select" id="'+i+'">'+i+'</a>';
		}
		if (current_page != page_num) {
			html += ' <a class="icon item">'+
          '<i class="right chevron icon"></i>'+
        '</a>';
		}
		return html;
	}
	
	function groups_dom(id, name, count) {
		var html = '  <a class="item" id="'+id+'">'+
		    name + 
		    '<div class="ui label">'+ count +'</div>'+
		  '</a>';
		  return html;
	}
	
	function contacters_dom(id, name, cellphone) {
		var html = ' <div class="contacter_column column" id="' + id +'">'+
		    '<div class="ui fluid card">'+
	      '<div class="image">'+
	        '<img src="image/' + id +'">'+
	      '</div>'+
	      '<div class="content">'+
	       ' <a class="header contacter_name">'+name+'</a>'+
	        '<p>'+cellphone+'</p>'+
	      '</div>'+
	    '</div>'+
	  '</div>';
	  return html;
	}
	
	function contacter_detail_dom(contacter) {
		var html = '<tr>'+
	     '<td><img class="ui medium circular image contacter_image" src="image/'+contacter.id+'"></td>'+
	    '</tr>'+
	    '<tr>'+
	      '<td >'+  "NAME"+'</td>'+
	     '<td>'+contacter.name+'</td>'+
	    '</tr>'+
	    '<tr>'+
	      '<td >'+ "REMARKS" +'</td>'+
	     '<td>'+contacter.remarks+'</td>'+
	    '</tr>'+
	    '<tr>'+
	      '<td >'+" WECHAT" +'</td>'+
	     '<td>'+contacter.wechat	+'</td>'+
	    '</tr>'+
	    '<tr>'+
	      '<td >'+ "CELLPHONE "+'</td>'+
	     '<td>'+contacter.cellpone+'</td>'+
	    '</tr>'+
	    '<tr>'+
	      '<td >'+" HOME-TEL" +'</td>'+
	     '<td>'+contacter.homeTel+'</td>'+
	    '</tr>'+
	    '<tr>'+
	      '<td >'+ "BIRTHDAY" +'</td>'+
	     '<td>'+contacter.birthday+'</td>'+
	    '</tr>'+
	    '<tr>'+
	      '<td >'+ "WORK" +'</td>'+
	     '<td>'+contacter.work+'</td>'+
	    '</tr>'+
	    '<tr>'+
	      '<td >'+ "ADDRESS" +'</td>'+
	     '<td>'+contacter.address+'</td>'+
	    '</tr>'+
	    '<tr>'+
	      '<td >'+ "ZIP-CODE" +'</td>'+
	     '<td>'+contacter.zip_code+'</td>'+
	    '</tr>';
	     return html;
	}
	
	function contacter_groups_dom(groups) {
		var html = '';
		$.each(groups, function(offset, group) {
			console.log(group);
			 html += '<div class="contacter-groups" id="'+group.id+'">'+
		     '<div class="groups-style">'+group.name+ 
		     '<button class="ui red button">remove</button>'+
		     '</div>'+
		    '</div>';
		});
		return html  + '<p><button class="ui blue button">Add Groups</button></p>';
	}
	
	function contacter_list_action() {
		$(document).on("click", ".page-select", function() {
			
		});
	}
	
	function contacter_detail_page_action(id) {
		$(".contacter_detail").html('');
		$(".contacter_detail_groups").html('');
		$.ajax({
			url: "contacter/get/"+id,
			type: "get",
			dataType: "json",
			success: function(data) {
				var html = contacter_detail_dom(data.contacter);
				$(".contacter_detail").append(html);
				var groups_html = contacter_groups_dom(data.contacter.groups);
				$(".contacter_detail_groups").append(groups_html);
			}
		});
	}
});