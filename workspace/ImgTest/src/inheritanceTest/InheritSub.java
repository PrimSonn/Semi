package inheritanceTest;

class InheritSub extends InheritSuper{
	String s;
	InheritSub(){
		super();
		s = "sub";
	}
	public void setS(String s) { this.s = s; }
	public String getS() {return s;}
}
