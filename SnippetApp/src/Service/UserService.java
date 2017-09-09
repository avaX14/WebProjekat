package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.User;
import database.UserDatabase;

public class UserService {
	
	UserDatabase userDatabase = new UserDatabase();
	
	public List<User> getAllUsers(){
		return new ArrayList<User>(UserDatabase.getUsers().values());
	}
	
	public User getUser(String userName, String password){
		User user = UserDatabase.getUser(userName, password);
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

	public User getOneUser(String userName) {
		return UserDatabase.getOneUser(userName);
	}
	
}
