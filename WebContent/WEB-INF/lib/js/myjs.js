$(document).ready(function () {
	var page = 1;
	$.ajax({
		type: "GET",
		data: {'id':page },
		url: "http://127.0.0.1:8080/Demo/contacter/page/1",
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
	
	$.ajax({
		type: 'GET',
		url: "http://127.0.0.1:8080/Demo/groups/all",
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
	
	function groups_dom(id, name, count) {
		var html = '  <a class="item" id="'+id+'">'+
		    name + 
		    '<div class="ui label">'+ count +'</div>'+
		  '</a>';
		  return html;
	}
	
	function contacters_dom(id, name, cellphone) {
		var html = ' <div class="column" id="' + id +'">'+
		    '<div class="ui fluid card">'+
	      '<div class="image">'+
	        '<img src="image/' + id +'">'+
	      '</div>'+
	      '<div class="content">'+
	       ' <a class="header">'+name+'</a>'+
	        '<p>'+cellphone+'</p>'+
	      '</div>'+
	    '</div>'+
	  '</div>';
	  return html;
	}
});