$(document).ready(function() {
	
	var obj = { "userName":localStorage.getItem("userName")};
	var $comments = $('#comments');
	
	if(localStorage.getItem("userName")!=null){
		$.ajax({
	    	contentType: 'application/json',
	        url: '../SnippetApp/rest/users/getUser',
	        type : 'POST',
	        data: JSON.stringify(obj),
	        success: function(response){
	        	if(response==null){
	        		console.log('NULL');
	        	}else{
	        		console.log(response);
	        		document.getElementById("userName").value = response.userName;
	        		document.getElementById("firstName").value = response.firstName;
	        		document.getElementById("lastName").value = response.lastName;
	        		document.getElementById("password").value = response.password;
	        		document.getElementById("phone").value = response.phone;
	        		document.getElementById("email").value = response.email;
	        		document.getElementById("address").value = response.address;
	        	}

	        }
	    });
	}
	
	$("#odjava").click(function(){
		 
		localStorage.clear();
		window.location.href = "index.html";
				

	});
    
	
	
});