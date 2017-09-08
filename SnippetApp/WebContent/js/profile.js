$(document).ready(function() {
	var $users = $('#users');
	
	$.ajax({
		type:'GET',
		url:'../SnippetApp/rest/users/allUsers',
		success:function(users){
			$.each(users, function(i, user){
				$users.append('<li><label id="userName">' + user.userName+'</label>' +" " + user.firstName + " "+ user.lastName + '</li>' );
				$users.append('<button type="button" name="blockUser">Blokiraj</button>' );
				
			});
		}
	});
	
	
});