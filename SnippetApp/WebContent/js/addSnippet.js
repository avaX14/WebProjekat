$(document).ready(function() {
	
	console.log(localStorage.getItem("userName"));
	
	$("#snippetSubmit").click(function(){
		
		var now = new Date(Date.now());
		
    	var obj = {"userName":localStorage.getItem("userName"), "vremeDatum": new Date(Date.now()), "opis":$('#opisSnippeta').val(), "kod" : $('#kod').val(), "jezik" : $("#jezik option:selected").text(), "urlKoda" : $('#urlKoda').val()};
    	
        console.log(obj);
        
        $.ajax({
        	cache:false,
        	contentType: 'application/json',
            url: '../SnippetApp/rest/snippets/addSnippet',
            type : 'POST',
            data: JSON.stringify(obj),
            success: function(response){
            	if(response==null){
            		console.log('NULL');
            	}else{
            		alert("DODAT SNIPPET");
            	}

            }
        });     

    }); 
	
});