package jianZhiOffer2;

public class MetricString {
	int r = 0, c = 0;
	int length = 0;
	int[] dir = {-1, 0, 1, 0, -1};
	char[] m;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
    	m = matrix;
    	r = rows;
    	c = cols;
    	length = str.length;
    	for(int i = 0; i < r; ++i){
    		for(int j = 0; j < c; ++j){
    			if(dfs(i,j,0,str))
    				return true;
    		}
    	}
		return false;
    }
    public boolean dfs(int i, int j, int pos, char[] str){
    	if(i < 0 || j < 0 || i >= r || j >= c) return false;
    	char ch = m[i*c+j];
    	
    	//是否访问过，是否匹配，否则结束这一路径
    	if(ch == '#' || ch != str[pos]){ 
    		return false;
    	}
    	//是否是最后一个字符，是则返回true
    	if(pos +1 == length){
    		return true;
    	}
    	//标记为已经访问
    	m[i*c+j] = '#';
    	//向四个方向前进
    	for(int k = 0; k < 4; ++k){
    		if(dfs(i+dir[k], j+dir[k+1], pos+1, str))
    			return true;
    	}
    	//四个方向都无法匹配，则回溯，将#还原成原字符，本路径匹配失败
    	m[i*c+j] = ch;
    	return false; 	
    }
    
    public static void main(String[] args){
    	MetricString a = new MetricString();
    	char[] m = {'A','B','C','E','S','F','C','S','A','D','E','E'};
    	char[] s = {'A','B','C','C','E','D'};
    	System.out.println(a.hasPath(m, 3, 4, s));
    	
    }
}
