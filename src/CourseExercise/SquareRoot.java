package CourseExercise;

import java.text.DecimalFormat;

public class SquareRoot {
	public static String sqrRoot(float a) {
		double r = (1+a)/2;
		double gap = Math.abs(a/r - r);
		while(gap >= 0.01) {
			r = (a/r + r) / 2;
			gap = Math.abs(a/r - r);
		}
		DecimalFormat df = new DecimalFormat(".00");
		
		return df.format(r);
	}
	
	public static void main(String[] args) {
		System.out.println(sqrRoot(8));
	}

}
