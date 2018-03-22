package dto;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import dto.entities.Entity;
import dto.entities.Account;
import dto.entities.Comment;
import dto.entities.Movie;

public class Pack {
	private Hashtable<String,ArrayList<Entity>> uniList;
//	private ArrayList<Movie> movieList;
//	private ArrayList<Account> accountList;
//	private ArrayList<Comment> commentList;
	
	public Pack() {
		uniList = new Hashtable<String,ArrayList<Entity>>();
//		movieList = new ArrayList<Movie>();
//		accountList = new ArrayList<Account>();
//		commentList = new ArrayList<Comment>(); 
	}
	
	public boolean putList(String tag, Entity ent) {
		try {
			if(uniList.containsKey(tag)) {
				uniList.get(tag).add(ent);
			}else {
				ArrayList<Entity> temp = new ArrayList<Entity>();
				temp.add(ent);
				uniList.put(tag, temp);
			}
			return true;
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Entity> getList(String tag){
		
		try {
			return uniList.get(tag);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Set<String> getKeys() { //------------- 4test
		return uniList.keySet();
	}
	
	
/*	
	public boolean putMovieList(Movie movie) {
		try {
			movieList.add(movie);
		}catch(NullPointerException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean putAccountList(Account account) {
		try {
			accountList.add(account);
		}catch(NullPointerException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean putCommentList(Comment comment) {
		try {
			commentList.add(comment);
		}catch(NullPointerException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public ArrayList<Comment> getCommentList() {
		return commentList;
	}
*/
}
