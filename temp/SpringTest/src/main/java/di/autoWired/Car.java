package di.autoWired;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import di.tire.Tire;

public class Car {
	
	@Resource @Qualifier("gTire")
	private Tire tire;
	
	public String getInfo() {
		return tire.getProduct()+" added!";
	}
}
