package codingtest;

import java.util.*;

public class Solution5 {
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        int[] check_list = new int[n];
	        Stack<Integer> stack = new Stack<Integer>();
	        
	        for(int j =0; j<n; j++) {
	    		if(check_list[j] == 0) {
	    			answer++;
	    			dfs(n, computers, stack, j, check_list);
	    		}
	    	}
	        return answer;
	    }
	    
	    public void dfs(int n, int[][] computers, Stack<Integer> stack, int cur_node, int[] check_list ) {
	    	for(int i =0; i<n; i++) {
	    		if(computers[cur_node][i] == 1 && check_list[i] == 0) {
	    			stack.add(i);
	    			check_list[i] = 1;
	    		}
	    	}
	    	if(!stack.isEmpty()) {
	    		dfs(n, computers, stack, stack.pop(), check_list);
	    	}
	    	
	    }
	    
	    public static void main(String[] args) {
			  Solution5 solution = new Solution5(); 
			  int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};	
			  int n = 3; 
			  
			  System.out.println(solution.solution(n,computers));
		  
		 }
	    
}
