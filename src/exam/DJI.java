package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DJI {
	
	static char[][] al;
	static int[][] check;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = s.nextLine();
        }
        int m = s.nextInt();
        s.nextLine();
        String[] words = new String[m];
        for(int i = 0; i < m; i++) {
        	words[i] = s.nextLine();
        }
        char[][] alpha = new char[n][];
        check = new int[n][];
        for(int i = 0; i < n; i++) {
        	char[] temp = str[i].toCharArray();
        	alpha[i] = temp;
        	check[i] = new int[temp.length];
        }
        al = alpha;
        ArrayList<String> res = new ArrayList<String>();
        for(String word: words) {
        	char[] temp = word.toCharArray();
        	if(tool(0,0,temp,0)) {
        		res.add(word);
        	}
        	clear();
        }
        Collections.sort(res);
        for(String ans: res) {
        	System.out.println(ans);
        }

        
    }
    public static void clear() {
    	for(int i = 0; i < check.length; i++) {
    		for(int j = 0; j < check[i].length; j++) {
    			check[i][j] = 0;
    		}
    	}
    }
    public static boolean tool(int rows, int cols, char[] word, int pos) {
    	if(pos == word.length-1) return true;
    	if(pos == 0) {
        	int i = rows, j = cols;
        	for(; i < al.length; i++) {
        		j = 0;
        		while(j < al[i].length) {
        			if(al[i][j] == word[0]) {
        				check[i][j] = 1;
        				if(tool(i,j,word,pos+1)) return true;
        				else check[i][j] = 0;
        			}
        			j++;
        		}
        	}
        	return false;
    	}else {
    		if((cols+1) < al[rows].length) {
    			if(al[rows][cols+1] == word[pos] && check[rows][cols+1] != 1) {
    				check[rows][cols+1] = 1;
    				if(tool(rows,cols+1,word,pos+1)) return true;
    				else check[rows][cols+1] = 0;
    			}
    		}
    		if((cols -1) >= 0) {
    			if(al[rows][cols-1] == word[pos] && check[rows][cols-1] != 1) {
    				check[rows][cols-1] = 1;
    				if(tool(rows,cols-1,word,pos+1)) return true;
    				else check[rows][cols-1] = 0;
    			}
    		}
    		if((rows-1) > 0 && al[rows-1].length > cols) {
    			if(al[rows-1][cols] == word[pos] && check[rows-1][cols] != 1) {
    				check[rows-1][cols] = 1;
    				if(tool(rows-1,cols,word,pos+1)) return true;
    				else check[rows-1][cols] = 0;
    			}
    		}
    		if((rows+1) < al.length && al[rows+1].length > cols) {
    			if(al[rows+1][cols] == word[pos] && check[rows+1][cols] != 1) {
    				check[rows+1][cols] = 1;
    				if(tool(rows+1,cols,word,pos+1)) return true;
    				else check[rows+1][cols] = 0;
    			}
    		}
    		return false;
    	}
    	

    }
}
