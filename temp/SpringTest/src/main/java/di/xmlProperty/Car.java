package di.xmlProperty;

import di.tire.Tire;

public class Car {
	
	private Tire tire;
	
	public String getInfo() {
		return tire.getProduct()+" added!";
	}
	public Tire getTire() {
		return tire;
	}
	public void setTire(Tire tire) {
		this.tire=tire;
	}
	
}
