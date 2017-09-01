package resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.User;
import Service.UserService;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	UserService userService = new UserService();
	
	@GET
	@Path("/allUsers")
	
	public List<User> getMessages(){
		return userService.getAllUsers();
	}
	
	@POST
	@Path("/registerUser")
	public User addUser(User user){
		System.out.println("USAO U RESOURCES");
		return userService.addUser(user);
	}
	
	@PUT
	@Path("/editUser")
	public User editUser(User user){
		return userService.editUser(user);
	}
	
	@DELETE
	@Path("/deleteUser")
	public void deleteUser(User user){
		userService.deleteUser(user);
	}
	
	
	@GET
	@Path("/{userName}")
	public User test(@PathParam("userName") String userName){
		return userService.getUser(userName);
	}
	
	
	
}
