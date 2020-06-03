package jianZhiOffer2;

public class Robot {
	int[][] a;
	int rows;
	int cols;
	int threshold;
	int counter;

	public int movingCount(int threshold, int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.threshold = threshold;
		a = new int[rows][cols];
		counter = 0;
		findWay(0, 0);
		return counter;
	}

	public void findWay(int r, int c) {
		if (r < 0 || c < 0 || r >= rows || c >= cols)
			return;
		if (a[r][c] == -1 || a[r][c] == 1)
			return;

		int sum = r / 10 + r - (r / 10 * 10) + c / 10 + c - (c / 10 * 10);
		if (sum <= threshold) {
			a[r][c] = 1;
			counter++;
		} else {
			a[r][c] = -1;
			return;
		}
		findWay(r + 1, c);
		findWay(r, c + 1);
		findWay(r - 1, c);
		findWay(r, c - 1);
	}

	public static void main(String[] args) {
		Robot ex = new Robot();
		System.out.println(ex.movingCount(10, 1, 100));
	}

}
