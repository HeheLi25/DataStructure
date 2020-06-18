package jianZhiOffer5;

public class OccurTime {
    public int GetNumberOfK(int [] array , int k) {
        int pos = findPos(array, 0, array.length-1, k);
        if(pos == -1) return 0;
        int counter = 1;
        int left = pos - 1;
        while(left >= 0){
        	if(array[left] == k){
        		counter ++;
        		left--;
        	}
        	else break;
        }
        int right = pos + 1;
        while(right < array.length){
        	if(array[right] == k){
        		counter ++;
        		right++;
        	}
        	else break;
        }
        return counter;
    }
    
    public int findPos(int[] array, int left, int right, int k){
    	if(left > right) return -1;
    	if(k < array[left] || k > array[right]) return -1;
    	int mid = (left+right)/2;
    	if(array[mid] == k) return mid;
    	else if(array[mid] > k) return findPos(array, left, mid-1, k);
    	else return findPos(array, mid+1, right, k);
    }
    
    
    
    
    
    public int GetNumberOfK2(int [] array , int k) {
    	return findPos2(array, k+0.5) - findPos2(array, k-0.5);
    }
    
    public int findPos2(int[] array, double db){
    	int left = 0, right = array.length-1;
    	while(left <= right){
    		int mid = (right - left / 2) + left;
    		if (array[mid] < db)
    			left = mid + 1;
    		else if (array[mid] > db)
    			right = mid-1;
    	}
    	return left;
    }
    
    public static void main(String[] args){
    	int[] test = {1,3,4,4,5,6,7};
    	OccurTime t = new OccurTime();
    	System.out.println(t.GetNumberOfK(test, 7));
    }

}
