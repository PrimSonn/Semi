package temp;

public class TestClass {

	public static void main(String[] args) {
		int a = 15;
		int b = 2;
		System.out.println(a/b);
		System.out.println(((double)a+0.5)/(double)b);
		double dd = (double)a/(double)b;
		System.out.println((int)dd);
		
		int c = (int) Math.ceil(a/b);
		System.out.println("c:" + c);
		int d = (int)Math.ceil((double)a/(double)b);
		System.out.println("d: "+d);
		
	}

}
