$(document).ready(function() {
	
	var obj = { "id":localStorage.getItem("snippetId")};
	var $comments = $('#comments');

    $.ajax({
    	contentType: 'application/json',
        url: '../SnippetApp/rest/snippets/getSnippet',
        type : 'POST',
        data: JSON.stringify(obj),
        success: function(response){
        	if(response==null){
        		console.log('NULL');
        	}else{
        		console.log(response);
        		document.getElementById("opisSnippeta").value = response.opis;
        		document.getElementById("progJezik").innerHTML = response.jezik;
        		document.getElementById("urlKoda").value = response.urlKoda;
        		document.getElementById("kod").value = response.kod;
        		document.getElementById("datum").innerHTML = response.vremeDatum;
        		document.getElementById("userName").innerHTML = response.userName;
        	}

        }
    });
    
    $.ajax({
    	contentType: 'application/json',
        url: '../SnippetApp/rest/snippets/allComments',
        type : 'POST',
        data: JSON.stringify(obj),
		success:function(comments){
			console.log(comments);
			$.each(comments, function(i, comment){
				$comments.append('<li>'+ comment.tekst + '</li>' );
				
				
			});
		}
	});
    
    $("#ostaviKomentar").click(function(){
    	
    	alert(localStorage.getItem("userName"));
    	console.log(localStorage.getItem("userName"));

    	var $comments = $('#comments');
		var obj = { "snippetId":localStorage.getItem("snippetId"), "userId" :localStorage.getItem("userName"), "datum": new Date(Date.now()), "tekst":$('#komentar').val()};
    	
        console.log(obj);
        $.ajax({
        	contentType: 'application/json',
            url: '../SnippetApp/rest/snippets/addComment',
            type : 'POST',
            data: JSON.stringify(obj),
            success: function(response){
            	if(response==null){
            		console.log('NULL');
            	}else{
            		$comments.append('<li>'+ response.tekst + '</li>' );
            	}

            }
        });  
    });
});