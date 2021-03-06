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
	private static List<String> allLangs = new ArrayList<>();
	private static List<User> getAllLangs = new ArrayList<>();
	private static String filePath = "C:\\Users\\Branko\\Documents\\GitHub\\WebProjekat\\users.txt";
	private static String langsPath = "C:\\Users\\Branko\\Documents\\GitHub\\WebProjekat\\jezici.txt";
	
	public static Map<String, User> getUsers() {
		
		readFile();
		
		return allUsers;
	}
	
	public static User getUser(String userName, String password){
		readFile();
		User foundUser = null;
		
		for (Map.Entry<String, User> entry : allUsers.entrySet()) {
			if(userName.equals(entry.getKey()) && password.equals(entry.getValue().getPassword())){
				System.out.println("PRONASAO SAM KORISNIKA");
				foundUser = entry.getValue();
			}
		    
		}
		return foundUser;
	}
	
	public static User updateUser(User user){
		readFile();
		
		User foundUser=null;
		for (Map.Entry<String, User> entry : allUsers.entrySet()) {
			if(user.getUserName().equals(entry.getKey())){
				foundUser = entry.getValue();
				foundUser.setBlokiran("true");
			}
		    
		}
		allUsers.put(user.getUserName(), foundUser);
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

	public static User getOneUser(String userName) {
		readFile();
		User foundUser = null;
		
		for (Map.Entry<String, User> entry : allUsers.entrySet()) {
			if(userName.equals(entry.getKey())){
				System.out.println("PRONASAO SAM KORISNIKA");
				foundUser = entry.getValue();
			}
		    
		}
		return foundUser;
		
	}
	
	public static void readLangs(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(langsPath));
			String line;
			
			while((line = br.readLine())!=null){
				allLangs.add(line);
				User user = new User();
				user.setUserName(line);
				getAllLangs.add(user);
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
	
	public static void writeLangs(String jezik){
		File outputFile;
		BufferedWriter outputWriter;
		
		
		outputFile = new File(langsPath);
		try {
			
			outputWriter = new BufferedWriter(new FileWriter(outputFile,true));
			outputWriter.write(jezik);
			outputWriter.newLine();
	
			outputWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void addJezik(String jezik) {
		readLangs();
		for (int i = 0; i < allLangs.size(); i++) {
			if(allLangs.get(i).equals(jezik)){
				break;
			}
		}

		
		writeLangs(jezik);
		
	}

	public static List<User> allLangs() {
		readLangs();
		
		return getAllLangs;
	}
}
