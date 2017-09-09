package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Comment;
import model.Snippet;
import database.SnippetDatabase;


public class SnippetService {
	
	SnippetDatabase snippetDatabase = new SnippetDatabase();
	
	
	public List<Snippet> getAllSnippets(){
		return new ArrayList<Snippet>(SnippetDatabase.getSnippets().values());
	}
	
	public Snippet getSnippet(Snippet snippet){
		System.out.println("USAO U GET SNIPPET SERVICE");
		Snippet snippet2 = SnippetDatabase.getSnippet(snippet);
		return snippet2;
	}
	

	
	public Snippet addSnippet(Snippet snippet){
		System.out.println("USAO U SERVICE");
		return SnippetDatabase.addSnippet(snippet);
		
	}
	
	public Comment addComment(Comment comment){
		return SnippetDatabase.addComment(comment);
		
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
