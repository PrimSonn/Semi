package moviePage.dto.entities;

import java.util.ArrayList;
import java.util.Hashtable;

public class Entity {
	
	private Hashtable<String,String> properties;
	private Hashtable<String,ArrayList<String>> imgs;
	private String idx;
	
	public Entity() {
		properties = new Hashtable<String,String>();
		imgs = new Hashtable<String,ArrayList<String>>();
	}
	
	public String getIdx() {
		
		if (idx!=null) return idx;
		else {
			return properties.get("IDX");
		}
		
	}
	
	public void setIdx() {
		String s = properties.get("IDX");
		if(s!=null) {
			idx=null;
//			return true;
		} 
//		else return false;
	}
	
	public void setIdx(String idx) {
		this.idx=idx;
		properties.put("IDX", idx);
	}
	
	public String getProperty(String column) {
		return properties.get(column);
	}

	public void setProperty(String property, String value) {
		try{
			properties.put(property, value);
		}catch (NullPointerException e){
			e.printStackTrace();
//			return false;
		}
//		return true;
	}

	public ArrayList<String> getImgs(String type) {
		return imgs.get(type);
	}

	public void setImgs(String type, String file) {
		try {
			if(imgs.containsKey(type)) {
				imgs.get(type).add(file);
			}else {
				imgs.put(type, new ArrayList<String>());
				imgs.get(type).add(file);
			}
			
		} catch(NullPointerException e) {
			e.printStackTrace();
//			return false;
		}
//		return true;
	}
	
	public Hashtable<String,String> getPropertiesTable(){
		return properties;
	}
	
	public Hashtable<String,ArrayList<String>> getImgsTable(){
		return imgs;
	}
}
