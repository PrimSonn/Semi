package dto.entities;

import java.util.ArrayList;
import java.util.Hashtable;

public class Account extends Entity{
	
	private Hashtable<String,String> properties;
	private Hashtable<String,ArrayList<String>> imgs;
	
	public Account() {
		properties = super.getPropertiesTable();
		imgs = super.getImgsTable();
	}
	
}
