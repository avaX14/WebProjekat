package resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Comment;
import model.Snippet;
import Service.SnippetService;


@Path("/snippets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SnippetResources {
	
	SnippetService snippetService = new SnippetService();
	
	@GET
	@Path("/allSnippets")
	public List<Snippet> getSnippets(){
		return snippetService.getAllSnippets();
	}
	
	@POST
	@Path("/addSnippet")
	public Snippet addSnippet(Snippet snippet){
		System.out.println("USAO U RESOURCES");
		return snippetService.addSnippet(snippet);
	}
	
	@POST
	@Path("/allComments")
	public List<Comment> getComments(Snippet snippet){
		return snippetService.getAllComments(snippet);
	}
	
}
