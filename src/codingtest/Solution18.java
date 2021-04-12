package codingtest;

import java.util.Arrays;

public class Solution18 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        if(citations[citations.length-1] == 0) {
        	return 0;
        }
        return find_h(citations, 0, citations.length);
    }
    
    public int find_h(int[] citations, int head, int tail) {
    	
    	int index = (head + tail)/2;
    	int h = citations.length - index;
    	if(head == tail || index == 0) {
    		return h;
    	}
    	
    	if(check(citations, index)) {
    		if(check(citations, index-1)) {
    			tail = index;
    			return find_h(citations, head, tail);
    		}else {
    			return h;
    		}
    	}else {
    		head = index;
    		return find_h(citations, head, tail);
    	}
    }
    public boolean check(int[] citations, int index) {
    	int h = citations.length - index;
    	if(citations[index]>=h) {
    		return true;
    	}
    	return false;
    }
    

	  public static void main(String[] args) {
		  Solution18 solution = new Solution18(); 
		  int[] numbers = {0,0,0,0,0,0,0};
		  System.out.println(solution.solution(numbers)); }
    
    
}
