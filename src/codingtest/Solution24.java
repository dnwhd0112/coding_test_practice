package codingtest;

public class Solution24 {
	public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] check = new boolean[m][n];
        for(int x=0; x<m; x++) {
        	for(int y=0; y<n; y++) {
        		if(!check[x][y]) {
        			int color = picture[x][y];
        			if(color == 0) {
        				check[x][y] = true;
        				continue;
        			}
        			int temp = move(picture, check, x, y, color);
        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, temp);
        			if(temp!=0) {
        				numberOfArea++;
        			}
        		}
        	}
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	
	public int move(int[][] picture, boolean[][] check, int x, int y, int color) {
		int move = 0;
		if(x<0 || x>picture.length-1) {
			return 0;
		}
		if(y<0 || y>picture[0].length-1) {
			return 0;
		}
		if(picture[x][y] == color && check[x][y] == false) {
			move++;
			check[x][y] = true;
			move+=move(picture, check, x, y-1, color);
			move +=move(picture, check, x-1, y, color);
			move +=move(picture, check, x+1, y, color);
			move+=move(picture, check, x, y+1, color);
			
		}
		return move;
	}
	
	/*
	 * public static void main(String[] args) { Solution24 solution = new
	 * Solution24();
	 * 
	 * int m = 6; int n = 4; int[][] numbers = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0,
	 * 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
	 * System.out.println(solution.solution(m,n,numbers)[0]);
	 * System.out.println(solution.solution(m,n,numbers)[1]);
	 * 
	 * }
	 */
	

}
