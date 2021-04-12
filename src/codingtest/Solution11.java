package codingtest;

import java.util.*;

public class Solution11 {
	
	public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lost_set = new HashSet<Integer>();
        Set<Integer> reserve_set = new HashSet<Integer>();
        int answer = n - lost.length;
		
		for(int s : lost) { lost_set.add(s); }
		
		
		
        for(int j : reserve) {
        	reserve_set.add(j);
        }
        
        for(int i=0; i<lost.length; i++) {
        	if(reserve_set.contains(lost[i])) {
        		reserve_set.remove(lost[i]);
        		lost[i] = -99;
        		answer++;
        	}
        }
        for(int s : lost) {
	       if(reserve_set.contains(s-1)) {
	    		reserve_set.remove(s-1);
	    		answer++;
	    	}else if(reserve_set.contains(s+1)) {
	    		reserve_set.remove(s+1);
	    		answer++;
	    	}
        }
        
		
        return answer;
    }
	
	
	  public static void main(String[] args) { Solution11 solution = new Solution11();
	   
	  int n = 5; int[] lost = {1,2,3}; int[] reserve = {1,2,3};
	  
	  System.out.println(solution.solution( n, lost, reserve));
	  
	  }
	 

	
	
}
