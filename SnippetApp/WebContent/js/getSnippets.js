$(document).ready(function() {
	var $snippets = $('#snippets');
	var obj = { "id":localStorage.getItem("snippetId")};
	
	$.ajax({
		type:'GET',
		url:'../SnippetApp/rest/snippets/allSnippets',
		success:function(snippets){
			$.each(snippets, function(i, snippet){
				console.log("SVI SNIPPETI");
				$snippets.append('<li><label>' + snippet.userName + ": "+ '</label><a href="snippetInfo.html" data-id="' + snippet.id + '" onclick="getID(this)">' + snippet.opis + '</a></li>' );
				
			});
		}
	});
	
	
	
	
});