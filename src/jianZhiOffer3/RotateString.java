package jianZhiOffer3;

public class RotateString {
    public String LeftRotateString(String str,int n) {
    	if(n >= str.length()) return str;
    	String part = str.substring(0,n);
    	String part2 = str.substring(n,str.length());
    	return part2+part;
        
    }
    
    public String LeftRotateString2(String str,int n) {
    	int l = str.length() - n;
    	if(l <= 0) return str;
    	str += str;
    	return str.substring(n, l+n+n);
        
    }
    
    public String LeftRotateString3(String str,int n) {
        int len = str.length();
        if(len == 0) return "";
        n = n % len;
        str += str;
        return str.substring(n, len);
        
    }



}
