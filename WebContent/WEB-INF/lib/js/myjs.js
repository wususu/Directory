$(document).ready(function () {
	get_all_groups();

	var page=1;
	var total_count=0;

	$(".contacter_form_container").hide();
	$(".contacter_detail_container").hide();
	show_contactertab(page);


	click_action();
	get_contacter_count();

	
	function reflash() {
		get_all_groups();
		get_contacter_count();
		show_contactertab(page);
		
	}
	
	$(".submit_add_contacter").click(function() {
		submit_contacter_form();
		return false;
	});
	
	$(".contacter").click(function() {
		
	})
	
	// Get Contacter Count
	function get_contacter_count() {
		$.ajax({
			type: 'GET',
			url: "contacter/count",
			success: function(data) {
				var html = pagination_dom(page, data.page);
				$(".pagination").empty();
				$("#contacter_count").empty();
				$("div.pointing#contacter_count").html(data.count);
				$(".pagination").append(html);
				}
		});
	}

	
	//Get  Contacter By Page
	function show_contactertab(page='', group='') {
		var url = '';
		if(page!=''){
			url  = "contacter/page/";
		}
		if(group!=''){
			url = "contacter/get/group/";
		}
		$(".contacters_cards").empty();
		$.ajax({
			type: "GET",
			url: url +group+ page,
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
		return false;
	}
	
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
	
	
	// 群组管理页面事件

	function add_group_click() {
		$(document).on('click', '.new-group-button', function() {
			var new_group_name = $('.new-group-input').val().trim();
			if(new_group_name != ''){
				var group = {'name': new_group_name};
				$.ajax({
					url: 'groups/new',
					type: 'post',
					data: group,
					dataType: 'json',
					success: function(data) {
						if(data.result == 'success'){
							get_all_groups();

							alert("分组添加成功");
						}else {
							alert("分组已存在");
						}
					}
				})
			}
		});
	}
	
	function delete_group_click() {
		$(document).on('click', '.delete-group-button', function() {
			var id = $(this).attr('id');
			$.ajax({
				url: "groups/delete",
				data: {
					'id': id,
				},
				type: "post",
				dataType: "json",
				success: function(data) {
					if(data.result == 'success'){
						reflash();

						alert("删除成功");
					}else{
						alert("删除失败");
					}
				}
			});
		});
	}
	
	// 	// 群组管理页面事件-end
	
	// Get All Groups
	function get_all_groups() {
		$.ajax({
			type: 'GET',
			url: "groups/all",
			success: function (data) {
				var groups_list = data.groups_list;
				$("div.group_admin_containter > .groups").empty();
				$(".groups_cards").empty();
				group_checkbox_dom(groups_list);
				$(".groups_cards").append('  <a class="active teal get_groups item">所有联系人<div class="ui teal left pointing label" id="contacter_count"></div></a>');
				$.each(groups_list, function (key, value) {
					var id = value.id;
					var name = value.name;
					var count = value.count;
					var html = groups_dom(id, name, count);
					$(".groups_cards").append(html);
					var html_1 = groups_admin_dom(id, name, count) ;
					$("div.group_admin_containter > .groups").append(html_1);
				});
				$("div.group_admin_containter > .groups").append('<div class="ui left icon input">'+
					      '<input type="text" class="new-group-input" placeholder="New Group...">'+
					      '<i class="users icon"></i></div>'+
					    '<div class="right floated"><button class="ui blue button new-group-button">Add Group</button></div>');
			}
		});
	}

	// 分组多选框生成
	function group_checkbox_dom(groups_list) {
		$(".group-checkbox").empty();
		html = '';
		$.each(groups_list, function(key, value) {
			var id = value.id;
			var name = value.name;
			var count = value.count;
			html += ' <div class="item checkbox-item" id="'+id+'">'+
        '<div class="ui child checkbox">'+
          '<input type="checkbox" name="'+name+'" class="checkbox-input"  id="'+id+'">'+
          '<label>'+name+'</label>'+
        '</div>'+
      '</div>';
		});
		$(".group-checkbox").append(html);
	}
	
	//Add Contacter 表单提交
	function submit_contacter_form(){
		var form = new FormData($(".contacter_form")[0]);
		console.log("key");
		for (var key of form.keys()) {
			   console.log(key); 
		}
		for (var value of form.values()) {
			   console.log(value); 
		}
		console.log(form);
		$.ajax({
			url:"contacter/save",
			type: "post",
			data: form,
			processData: false,
			contentType: false,
			success: function(data) {
				if (data.result = "success"){
					alert("录入成功");
//					location.reload("http://localhost/Demo");   
				}
			}
		});
		return false;
	}
	
	// 联系人信息修改点击事件
	function contacter_update_click() {
		$("input.submit_update_contacter").click(function() {
			var id = $(this).attr("id");
			update_contacter_info(id);
			return false;
		});
	}
	
	// 删除联系人点击事件
	function contacter_delete_click() {
		$("button.contacter-delete-button").click(function() {
			var contacter_id = $(this).attr("id");
			$.ajax({
				url: "contacter/delete",
				type: 'post',
				dataType: "json",
				data: {id: contacter_id},
				success: function(data) {
					if(data.result = "success"){
						alert("删除成功");
//						location.reload("http://localhost/Demo");   
					}
				}
			})
		});
	}
	
	// 修改联系人请求
	function update_contacter_info(id) {
		var form = new FormData($(".update_contacter_form")[0]);
		console.log(form);
		for (var key of form.keys()) {
			   console.log(key); 
		}
		for (var value of form.values()) {
			   console.log(value); 
		}
		form.append("id", id);
		$.ajax({
			url:"contacter/update",
			type: "post",
			data: form,
			processData: false,
			contentType: false,
			success: function(data) {
					if (data.result == "success") {
						alert("修改成功");
//						location.reload("http://localhost/Demo");   
					}
			},
		});
	}
	
	// 修改头像点击事件
	function change_image_click() {
		$(".change-image-button").click(function() {
			change_contacter_image($(this).attr("id"));
			return false;
		});
	}
	
	// 修改头像请求提交
	function change_contacter_image(id){
		var form = new FormData($(".edit-image-form")[0]);
		form.append("id", id);
		$.ajax({
			url:"/Demo/contacter/image/update",
			type: "post",
			data: form,
			processData: false,
			contentType: false,
			success: function(data) {
				if (data.result == "success") {
					console.log("in");
					$("input.edit-image").attr("src", "image/"+id + "?"+ (new Date().getTime()));
					alert("头像修改成功");
				}
			},
		});
	}
	
	//  联系人增加分组
	function contacter_add_group_click() {
		$(document).on("click", "button.add-group-button", function() {
			var list = $("input.checkbox-input.checked");
			var group_selected = new Array();
			$.each(list, function(key, value) {
				group_selected.push($(value).attr('id'));
			});
			var contacter_id = $(".edit-button").attr("id");
			contacter_add_groups_request(group_selected, contacter_id);
			
		});
	}
	
	// 联系人添加分组请求
	function contacter_add_groups_request(group_selected_list, contacter_id) {
		$.ajax({
			url: 'contacter/addGroups',
			type: 'post',
			dataType: 'json',
			data: {
				"contacter_id": contacter_id ,
				"group_list": group_selected_list
			},
			success: function(data) {
				if (data.result == "success") {
					show_contacter_detail(contacter_id);
					reflash();
					alert("分组添加成功");
				}
			}
		});
	}
	
	// 移除分组点击
	function remove_group_click() {
		$(document).on("click", ".remove-group-button", function() {
			var contacter_id = $(".edit-button").attr("id");
			var group_id = $(this).attr("id");
			contacter_remove_group_request(contacter_id, group_id);
		});
	}
	
	// 移除分组请求
	function contacter_remove_group_request(contacter_id, group_id) {
		$.ajax({
			url: "contacter/removeGroups",
			data: {
				"contacter_id": contacter_id,
				"group_id": group_id
			},
			type: 'post',
			dataType: 'json',
			success: function(data) {
				if (data.result == "success") {
					show_contacter_detail(contacter_id);
					reflash();

					alert("移出分组成功");
				}				
			}
		});
	}
	
	// 点击事件
	function click_action(){
		click_init();
		menu_click();
		page_click();
		 search_click();
		 search_result_click();
		 add_group_click();
		 delete_group_click();
		 change_image_click();
		 contacter_update_click();
		 contacter_add_group_click();
		 group_checkbox_click();
		 remove_group_click();
		 groups_click();
		 contacter_delete_click();
	}
	
	
	function click_init() {
		$(document).click(function() {
			$('div.search-contacters').removeClass('visible');
			$('div.search-contacters').addClass('hidden');
		});
	}
	
	// 页码点击事件
	function page_click() {
		$(document).on("click", ".page-select", function() {
			$('.contactertab').hide();
			var page_id = $(this).attr("id");
			show_contactertab(page_id);
			$('.contactertab').fadeIn('slow');
		});
	}
	
	// 搜索框点击事件
	function search_result_click() {
		$(document).on('click', '.search-cntacter-result', function() {
			var id = $(this).attr('id');
			show_contacter_detail(id);
		});
	}
	
	
	// /搜索框
	function search_click() {

		$('.search-contacters-tabs').keyup(function() {
			var html_1='<div class="name ">号码</div>';	
			var html_2='<div class="name">姓名</div>';	
			$('div.find-like-name').empty();
			$('div.find-like-number').empty();
			var value = $(this).val().trim();
			if (value == '' || value==null){
				$('.search-contacters').addClass('hidden');
				$('.search-contacters').removeClass('visible');

			}else{
				if(/\d+/.test(value)){
				$.ajax({
					url: "contacter/find/"+value,
					type: 'get',
					dataType: 'json',
					success:function(data){
						console.log(data);
						console.log(data.contacter_list);
						$.each(data.contacter_list, function(key, value) {
							html_1 += search_contacters_dom(value);
						});
						$('.find-like-number').append(html_1);
					}
				});
				}else{
				$.ajax({
					url: "contacter/name/"+value,
					type: 'get',
					dataType: 'json',
					success:function(data){
						console.log(data.contacter_list);
						$.each(data.contacter_list, function(key, value) {
							html_2 += search_contacters_dom(value);
						});
						$('.find-like-name').html(html_2);
					}
				});
				}
				
				$('.search-contacters').removeClass('hidden');
				$('.search-contacters').addClass('visible');
			}
		});
	}
	
	
	// 分组点击事件
	function groups_click() {
		$(document).on("click", ".get_groups", function() {
			$(".get_groups.active").removeClass("active");
			$(this).addClass("active");
			$('.contactertab').hide();
			var group_id = $(this).attr("id");
			console.log(group_id);
			if (typeof(group_id) === "undefined") {
				show_contactertab(1);
			}else{
				show_contactertab('',group_id);
			}
			$('.contactertab').fadeIn('slow');
		});
	}
	
	// 分组选择
	function group_checkbox_click() {
		$(document).on("click", "input.checkbox-input", function() {
			if($(this).is(".checked")){
				$(this).removeClass("checked");
			}else {
				$(this).addClass("checked");
			}
		});
	}
	
	// 菜单栏点击事件
	function menu_click(){
		$(".add_contacter").click(function() {
			$(".contactertab").hide();
			$(".contacter_detail_container").hide();
			$('.group_admin_containter').hide();
			$(".contacter-update-form-container").hide();
			$(".contacter_form_container").fadeIn("slow");
		});
		$(".list_contacter").click(function() {
			reflash();
			$(".contacter_detail_container").hide();
			$(".contacter_form_container").hide();
			$('.group_admin_containter').hide();
			$(".contacter-update-form-container").hide();
			$(".contactertab").fadeIn("slow");
		});
		$(".group-admin").click(function() {
			$(".contacter_detail_container").hide();
			$(".contacter_form_container").hide();
			$(".contactertab").hide();
			$(".contacter-update-form-container").hide();
			$('.group_admin_containter').fadeIn("slow");
		});
		$("button.edit-button").click(function() {
			var id = $(this).attr("id");
			get_contacter_value(id);
			$(".contacter_detail_container").hide();
			$(".contacter_form_container").hide();
			$(".contactertab").hide();
			$('.group_admin_containter').hide();
			$(".contacter-update-form-container").fadeIn("slow");
		});
		$(document).on("click",".contacter_column",  function() {
			var id = $(this).attr("id");
			show_contacter_detail(id);
		});
	}
	
	// 获取数据填充联系人修改表单
	function get_contacter_value(id) {
		$.ajax({
			url:'contacter/get/'+id,
			type: 'get',
			dataType: 'json',
			success: function(data) {
				$.each(data.contacter, function(key, value) {
					$("#"+key).attr("value", value);
				});
				$(".edit-image").attr("src", "image/"+id);
				$(".change-image-button").attr("id", id);
				$(".submit_add_contacter").attr("id", id);
				$(".add-group-button").attr("id", id);
			}
		});
	}
	
	function show_contacter_detail(id) {
		$("button.edit-button").attr("id", id);
		$("button.contacter-delete-button").attr("id", id);
		$("input.submit_update_contacter").attr("id", id);
		$(".contactertab").hide();
		$(".contacter_form_container").hide();
		$(".contacter_detail_container").fadeIn("slow");
		contacter_detail_page_action(id);
	}
	
	function groups_admin_dom(id, name, count) {
		var html = '<div class="item group" id="'+id+'">'+
    '<div class="right floated content">'+
      '<div class="ui button red delete-group-button" id="'+id+'">Delete</div>'+
    '</div>'+
    '<div class="content group-name">'+
      name + 
    '</div>'+
  '</div>';
		return html;
	}
	
	function search_contacters_dom(contacter) {
		html = '<a class="search-cntacter-result result" id='+contacter.id+'>'+
				'<div class="search-cntacter content" id='+contacter.id+'>'+
				'<div class="title contater-name">'+contacter.name +'</div>'+
				'<div class="description"><p>cellphone:</p> '+contacter.cellphone+'</div>'+
				'<div class="description"><p>homeTel:</p> '+contacter.homeTel+'</div>'+
				'</div>'+
			'</a>';
		return html;
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
	
	// 分组列表dom
	function groups_dom(id, name, count) {
		var html = '  <a class="item get_groups" id="'+id+'">'+
		    name + 
		    '<div class="ui label">'+ count +'</div>'+
		  '</a>';
		  return html;
	}
	
	function contacters_dom(id, name, cellphone) {
		var html = ' <div class="contacter_column column" id="' + id +'">'+
		    '<div class="ui fluid card">'+
	      '<div class="image">'+
	        '<img src="image/' + id + "?"+ (new Date().getTime()) + '">'+
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
	     '<td><img class="ui medium circular image contacter_image" src="image/'+contacter.id+ "?"+ (new Date().getTime())+'"></td>'+
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
	     '<td>'+contacter.cellphone+'</td>'+
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
	
	function contacter_groups_dom(groups, id) {
		var html = '';
		$.each(groups, function(offset, group) {
			 html += '<div class="contacter-groups" id="'+group.id+'">'+
		     '<div class="groups-style">'+group.name+ 
		     '<button class="ui red button remove-group-button" id="'+group.id+'">remove</button>'+
		     '</div>'+
		    '</div>';
		});
		return html ;
	}
	
	function contacter_list_action() {
		$(document).on("click", ".page-select", function() {
			
		});
	}
	
	function contacter_detail_page_action(id) {
		$("div.checkbox-item").show();
		$(".contacter_detail").html('');
		$(".contacter_detail_groups").html('');
		$.ajax({
			url: "contacter/get/"+id,
			type: "get",
			dataType: "json",
			success: function(data) {
				var html = contacter_detail_dom(data.contacter);
				$(".contacter_detail").append(html);
				var groups_html = contacter_groups_dom(data.contacter.groups, id);
				$(".contacter_detail_groups").append(groups_html);
				remove_checkbox_item(data.contacter.groups);
			}
		});
	}
});

// 移除checkbox中已经进入的分组
function remove_checkbox_item(groups) {
	$.each(groups, function(offset, group) {
		console.log(".checkbox-item #"+group.id);
		$("div#"+group.id+".checkbox-item").hide();
	});
}
     


