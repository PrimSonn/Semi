package testDriver;

import dao.Gatherer;
import dto.Pack;
import dto.entities.Entity;

public class TestDriver {
	public static void main(String[] a) {
		
		
		String dummyContextPath = "/DummyContext";//---------------------------------------------
		String dummyRealPath = "D:\\PWorkspace\\Semi\\EclipseWorkSpace\\ImgTest\\WebContent";//----------------------------------------------
		String dummyAccountIdx = "1";
		String dummyMovieIdx = "1";
		
		
		Pack pack = (new Gatherer()).getThings(dummyContextPath,dummyRealPath,dummyAccountIdx,dummyMovieIdx);
		for(String key :pack.getKeys()) {
			System.out.println(key);
			for(Entity e :pack.getList(key)){
				System.out.println("\tProperties: "+e.getPropertiesTable());
				System.out.println("\tImgs: "+e.getImgsTable());
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
