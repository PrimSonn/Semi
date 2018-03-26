package testDriver;

import dao.Gatherer;
import dto.Pack;
import dto.entities.Entity;

public class TestDriver {
	public static void main(String[] a) {
		
		Gatherer get = new Gatherer();
		Pack pack = get.getThings();
		for(String key :pack.getKeys()) {
			System.out.println(key);
			for(Entity e :pack.getList(key)){
				System.out.println("\tproperties: "+e.getPropertiesTable());
			}
		}
		
		/*
		String r = "123";
		String t = "12";
		if(r.contains(t)) {
			System.out.println("OK!");
		} else {
			System.out.println("NO");
		}
		*/
		
		/*
		String s = "12345";
		System.out.println("before : "+ s);
		System.out.println("sub s:  " +s.substring(1));
		System.out.println("s:  " + s);
		*/
		
	}
}
