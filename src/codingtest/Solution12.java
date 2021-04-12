package codingtest;

import java.util.*;

//탐욕법 -> 조이스틱 패스

public class Solution12 {
	
	 public int solution(String name) {
	        int answer = 0;
	        for(int i=0; i<name.length(); i++) {
	        	answer += Math.min(name.charAt(i)-'A', 'Z' - name.charAt(i)+1);
	        }
	        Set<Integer[]> set = new HashSet<Integer[]>();
	        put_A_length(set, name);
	        int move_min = name.length()-1;
	        if(set.isEmpty()) {
	        	move_min = name.length() -1;
	        }
	        Iterator itr = set.iterator();
	        
	        while(itr.hasNext()) {
	        	//1.뒤로 가는 경우
	        	//2. 앞으로만 가는경우
	        	Integer[] temp = (Integer[]) itr.next();
	        	if(temp[0]==0) {
	        		move_min = Math.min(move_min, name.length()-1 - temp[1]);
	        		//AAABBAAAABBB
	        	}else {
	        	move_min = Math.min(move_min, (temp[0]-1)*2 + name.length()-1 - temp[1]);
	        	}//BBBBAAAAAAAB
	        	//move_min = Math.min(move_min, name.length()-1);
	        	if(temp[1] == name.length()-1) {
	        		move_min = Math.min(move_min, name.length()-2-temp[0]);
	        		//BBBAAAA ->2
	        	}
	        	move_min = Math.min(move_min, (name.length()-1-temp[1])*2+temp[0]-1);
	        	//BBBAAAAB 8
	        }
	        answer += move_min;
	        
	        return answer;
	    }

	 public void put_A_length(Set<Integer[]> set, String name) {
		 int start =-1;
		 int end = -1;
		 //시작과 끝을 기록하기 위한 변수 시작하지 않으면 -1
		 for(int i=0; i<name.length(); i++) {
			 if(name.charAt(i) == 'A') {
				 if(start == -1) {
					 start = i;
				 }
			 }else {
				 if(start != -1) {
					 end = i-1;
					 set.add(new Integer[] {start,end});
					 start = -1;
					 end = -1;
				 }
			 }
		 }
		 if(start != -1) {
			 set.add(new Integer[] {start,name.length()-1});
		 }
	 }
	 
	/*
	 * public static void main(String[] args) { Solution12 solution = new
	 * Solution12(); System.out.println(solution.solution("BBBAAAAB")); }
	 */
	 
	 
}
