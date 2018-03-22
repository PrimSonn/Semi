package testDriver;

import dao.Gatherer;
import dto.Pack;

public class TestDriver {
	public static void main(String[] a) {
		Gatherer get = new Gatherer();
		Pack pack = get.getThings();
		for(String key :pack.getKeys()) {
			System.out.println(pack.getList(key));
		}
	}
}
