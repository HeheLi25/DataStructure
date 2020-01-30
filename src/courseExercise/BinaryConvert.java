package courseExercise;

public class BinaryConvert {
	public static String notRec(int n) {
		String result = "";
		int remain = 0;
		while(n>0) {
			remain = n%2;
			result = remain + result;
			n = n/2;
		}
		return result;
	}
	
	public static String recBinary(int n) {
		if(n == 0) {
			return "";
		}else {
			int remain = n%2;
			return recBinary(n/2)+remain;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(notRec(243));
		System.out.println(recBinary(243));
		
	}

}
