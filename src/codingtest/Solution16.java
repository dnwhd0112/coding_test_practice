package codingtest;

import java.util.*;

public class Solution16 {
	public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> que_min = new PriorityQueue<Integer>();
        PriorityQueue<Integer> que_max = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++) {
        	String target = operations[i];
        	//삽입연산
        	if(target.charAt(0) == "I".charAt(0) || target.charAt(0) == "i".charAt(0)) {
        		Integer number = Integer.parseInt(target.substring(2));
        		que_min.add(number);
        		que_max.add(number);
        		
        	}else if(target.equals("D -1")) {
        		//최솟값삭제연산
        			if(que_min.isEmpty() || que_max.isEmpty()) {
        				continue;
        			}
        			int del_num = que_min.poll();
        			que_max.remove(del_num);
        	}else {
        		//최대값삭제연산	
    			if(que_min.isEmpty() || que_max.isEmpty()) {
    				continue;
    			}
    			int del_num = que_max.peek();
    			que_min.remove(del_num);
        	}
        }
        if(que_min.isEmpty() || que_max.isEmpty()) {
        	return new int[] {0,0};
        }
        answer = new int[] {que_max.poll(),que_min.poll()};
        return answer;
    }
	
	 public static void main(String[] args) {  
		  Solution16 solution = new Solution16();
		  String[] operations = {"I 1","I -1","D -1"};
		  int[] answer = solution.solution(operations);
		  System.out.println(answer[0]);
		  System.out.println(answer[1]);
	}
	 
	 
	 
				
}

