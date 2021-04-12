package codingtest;

public class Solution13 {
	//탐욕법 -> 큰수만들기

	 public String solution(String number, int k) {
	        
		 
		 	String answer = "";
	        return find_big(number,k,answer);
	    }
	 
	 public String find_big(String number, int k, String answer) {
		 
	/*
	 * return ""; }
	 */
		//풀이방법2
		 
		 int max_index = -1;
		 int max = -1;
		
		  for(int i =0; i<=k&&i<number.length(); i++) {
			  if(number.charAt(i)>max) 
			  {
				  max_index = i;
				  max = number.charAt(i);
				  if(max == 57) break;
			  } 
		  }
		  
		 
		 k = k - (max_index);
		 answer = answer + Character.getNumericValue(max);
		 number = number.substring(max_index+1);
		 if(k<=0) {
			 return answer + number;
		 }
		 if(k == number.length()) {
			 return answer;
		 }
		 return find_big(number,k,answer);
	 }
	
	 public static void main(String[] args) {
		  Solution13 solution = new Solution13(); 
		  String number = "999";
		  int k = 2;
		  System.out.println(solution.solution(number, k));
	 }
	 
	 
}
