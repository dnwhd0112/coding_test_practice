package codingtest;

public class Solution20 {
	    public int solution(int m, int n, int[][] puddles) {
	    	int[][] seet = new int[n][m];
	    	int max_y = n-1;
	    	int max_x = m-1;
	    	for(int i=0; i<puddles.length; i++) {
	    		int[] target = puddles[i];
	    		int x = target[0]-1;
	    		int y = target[1]-1;
	    		seet[y][x] = -1;
	    	}
	    	seet[0][0] = 1;
	    	for(int y=0; y<n; y++) {
	    		for(int x=0; x<m; x++) {
	    			if(seet[y][x] == -1) {
	    				seet[y][x] = 0;
	    				continue;
	    			}
	    			if(y != 0) {
	    				seet[y][x] += seet[y - 1][x] % 1000000007;
	    			}
    			  if(x != 0) {
    		          seet[y][x] += seet[y][x - 1] % 1000000007; 
    		      }
	    		}
	    	}
	    	return seet[n-1][m-1] % 1000000007;
	    }
	    
	    public static void main(String[] args) {
			  Solution20 solution = new Solution20();
			  int m = 4;
			  int n = 3;
			  int[][] numbers = {{2,2}};
			  System.out.println(solution.solution(m,n,numbers)); 
			  }
	

}
