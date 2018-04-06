package moviePage.func;

public class Func {

	public boolean isNumber(String idx) {
		try {
			char[] i_dx = idx.toCharArray();
			for(char c : i_dx) {
				if((c<'0'|c>'9')&c!='.') {
					return false;
				}
			}
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	public boolean isInt(String idx) {
		try {
			char[] i_dx = idx.toCharArray();
			for(char c : i_dx) {
				if(c<'0'|c>'9') {
					return false;
				}
			}
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}
