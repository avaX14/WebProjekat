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
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Comment;
import model.Rating;
import model.Snippet;
import model.User;

public class SnippetDatabase {
	
	private static Map<Integer, Snippet> allSnippets = new HashMap<>();
	private static Map<Integer, Comment> allComments = new HashMap<>();
	private static String filePath = "C:\\Users\\Branko\\Documents\\GitHub\\WebProjekat\\snippets.txt";
	private static String filePathCom = "C:\\Users\\Branko\\Documents\\GitHub\\WebProjekat\\comments.txt";
	
	public static Map<Integer, Snippet> getSnippets() {
		
		readSnippets();
		
		return allSnippets;
	}
	
	public static List<Comment> getComments(Snippet snippet) {
		
		readComments(snippet.getId());
		
		List<Comment> listaCom = new ArrayList<>();
		
		for (Map.Entry<Integer, Comment> entry : allComments.entrySet()) {
			listaCom.add(entry.getValue());	    
		}
		
		
		return listaCom;
	}
	
	
	public static Snippet getSnippet(Integer id){
		readSnippets();
		Snippet foundSnippet = null;
		
		for (Map.Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
			if(id.equals(entry.getKey())){
				foundSnippet = entry.getValue();
			}
		    
		}
		return foundSnippet;
	}
	
	public static Snippet updateSnippet(Snippet snippet){
		readSnippets();
		allSnippets.put(snippet.getId(), snippet);
		writeSnippets();
		return snippet;
		//writeFile();
	}
	
	public static Snippet addSnippet(Snippet snippet){
		System.out.println("USAO U DATABASE");
		readSnippets();
		for (Map.Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
			System.out.println("USAO U FOR");
			if(snippet.getId()==entry.getKey()){
				System.out.println("USAO U IF");
				return null;
			}
		}
		allSnippets.put(snippet.getId(), snippet);
		
		for (Map.Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
		
		
		
		writeSnippets();
		
		return snippet;
		
	}
	
	public static void deleteSnippet(Snippet snippet){
		readSnippets();
		
		for (Map.Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
			System.out.println("USAO U FOR");
			if(snippet.getId()==entry.getKey()){
				allSnippets.remove(snippet.getId());
			}
		}
		
		writeSnippets();
	}
	
	public static void writeSnippets(){
		File outputFile;
		File outputFile2;
		BufferedWriter outputWriter;
		outputFile = new File(filePath);
		outputFile2 = new File(filePath);
		
		try {
			
			outputWriter = new BufferedWriter(new FileWriter(outputFile));
			for (Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
				outputWriter.write(entry.getValue().toString());
				outputWriter.newLine();
			}
			outputWriter.close();
			
			outputWriter = new BufferedWriter(new FileWriter(outputFile2));
			for (Entry<Integer, Comment> entry : allComments.entrySet()) {
				outputWriter.write(entry.getValue().toString());
				outputWriter.newLine();
			}
			outputWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void writeComments(){
		File outputFile;
		BufferedWriter outputWriter;
		outputFile = new File(filePath);
		
		try {
			
			outputWriter = new BufferedWriter(new FileWriter(outputFile));
			for (Entry<Integer, Comment> entry : allComments.entrySet()) {
				outputWriter.write(entry.getValue().toString());
				outputWriter.newLine();
			}
			outputWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void readSnippets(){
		try {
			System.out.println("TRAZIM FAJL");
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			
			BufferedReader br2 = new BufferedReader(new FileReader(filePathCom));
			String line2;
			
			while((line = br.readLine())!=null){
				String[] parts = line.split("\\|");
				Snippet snippet = new Snippet(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]);
				allSnippets.put(Integer.parseInt(parts[0]), snippet);
				System.out.println(snippet.toString());
			}
			
			while((line2 = br2.readLine())!=null){
				String[] parts = line2.split("\\|");
				Comment comment = new Comment(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]), parts[2], parts[3], parts[4], new Rating(Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
				allComments.put(Integer.parseInt(parts[1]), comment);
				System.out.println(comment.toString());
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
	
	public static void readComments(Integer snippetId){
		try {
			System.out.println("TRAZIM FAJL");
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
	
			while((line = br.readLine())!=null){
				String[] parts = line.split("\\|");
				Comment comment = new Comment(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]), parts[2], parts[3], parts[4], new Rating(Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
				if(comment.getSnippetId() == snippetId){
					allComments.put(Integer.parseInt(parts[1]), comment);
					System.out.println(comment.toString());
				}
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
