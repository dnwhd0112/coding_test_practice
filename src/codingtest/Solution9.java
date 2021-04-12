package codingtest;

import java.util.*;

class Solution9 {
    
    
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();
        String cur = "";
        makeEveryCase(set, numbers, cur);
  
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()) {
        	if(isItSosu(itr.next().intValue())) {
        		answer++;
        	}
        }
        return answer;
    }
    
    public boolean isItSosu(int num){
    	if(num <= 1) {
    		return false;
    	}
    	for(int i =2; i<=Math.sqrt(num); i++) {
    		if(num%i == 0) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public void makeEveryCase(Set<Integer> set, String numbers, String cur) {
    	for(int i=0; i<numbers.length(); i++) {
    		String target = Character.toString(numbers.charAt(i));
    		String new_cur = new String(cur) + target; 
    		set.add(Integer.parseInt(new_cur));
    		String temp = new String(numbers);
    		makeEveryCase(set, temp.replaceFirst(target,"") , new_cur);
    		
    	}
    }
    
	
	  public static void main(String[] args) { Solution9 solution = new
	  Solution9(); String numbers = "0001";
	  System.out.println(solution.solution(numbers)); }
	 
	 
    
    
}