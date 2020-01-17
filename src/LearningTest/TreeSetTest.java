package LearningTest;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		Set<Integer> test = new TreeSet<Integer>();
		Scanner s = new Scanner(System.in);
		String sentence = s.nextLine();
		String[] words = sentence.split("\\s+");
		for(String word : words) {
			int i = Integer.parseInt(word);
			test.add(i);
			System.out.println(test);
		}
		
		
	}
	


}
