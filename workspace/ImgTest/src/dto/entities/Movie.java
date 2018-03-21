package dto.entities;

import java.util.ArrayList;
import java.util.Hashtable;

public class Movie extends Entity{
	
	private Hashtable<String,String> properties;
	private Hashtable<String,ArrayList<String>> imgs;
	
	public Movie (){
		properties = super.getPropertiesTable();
		imgs = super.getImgsTable();
	}
	
}
