package codingtest;

import java.util.*;
import java.util.Queue;

public class Solution3 {
	public int solution(int[] priorities, int location) {
		int[] max_value = priorities.clone();
		Arrays.sort(max_value);
		int[] answer = new int[priorities.length];
		int max_index = max_value.length-1;
		int index = 0;
		int count = 0;
		while (max_index != -1) {
			while (max_value[max_index] != priorities[index]) {
				index++;
				if (index == priorities.length) {
					index = 0;
				}
			}
			answer[index] = count;
			count++;
			max_index--;
			index++;
			if (index == priorities.length) {
				index = 0;
			}
			
		}
		return answer[location]+1;
	}

	
	  public static void main(String[] args) {
		  Solution3 solution = new Solution3(); 
		  //int[] priorities = {2, 1, 3, 2}; 
		  //int location = 2;
		  
		  int[] priorities = {1, 1, 9, 1, 1, 1}; 
		  int location = 0;
		  
		  System.out.println(solution.solution(priorities, location));
	  
	 }
	 

}
