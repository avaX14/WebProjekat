$(document).ready(function() {
	
	console.log(localStorage.getItem("userName"));
	
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
	
});