package dto.entities;

import java.util.ArrayList;
import java.util.Hashtable;

public class Entity {
	
	private Hashtable<String,String> properties;
	private Hashtable<String,ArrayList<String>> imgs;
	
	
	public Entity() {
		properties = new Hashtable<String,String>();
		imgs = new Hashtable<String,ArrayList<String>>();
	}
	
	public int getIdx() {
		return Integer.parseInt(properties.get("IDX"));
	}
	
	public boolean setIdx(int idx) {
		try {
			properties.put("IDX",String.valueOf(idx));
			}catch(NullPointerException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}
	
	public String getProperty(String column) {
		return properties.get(column);
	}

	public boolean setProperty(String column, String value) {
		try{
			properties.put(column, value);
		}catch (NullPointerException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<String> getImgs(String type) {
		return imgs.get(type);
	}

	public boolean setImgs(String type, String dir) {
		try {
			imgs.get(type).add(dir);
		} catch(NullPointerException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Hashtable<String,String> getPropertiesTable(){
		return properties;
	}
	
	public Hashtable<String,ArrayList<String>> getImgsTable(){
		return imgs;
	}
}
