
public class PrintCircle {
	public static int[][] print(int input){
		if(input <= 0) return null;
		int[][] res = new int[input][input];
		int x = -1, y = input;
		int len = input-1;
		int count = 1;
		int n = input-1;
		while(n > 0) {
			x++;
			y--;
			for(int i = 0; i < n; i++) {
				res[x++][y] = count++;
				//System.out.println(x +"," + y);
			}
			for(int i = 0; i < n; i++) {
				res[x][y--] = count++;
			}
			for(int i = 0; i < n; i++) {
				res[x--][y] = count ++;
			}
			for(int i = 0; i < n; i++) {
				res[x][y++] = count ++;
			}

			n -= 2;
		}
		//System.out.println(n);
		if(n == 0) {
			res[input/2][input/2] = count ++;
		}
		return res;
	}
	
	public static void 0(String[] args) {
		int n = 9;
		int[][] res = print(n);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(String.format("%3d",res[i][j]));
			System.out.println();
		}
		
	}

}
