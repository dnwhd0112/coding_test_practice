package codingtest;

import java.util.*;

public class Solution23 {
	
	 public int solution(int n, int[][] edge) {
		 	HashMap<Integer,LinkedList<Integer>> hash = new HashMap<Integer,LinkedList<Integer>>();
		 	for(int i=0; i<edge.length; i++) {
		 		if(!hash.containsKey(edge[i][0])) {
		 			hash.put(edge[i][0], new LinkedList<Integer>());
		 		}
		 		if(!hash.containsKey(edge[i][1])) {
		 			hash.put(edge[i][1], new LinkedList<Integer>());
		 		}
		 		hash.get(edge[i][0]).add(edge[i][1]);
		 		hash.get(edge[i][1]).add(edge[i][0]);
		 	}
		 	boolean[] check = new boolean[n+1];
		 	check[1] = true;
		 	int answer = 0;
		 	Queue<Integer> que = new LinkedList<Integer>();
		 	Queue<Integer> temp_que = new LinkedList<Integer>();
		 	Iterator<Integer> itr = hash.get(1).iterator();
		 	while(itr.hasNext()) {
		 		int target = itr.next();
		 		check[target] = true;
		 		que.add(target);
		 	}
		 	while(!que.isEmpty()) {
		 		while(!que.isEmpty()) {
			 		int target = que.poll();
			 		check[target] = true;
			 		itr = hash.get(target).iterator();
				 	while(itr.hasNext()) {
				 		int temp = itr.next();
				 		if(check[temp]) {
				 			continue;
				 		}
				 		temp_que.add(temp);
				 		check[temp] = true;
				 	}
		 		}
		 		if(que.isEmpty()) {
		 			if(!temp_que.isEmpty()) {
			 			answer = temp_que.size();
			 			while(!temp_que.isEmpty()) {
			 				int target = temp_que.poll();
			 				que.add(target);
			 			}
			 		}
		 		}
		 	}
	        return answer;
	    }
	 
	
	
	  public static void main(String[] args) { Solution23 solution = new
	  Solution23();
	  
	  int n = 7; int[][] numbers = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4},{6,7},
	  {5, 2}}; System.out.println(solution.solution(n,numbers)); }
	 
	 
	 
	 
}
