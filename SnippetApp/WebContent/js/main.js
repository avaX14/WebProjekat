$(function(){
	var $users = $('#users'); 
	$.ajax({
		type: 'GET',
		url: '../SnippetApp/rest/users/allUsers',
		dataType : "json",
		success:function(users){
			$.each(users, function(i, user){
				$users.append('<li>' + user.firstName + '</li>');
			});
		}
	});
});