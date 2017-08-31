package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.User;
import database.UserDatabase;

public class UserService {
	
	UserDatabase userDatabase = new UserDatabase();
	private Map<String, User> users = UserDatabase.getUsers();
	
	public List<User> getAllUsers(){
		return new ArrayList<User>(users.values());
	}
	
	public User getUser(String userName){
		User user = UserDatabase.getUser(userName);
		return user;
	}
	
	public User addUser(User user){
		System.out.println("USAO U SERVICE");
		return UserDatabase.addUser(user);
		
	}
	
	public User editUser(User user){
		return UserDatabase.updateUser(user);
	}
	
	public void deleteUser(User user){
		UserDatabase.deleteUser(user);
	}
	
}
