package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.User;

public class UserDatabase {
	
	private static Map<String, User> allUsers = new HashMap<>();
	private static String filePath = "C:\\Users\\Branko\\Documents\\GitHub\\WebProjekat\\users.txt";
	
	public static Map<String, User> getUsers() {
		
		readFile();
		
		return allUsers;
	}
	
	public static User getUser(String userName){
		readFile();
		User foundUser = null;
		
		for (Map.Entry<String, User> entry : allUsers.entrySet()) {
			if(userName.equals(entry.getKey())){
				foundUser = entry.getValue();
			}
		    
		}
		return foundUser;
	}
	
	public static User updateUser(User user){
		readFile();
		allUsers.put(user.getUserName(), user);
		writeFile();
		return user;
		//writeFile();
	}
	
	public static User addUser(User user){
		System.out.println("USAO U DATABASE");
		readFile();
		for (Map.Entry<String, User> entry : allUsers.entrySet()) {
			System.out.println("USAO U FOR");
			System.out.println("Ispisujem poslatog usera: " + user.getUserName());
			System.out.println("Ispisujem postojeceg usera: " + entry.getKey());
			if(user.getUserName().equals(entry.getKey())){
				System.out.println("USER VEC REGISTROVAN");
				return null;
			}
		}
		allUsers.put(user.getUserName(), user);
		
		for (Map.Entry<String, User> entry : allUsers.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
		
		writeFile();
		
		return user;
		
	}
	
	public static void deleteUser(User user){
		readFile();
		
		for (Map.Entry<String, User> entry : allUsers.entrySet()) {
			System.out.println("USAO U FOR");
			if(user.getUserName().equals(entry.getKey())){
				allUsers.remove(user.getUserName());
			}
		}
		
		writeFile();
	}
	
	public static void writeFile(){
		File outputFile;
		BufferedWriter outputWriter;
		
		
		outputFile = new File(filePath);
		try {
			
			outputWriter = new BufferedWriter(new FileWriter(outputFile));
			for (Map.Entry<String, User> entry : allUsers.entrySet()) {
				outputWriter.write(entry.getValue().toString());
				outputWriter.newLine();
				
				
			}
			outputWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void readFile(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			
			while((line = br.readLine())!=null){
				String[] parts = line.split("\\|");
				User user = new User(parts[0], parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), parts[6], parts[7], parts[8]);
				allUsers.put(parts[0], user);
				System.out.println(user.toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
