package codingtest;

import java.util.*;

public class Solution17 {

	public String solution(int[] numbers) {

		String[] strings = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strings[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				return Integer.parseInt(b + a) - Integer.parseInt(a + b);
			}
		});
		/*
		 * (new Comparator<String>() {
		 * 
		 * @Override public int compare(String a, String b) { return
		 * Integer.parseInt(b+a) - Integer.parseInt(a+b); } });
		 */

		String result = "";
		for (String s : strings) {
			result += s;
		}
		
		if(result.charAt(0) == '0') {
			return "0";
		}
		

		return result;
	}

	
	  public static void main(String[] args) { Solution17 solution = new
	  Solution17(); 
	  //int[] numbers = {3, 30, 34, 5, 9};
	  //int[] numbers = {6,10,2};
	  int[] numbers = {0,0,0};
	  System.out.println(solution.solution(numbers)); }
	 

}
