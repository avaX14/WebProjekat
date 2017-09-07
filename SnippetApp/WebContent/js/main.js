$(document).ready(function() {
	
	$("#btnLogin").click(function(){
		
		localStorage.clear();
        var value = $('#logUserName').val();
        localStorage.setItem("userName", value);
        
        console.log(localStorage.getItem("userName"));
		
		var obj = { "userName":$('#logUserName').val(), "password" : $('#logPassword').val()};
    	
        console.log(obj);
        $.ajax({
        	contentType: 'application/json',
            url: '../SnippetApp/rest/users/loginUser',
            type : 'POST',
            data: JSON.stringify(obj),
            success: function(response){
            	if(response==null){
            		console.log('NULL');
            		document.getElementById("messageLogin").className = '';
            	}else{
            		setTimeout(function(){ window.location.href = "pocetna.html"; }, 1000);
            	}

            }
        });  
		
	});
	
    $("#btnSubmit").click(function(){
    	
    	var obj = { "userName":$('#userName').val(), "password" : $('#password').val(), "firstName" : $('#firstName').val(), "lastName" : $('#lastName').val(), "role" : "korisnik", "phone" : parseInt($('#phone').val()), "email" : $('#email').val(), "address" : $('#address').val(), "image" : $('#image').val()};
    	
        console.log(obj);
        $.ajax({
        	contentType: 'application/json',
            url: '../SnippetApp/rest/users/registerUser',
            type : 'POST',
            data: JSON.stringify(obj),
            success: function(response){
            	if(response==null){
            		console.log('NULL');
            		document.getElementById("message").className = '';
            	}

            }
        });     
    }); 
    
});

