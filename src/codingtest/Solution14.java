package codingtest;

import java.util.*;

public class Solution14 {
	// 탐욕법 - 구명보트
	 public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
	        int big = people.length -1;
	        int small = 0;
	        while(true) {
	        	
	        	int sum = people[big] + people[small];
	        	if(sum<=limit) {
	        		big--;
	        		small++;
	        		answer++;
	        		if(small-1 == big) {
		        		break;
		        	}
	        	}else {
	        		big--;
	        		answer++;
	        	}
	        	if(small == big) {
        			answer++;
        			break;
        		}
	        	
	        }
	         
	        return answer;
	    }
	 
	 public static void main(String[] args) {
		  Solution14 solution = new Solution14(); 
		  int[] people = {70, 50, 80};
		  System.out.println(solution.solution(people,100));
	 }
	 

}
