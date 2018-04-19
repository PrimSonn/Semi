package di.autoWired;

import sun.misc.SharedSecrets;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


@SuppressWarnings("restriction")
public class Person {
	
	public static void main(String[] zzz) throws ClassNotFoundException {
		
		ApplicationContext context = null;
		context = new FileSystemXmlApplicationContext("/src/main/java/di/autoWired/di.xml");
		
		Car car = (Car)context.getBean("car");
		
		System.out.println(car.getInfo());
		
		System.console();
//		boolean a = 
		SharedSecrets.getJavaLangAccess().getAnnotationType(Class.forName("di.autoWired.Car")).isInherited();
//		System.out.println(a);
	}
}