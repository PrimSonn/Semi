package dto.entities;

import java.util.ArrayList;
import java.util.Hashtable;

public class Comment extends Entity{
	
	private Hashtable<String,String> properties;
	private Hashtable<String,ArrayList<String>> imgs;
	
	public Comment () {
		properties = super.getPropertiesTable();
		imgs = super.getImgsTable();
	}
	
}
