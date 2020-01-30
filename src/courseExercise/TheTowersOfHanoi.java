package courseExercise;

public class TheTowersOfHanoi {
	  static int towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod, int num) 
	    { 
	        if (n == 1) 
	        { 
	            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod); 
	            return num+1; 
	        } 
	        int num1 = towerOfHanoi(n-1, from_rod, aux_rod, to_rod, num); 
	        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
	        int num2 = towerOfHanoi(n-1, aux_rod, to_rod, from_rod, num1+1); 
	        return num2;
	    } 
	      
	    //  Driver method 
	    public static void main(String args[]) 
	    { 
	        int n = 6; // Number of disks 
	        
	        System.out.println(towerOfHanoi(n, 'A', 'C', 'B',0)); // A, B and C are names of rods 
	    } 

}
