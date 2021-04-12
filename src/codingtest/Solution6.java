package codingtest;

import java.util.*;

public class Solution6 {
	
	static int answer = 0;
	
	public int solution(String begin, String target, String[] words) {
        int check_target = 0;
		for(int i=0; i<words.length; i++ ) {
        	if(words[i].equals(target)) {
        		check_target = 1;
        	}
        }
		if(check_target == 0) {
			return check_target;
		}
		int[] check_list = new int[words.length];
		LinkedList<Integer> que = new LinkedList<Integer>();
		LinkedList<Integer> que_count = new LinkedList<Integer>();
		bfs(begin, target, words, 0,check_list, que, que_count);
		
        return answer;
        
    }
	
	public void bfs(String cur, String target, String[] words, int count, int[] check, LinkedList<Integer> que, LinkedList<Integer> que_count) {
		{
			count++;
			for(int i=0; i<words.length; i++) {
				int dif_count =0;
				for(int j=0; j<target.length(); j++) {
					if( (check[i]==0) &&(cur.charAt(j) != words[i].charAt(j))) {
						dif_count++;
					}
				}
				if(dif_count == 1) {
					check[i] = 1;
					que.add(i);
					que_count.add(count);
					if(words[i].equals(target)) {
						answer = count;
					}
				}
			}
			
			while(!que.isEmpty()) {
				bfs(words[que.poll()], target, words, que_count.poll(), check, que, que_count);
			}
		}
	}
	
	
	public static void main(String[] args) {
		  Solution6 solution = new Solution6(); 
		  String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		  System.out.println(solution.solution("hit", "cog", words));
	 }
	 
	 

}
