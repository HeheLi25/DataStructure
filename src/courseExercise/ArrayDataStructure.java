package courseExercise;

public class ArrayDataStructure{
	public static boolean sortedOrNot(int[] array) {
		for(int i = 0; i < array.length-1; i++) {
			if(array[i]>array[i+1]) {
				return false;
			}
		}return true;
	}
	public static boolean palindrom(String s) {
		s = s.toLowerCase();
		s = s.replaceAll("\\s","");
		s = s.replaceAll("\\pP","");
		System.out.println(s);
		char[] a = s.toCharArray();
		
		for(int i = 0; i< a.length/2; i++) {
			if(a[i] != (a[a.length-1-i])) {
				return false;
			}
		}return true;
	}
	
	
	public static void main(String[] args) {
//		int[] a = new int[] {1,2,3,4,5,5,6,7};
//		System.out.println(sortedOrNot(a));
		System.out.println(palindrom("Madam, I'm Adam. "));
	}
}
