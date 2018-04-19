package di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di.tire.Tire;

public class Person {
	
	public static void main(String[] zzz) {
		
		ApplicationContext context = null;
		context = new FileSystemXmlApplicationContext("/src/main/java/di/xml/di.xml");
		
		Car car = (Car)context.getBean("car");
		car.setTire( (Tire)context.getBean("gTire") );
		System.out.println(car.getInfo());
		car.setTire( (Tire)context.getBean("sTire") );
		System.out.println(car.getInfo());
		
		System.out.println();
		System.out.println(context.getBean("car").equals(context.getBean("car")));
	}
}
