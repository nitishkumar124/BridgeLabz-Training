package week9;
public class ImageSmoother_661 {
	public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        int[][] result = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j <n; j++){
                int sum = 0;
                int count = 0;

                for(int x = i - 1; x <= i + 1; x++){
                    for(int y = j - 1; y <= j + 1; y++){
                        if(x >= 0 && x < m && y >= 0 && y < n){
                            sum += img[x][y];
                            count++;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		ImageSmoother_661 solution = new ImageSmoother_661();
		int[][] img = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] smoothed = solution.imageSmoother(img);
		for (int i = 0; i < smoothed.length; i++) {
			for (int j = 0; j < smoothed[0].length; j++) {
				System.out.print(smoothed[i][j] + " ");
			}
			System.out.println();
		}
	}
}
