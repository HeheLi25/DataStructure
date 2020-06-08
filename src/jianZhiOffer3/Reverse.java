package jianZhiOffer3;

public class Reverse {
    public static String ReverseSentence(String str) {
    	String ans = "";
        String[] words = str.split("\\s+");
        if(words.length == 0) return str;
        for(int i = 0; i < words.length; i++) {
        	ans = words[i] + " "+ ans;
        }
        return ans.trim();
    }
    
    public static void main(String[] args) {
    	System.out.println(Reverse.ReverseSentence("you. thank fine, am I"));
    }

}
