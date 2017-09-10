$(document).ready(function() {
	
	var $korisnici = $('#korisnici');
	console.log(localStorage.getItem("userName"));
	
	if(localStorage.getItem("blokiran")=="true"){
		var d = document.getElementById("snippet");
		d.className += " hidden";
		document.getElementById("blokiranPoruka").classList.remove("hidden");
	}
	
	if(localStorage.getItem("userName")=="admin1"){
		document.getElementById("addJezik").classList.remove("hidden");
		$.ajax({
			type:'GET',
			url:'../SnippetApp/rest/users/allUsers',
			success:function(korisnici){
				$.each(korisnici, function(i, korisnik){
					console.log("SVI SNIPPETI");
					if(korisnik.userName!="admin1"){
						$korisnici.append('<li><label>' + korisnik.userName + ": "+ '</label>' + korisnik.firstName + " " + korisnik.lastName+ "            "+ '<a data-id="' + korisnik.userName +  '" onclick="blokiraj(this)" style="color:red;">Blokiraj korisnika</a></li>' );
					}
				});
			}
		});
	}
	
	
	
	$("#snippetSubmit").click(function(){
		
		//Date
		var mydate = new Date();
		var year = mydate.getFullYear();
		//var day = mydate.getDay();
		var month = mydate.getMonth();
		var daym = mydate.getDate();
		var montharray = new Array("Januar", "Februar", "Mart", "April", "Maj", "Jun", "Jul", "Avgust", "Septembar", "Oktobar", "Novembar", "Decembar");
		
		//Time
		var currentTime = new Date();
		var h = currentTime.getHours();
		var m = currentTime.getMinutes();
		if(h==24){
			h=0;
		}else if(h>12){
			h = h-0;
		}
		
		if(h<10){
			h="0" + h;
		}
		
		if(m<10){
			m = "0" + m;
		}
		
		var dateTime = " " + daym +" "+ montharray[month] +" "+ year +" , "+ h +":"+m;  
		
    	var obj = {"userName":localStorage.getItem("userName"), "vremeDatum": dateTime, "opis":$('#opisSnippeta').val(), "kod" : $('#kod').val(), "jezik" : $("#jezik option:selected").text(), "urlKoda" : $('#urlKoda').val()};
    	
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
            		setTimeout(function(){ window.location.href = "snippeti.html"; }, 1000);
            	}

            }
        });     

    });
	
	$("#buttonJezik").click(function(){
		
		var obj = {"userName":$('#dodajJezik').val()};
    	
        console.log(obj);
        
        $.ajax({
        	contentType: 'application/json',
            url: '../SnippetApp/rest/users/addJezik',
            type : 'POST',
            data: JSON.stringify(obj),
            success: function(response){
            	if(response==null){
            		console.log('NULL');
            	}else{
            		console.log('USPEH');
            	}

            }
        }); 
		
		
		    

    });
	
});