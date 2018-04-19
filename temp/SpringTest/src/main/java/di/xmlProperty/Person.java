package di.xmlProperty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di.tire.Tire;

public class Person {
	
	public static void main(String[] zzz) {
		
		ApplicationContext context = null;
		context = new FileSystemXmlApplicationContext("/src/main/java/di/xmlProperty/di.xml");
		
		Car gCar = (Car)context.getBean("gCar");
		Car sCar = (Car)context.getBean("sCar");
		System.out.println(gCar.getInfo());
		System.out.println(sCar.getInfo());
		
		System.out.println(gCar==sCar);
		System.out.println(gCar.getClass().isInstance(sCar));
		
	}
}
