$(document).ready(function() {
    $("#btnSubmit").click(function(){
    	
//    	var userName = $('#userName').val();
//    	var password = $('#password').val();
//    	var firstName = $('#firstName').val();
//    	var lastName = $('#lastName').val();
//    	var role = $('#role').val();
//    	var phone = $('#phone').val();
//    	var email = $('#email').val();
//    	var address = $('#address').val();
//    	var image = $('#image').val();
    	
    	console.log("test123");
//    	
    	var obj = { "userName":$('#userName').val(), "password" : $('#password').val(), "firstName" : $('#firstName').val(), "lastName" : $('#lastName').val(), "role" : $('#role').val(), "phone" : parseInt($('#phone').val()), "email" : $('#email').val(), "address" : $('#address').val(), "image" : $('#image').val()};
    	var myJSON = JSON.stringify(obj);
    	console.log(JSON.stringify(myJSON));
    	
//        var formData = JSON.stringify($("#myForm").serializeArray());
        console.log(obj);
        $.ajax({
        	contentType: 'application/json',
            url: '../SnippetApp/rest/users/registerUser',
            type : 'POST',
            data: JSON.stringify(obj),
            success: function(response){
            	alert("URADIO");

            }


        });
        
    }); 
    
    
});

