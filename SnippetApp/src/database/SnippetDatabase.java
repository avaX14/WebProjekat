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
import java.util.Iterator;
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
	private static String snippetFilePath = "C:\\Users\\Branko\\Documents\\GitHub\\WebProjekat\\snippets.txt";
	private static String filePathCom = "C:\\Users\\Branko\\Documents\\GitHub\\WebProjekat\\comments.txt";
	
	public static Map<Integer, Snippet> getSnippets() {
		
		readSnippets();
		
		return allSnippets;
	}
	
	public static List<Comment> getComments(Snippet snippet) {
		
		readComments();
		
		List<Comment> listaCom = new ArrayList<>();
		
		for (Map.Entry<Integer, Comment> entry : allComments.entrySet()) {
			if(snippet.getId()==entry.getValue().getSnippetId()){
				listaCom.add(entry.getValue());
			}
				    
		}
		
		for (int i = 0; i < listaCom.size(); i++) {
			System.out.println("Komentar: " + listaCom.get(i).toString());
		}
		
		
		return listaCom;
	}
	
	
	public static Snippet getSnippet(Snippet snippet){
		System.out.println("USAO U GET SNIPPET DATABASE");
		readSnippets();
		
		Snippet foundSnippet = null;
		int snippetId = snippet.getId();
		
		for (Map.Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
			if(snippetId==entry.getKey()){
				String kod = entry.getValue().getKod();
				kod = kod.replaceAll("<br>", "\n");
				entry.getValue().setKod(kod);
				foundSnippet = entry.getValue();
			}
		    
		}
		return foundSnippet;
	}
	
	public static Snippet updateSnippet(Snippet snippet){
		readSnippets();
		
		Snippet foundSnippet=null;
		for (Map.Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
			if(snippet.getId()==entry.getKey()){
				System.out.println("MENJAM SNIPPET");
				foundSnippet = entry.getValue();
				foundSnippet.setBlokKom("true");
			}
		    
		}
		allSnippets.put(foundSnippet.getId(), foundSnippet);
		writeSnippets();
		return foundSnippet;
	}
	
	public static Snippet addSnippet(Snippet snippet){
		readSnippets();
		
		int poslednji = 0;
		
		for (Map.Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
			poslednji = entry.getKey();
				    
		}
		
		snippet.setId(poslednji+1);
		
		
		System.out.println("Velicina niza snippeta: " + allSnippets.size());

		
		String kod = snippet.getKod();
		kod = kod.replaceAll("\\n", "<br>");
		snippet.setKod(kod);
		
		System.out.println("ID OD SNIPPETA JE: " + snippet.getId());
		if(snippet.getUserName()==null){
			snippet.setUserName("Gost");
		}
		snippet.setBlokKom("false");
		allSnippets.put(snippet.getId(), snippet);
		writeSnippets();
		
		return snippet;
		
	
		
	}
	
	public static Comment addComment(Comment comment){
		readComments();
		
		int poslednji = 0;
		
		for (Map.Entry<Integer, Comment> entry : allComments.entrySet()) {
			poslednji = entry.getKey();
				    
		}
		
		comment.setCommentId(poslednji+1);
		
		if(comment.getUserId()==null){
			comment.setUserId("Gost");
		}
		allComments.put(comment.getCommentId(), comment);
		writeComments();
		
		return comment;
		
	
		
	}
	
	public static void deleteSnippet(Snippet snippet){
		readSnippets();
		
		
		Iterator<Map.Entry<Integer, Snippet>> itr = allSnippets.entrySet().iterator();
		while(itr.hasNext())
		{
		   Map.Entry<Integer, Snippet> entry = itr.next();
		   if(entry.getKey()==snippet.getId())
		   {
		      System.out.println("Key : "+entry.getKey()+" Removed.");
		      itr.remove();  // Call Iterator's remove method.
		   }
		}
		
		deleteComments(snippet);
		
		/*
		for (Map.Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
			System.out.println("USAO U FOR");
			if(snippet.getId()==entry.getKey().intValue()){
				allSnippets.remove(snippet.getId());
			}
		}*/
		
		writeSnippets();
	}
	
	public static void deleteComments(Snippet snippet){
		readComments();
		
		Iterator<Map.Entry<Integer, Comment>> itr = allComments.entrySet().iterator();
		while(itr.hasNext())
		{
		   Map.Entry<Integer, Comment> entry = itr.next();
		   if(entry.getValue().getSnippetId()==snippet.getId())
		   {
		      System.out.println("Key : "+entry.getKey()+" Removed.");
		      itr.remove();  // Call Iterator's remove method.
		   }
		}
		
		/*
		for (Map.Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
			System.out.println("USAO U FOR");
			if(snippet.getId()==entry.getKey().intValue()){
				allSnippets.remove(snippet.getId());
			}
		}*/
		
		writeComments();
	}
	
	public static void writeSnippets(){
		File outputFile;
		BufferedWriter outputWriter;
		outputFile = new File(snippetFilePath);
		
		try {
			
			outputWriter = new BufferedWriter(new FileWriter(outputFile));
			for (Entry<Integer, Snippet> entry : allSnippets.entrySet()) {
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
		outputFile = new File(filePathCom);
		
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
			/*
			BufferedReader br = new BufferedReader(new FileReader(snippetFilePath));
			String line;
			
			while((line = br.readLine())!=null){
				System.out.println("USAO U WHILE");
				String[] parts = line.split("\\|");
				System.out.println(Integer.parseInt(parts[0]));
				Snippet snippet = new Snippet(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]);
				allSnippets.put(Integer.parseInt(parts[0]), snippet);
				System.out.println(snippet.toString());
			}
			
			br.close();
			*/
			
			FileReader in = new FileReader(snippetFilePath);
		    BufferedReader br = new BufferedReader(in);
		    
		    String line = "";
		    

		    while ((line = br.readLine())!=null) {
		    	String[] parts = line.split("\\|");
		    	System.out.println("BROJ PARTOOOOVA: " + parts.length);
		    	Snippet snippet = new Snippet(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[7], parts[5],parts[6], parts[4]);
				allSnippets.put(Integer.parseInt(parts[0]), snippet);    	
		    }
		    in.close();
		    System.out.println(allSnippets.toString());
			
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
	
	public static void readComments(){
		try {
			System.out.println("TRAZIM FAJL");
			FileReader in = new FileReader(filePathCom);
			BufferedReader br = new BufferedReader(in);
			String line;
	
			while((line = br.readLine())!=null){
				String[] parts = line.split("\\|");
				Comment comment = new Comment(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]);
				allComments.put(Integer.parseInt(parts[1]), comment);
				System.out.println(comment.toString());
			}
			
			in.close();
			
			
			
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

	public static void deleteComment(Comment comment) {
		readComments();
		
		
		Iterator<Map.Entry<Integer, Comment>> itr = allComments.entrySet().iterator();
		while(itr.hasNext())
		{
		   Map.Entry<Integer, Comment> entry = itr.next();
		   if(entry.getValue().getCommentId()==comment.getCommentId())
		   {
		      System.out.println("Key : "+entry.getKey()+" Removed.");
		      itr.remove();  // Call Iterator's remove method.
		   }
		}
		
		writeComments();
	}
}
