package jianZhiOffer;

import java.util.ArrayList;
import java.util.HashMap;

public class CharArray {
	private HashMap<Character,Integer> occ;
	private ArrayList<Character> chars;
	
	public CharArray(){
		occ = new HashMap<Character,Integer>();
		chars = new ArrayList<Character>();
	}
	
	// Insert one char from stringstream
	public void insert(char ch) {
		if(occ.containsKey(ch)){
			occ.put(ch, occ.get(ch)+1);
		}else{
			occ.put(ch,1);
			chars.add(ch);
		}
	}

	// return the first appearence once char in current stringstream
	public char firstAppearingOnce() {
		for(Character c: chars){
			if(occ.get(c) == 1){
				return c;
			}
		}
		return '#';
	}
	
	public static void main(String args[]){
		CharArray test = new CharArray();
		test.insert('g');
		test.insert('o');
		test.insert('o');
		test.insert('g');
		test.insert('l');
		test.insert('e');
		System.out.println(test.firstAppearingOnce());
		
	}

}
