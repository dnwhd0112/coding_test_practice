package codingtest;

public class Solution19 {
	
	    public int solution(int[][] triangle) {
	    	int[][] copy = new int[triangle.length][];
	    	for(int x=0; x<triangle.length; x++) {
	    		copy[x] = triangle[x].clone();
	    	}
	    	for(int i=0; i<triangle.length; i++) {
	    		for(int k=0; k<triangle[i].length; k++) {
	    			copyvalue(triangle, copy, i, k);
	    		}
	    	}
	    	
	        int answer = 0;
	        for(int j =0; triangle[triangle.length-1].length>j; j++) {
	        	answer = Math.max(answer, copy[triangle.length-1][j]);
	        }
	        return answer;
	    }
	
	
	public void copyvalue(int[][] triangle, int[][] copy, int i, int k) {
		if(i == triangle.length-1) {
			return;
		}
		int target = copy[i][k];
		if(target + triangle[i+1][k] > copy[i+1][k]) {
			copy[i+1][k] = target + triangle[i+1][k];
		}
		if(target + triangle[i+1][k+1] > copy[i+1][k+1]) {
			copy[i+1][k+1] = target + triangle[i+1][k+1];
		}
	}
	
	 public static void main(String[] args) {
		  Solution19 solution = new Solution19(); 
		  int[][] numbers = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		  System.out.println(solution.solution(numbers)); }
	
	
	

}
