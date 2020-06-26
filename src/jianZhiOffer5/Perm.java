package jianZhiOffer5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public class Perm {
	public ArrayList<String> Permutation(String str){
		ArrayList<String> ans = new ArrayList<String>();
		HashSet<String> res = helper(str);
		for(String s: res){
			ans.add(s);
		}
		Collections.sort(ans);
		return ans;
	}
	
    public HashSet<String> helper(String str) {
    	HashSet<String> res = new HashSet<String>();
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
