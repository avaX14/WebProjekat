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
        		if(response.userName==localStorage.getItem("userName")||localStorage.getItem("userName")=="admin1"){    
        			console.log("Odobravam dugme");
        	    	document.getElementById("obrisiSnipet").classList.remove("hidden");
        	    }
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
				console.log("ISPISUJEM INDEKS" +i);
				$comments.append('<li>'+ comment.tekst + '<a id="obrisiKomentar" name = "comZaBrisanje" class="hidden" style="color:red;" data-id="' + comment.commentId + '" onclick="getID(this)">    Obrisi komentar</a></li>' );
				if(comment.userId==localStorage.getItem("userName")&&localStorage.getItem("userName")!=null||localStorage.getItem("userName")=="admin1"){
					console.log("USAO SAM");
					//document.getElementsByName("comZaBrisanje").classList.removeClass("hidden");
					document.getElementsByName("comZaBrisanje")[i].classList.remove("hidden");
				}
	
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
    
    $("#obrisiSnipet").click(function(){
		 $.ajax({
	    	contentType: 'application/json',
	        url: '../SnippetApp/rest/snippets/removeSnippet',
	        type : 'POST',
	        data: JSON.stringify(obj),
			success:function(){
				console.log("Obrisano");
				window.location.href = "pocetna.html";
				
			}
		});
		
	});
    
    /*
    $(document).on('click', '#obrisiKomentar', function() {
		var obj = { "commentId":localStorage.getItem("commentId")};
		console.log("BRISEM KOMENTAR");
		 $.ajax({
	   		contentType: 'application/json',
	       	url: '../SnippetApp/rest/snippets/removeComment',
	       	type : 'POST',
	       	data: JSON.stringify(obj),
			success:function(){
				console.log("Obrisano");
				window.location.reload();
				
			}
		});
	});*/
    
    
});