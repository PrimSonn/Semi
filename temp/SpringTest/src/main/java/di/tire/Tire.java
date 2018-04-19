package di.tire;

public interface Tire {

	default String getProduct() {
		return "No Tire";
	};
}
