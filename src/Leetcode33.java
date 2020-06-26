
public class Leetcode33 {
    public static int search(int[] nums, int target) {
    	if(nums.length < 1) return -1;
        return biSearch(nums, 0, nums.length-1, target);
    }
    
    public static int biSearch(int[] a, int left, int right, int target) {
    	if(right - left <= 1) {
    		if(a[right] == target) return right;
    		if(a[left] == target) return left;
    		else return -1;
    	}
    	int mid = (left + right) / 2;
    	if(a[mid] == target)
    		return mid;
    	else if(a[left] < a[mid]) {
    		//left side in order
    		if(target >= a[left] && target <= a[mid])
    			return biSearch(a, left, mid-1, target);
    		else
    			return biSearch(a, mid+1, right, target);
    	}else {
    		if(target <= a[right] && target >= a[mid])
    			return biSearch(a, mid+1, right, target);
    		else
    			return biSearch(a, left, mid-1, target);
    	}
    		
    }
    
    public static void main(String[] args) {
    	int[] i = {3,1};
    	System.out.println(search(i,1));
    }

}
