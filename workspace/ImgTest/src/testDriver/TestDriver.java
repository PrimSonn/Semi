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
				System.out.println("\t"+e.getPropertiesTable());
			}
		}
	}
}
