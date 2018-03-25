package inheritanceTest;

public class InheritTestDriver {

	public static void main(String[] args) {
		
		InheritSuper ss = new InheritSub();
		System.out.println("Super: "+ss.getS());
		System.out.println("sub: "+ ((InheritSub)ss).getS());
		System.out.println("===================setsuper s====================");
		ss.setS("setSuperss");
		System.out.println("Super: "+ss.getS());
		System.out.println("sub: "+ ((InheritSub)ss).getS());
		System.out.println("================casted,set s=======================");
		((InheritSub)ss).setS("setSubss");
		System.out.println("Super: "+ss.getS());
		System.out.println("sub: "+ ((InheritSub)ss).getS());
		System.out.println("============================================");
		System.out.println("============================================");
		InheritSub a 
			= new InheritSub();
//		 	= (InheritSub) new InheritSuper();
		System.out.println("a getS: "+a.getS());
		System.out.println("casted a: "+((InheritSuper)a).getS());
		System.out.println("============================================");
		((InheritSuper)a).setS("casted to Super and changed");
		System.out.println("a getS: "+a.getS());
		System.out.println("casted a: "+((InheritSuper)a).getS());
		System.out.println("============================================");
		a.setS("setSubss");
		System.out.println("a getS: "+a.getS());
		System.out.println("casted a: "+((InheritSuper)a).getS());
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("direct approach to ss");
		ss = new InheritSub();
		ss.s="new";
		System.out.println("not casted: "+ss.s);
		System.out.println("casted to sub: "+ ((InheritSub)ss).s);
		
		System.out.println("direct approach to a");
		a = new InheritSub();
		a.s="new";
		System.out.println("not casted: "+a.s);
		System.out.println("casted to super: "+ ((InheritSuper)a).s);
		
		
		
		
		
		
		
	}

}
