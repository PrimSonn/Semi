package dto;

import java.util.ArrayList;
import dto.entities.Account;
import dto.entities.Comment;
import dto.entities.Movie;

public class DtoPack {
	private Movie mainMovie;
	private Account mainAccount;
	private Comment mainComment;
	private ArrayList<Movie> movieList;
	private ArrayList<Account> accountList;
	private ArrayList<Comment> commentList;
	
	public DtoPack() {
		movieList = new ArrayList<Movie>();
		accountList = new ArrayList<Account>();
		commentList = new ArrayList<Comment>(); 
	}
	
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

	public Movie getMainMovie() {
		return mainMovie;
	}
	public void setMainMovie(Movie mainMovie) {
		this.mainMovie = mainMovie;
	}
	public Account getMainAccount() {
		return mainAccount;
	}
	public void setMainAccount(Account mainAccount) {
		this.mainAccount = mainAccount;
	}
	public Comment getMainComment() {
		return mainComment;
	}
	public void setMainComment(Comment mainComment) {
		this.mainComment = mainComment;
	}
}
