package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Comment;
import model.Snippet;
import database.SnippetDatabase;


public class SnippetService {
	
	SnippetDatabase snippetDatabase = new SnippetDatabase();
	private Map<Integer, Snippet> snippets = SnippetDatabase.getSnippets();
	
	
	public List<Snippet> getAllSnippets(){
		return new ArrayList<Snippet>(snippets.values());
	}
	
	public Snippet getSnippet(Integer id){
		Snippet snippet = SnippetDatabase.getSnippet(id);
		return snippet;
	}
	
	public Snippet addSnippet(Snippet snippet){
		System.out.println("USAO U SERVICE");
		return SnippetDatabase.addSnippet(snippet);
		
	}
	
	public Snippet editSnippet(Snippet snippet){
		return SnippetDatabase.updateSnippet(snippet);
	}
	
	public void deleteSnippet(Snippet snippet){
		SnippetDatabase.deleteSnippet(snippet);
	}
	
	public List<Comment> getAllComments(Snippet snippet){
		return SnippetDatabase.getComments(snippet);
	}
}
