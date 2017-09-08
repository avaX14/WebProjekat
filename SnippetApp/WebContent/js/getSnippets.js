$(document).ready(function() {
	var $snippets = $('#snippets');
	
	$.ajax({
		type:'GET',
		url:'../SnippetApp/rest/snippets/allSnippets',
		success:function(snippets){
			$.each(snippets, function(i, snippet){
				$snippets.append('<li><a href="snippetInfo.html" data-id="' + snippet.id + '" onclick="getID(this)">' + snippet.opis + '</a></li>' );
				
			});
		}
	});
	
	
});