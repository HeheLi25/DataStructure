package jianZhiOffer5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Perm {
	public ArrayList<String> Permutation(String str){
		Set<String> res = helper(str);
		if(res.isEmpty()) return new ArrayList<String>();
		String[] a = (String[]) res.toArray();
		Arrays.sort(a);
		return (ArrayList<String>) Arrays.asList(a);
	}
	
    public Set<String> helper(String str) {
    	Set<String> res = new HashSet<String>();
    	if(str.length() == 1){
    		res.add(str);
    		return res;
    	}
    	for(int i = 0; i < str.length(); i++){
    		String shortString = str.substring(0, i) + str.substring(i+1, str.length()); //去除位置i的字符
    		Set<String> smallList = helper(shortString); 
    		for(String s: smallList){
    			res.add(str.charAt(i) + s);
    		}
    	}
    	return res;
    }
    

}
