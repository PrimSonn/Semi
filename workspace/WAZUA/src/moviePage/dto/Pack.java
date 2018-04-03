package moviePage.dto;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import moviePage.dto.entities.Entity;


public class Pack {
	private Hashtable<String,ArrayList<Entity>> uniList;
	
	public Pack() {
		uniList = new Hashtable<String,ArrayList<Entity>>();
	}
	
	public void putList(String tag, Entity ent) {
		try {
			if(uniList.containsKey(tag)) {
				uniList.get(tag).add(ent);
			}else {
				ArrayList<Entity> temp = new ArrayList<Entity>();
				temp.add(ent);
				uniList.put(tag, temp);
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
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
	
	public ArrayList<String> getMvImg(String type) {
		if(uniList.get("MOVIE")!=null) {
			return uniList.get("MOVIE").get(0).getImgs(type);
		} else {
			return null;
		}
		
	}
	
	public ArrayList<String> getAccImg(String type) {
		if(uniList.get("ACCOUNT")!=null) {
			return uniList.get("ACCOUNT").get(0).getImgs(type);
		}
		return null;
	}
}
