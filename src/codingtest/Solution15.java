package codingtest;

import java.util.*;

public class Solution15 {

	public int solution(int[][] jobs) {
		int time=0;
		int total_time=0;
		PriorityQueue<Disk> queue = new PriorityQueue<Disk>();
		LinkedList<Disk> list = new LinkedList<Disk>();
		for(int i=0; i<jobs.length; i++) {
			list.add(new Disk(jobs[i][0],jobs[i][1]));
		}
		Collections.sort(list);
		
		while(true) {
			//추가
			while(!list.isEmpty() && list.peek().start<=time) {
				Disk target = list.pop();
				target.order_by_time = false;
				queue.add(target);
				if(list.isEmpty()) {
					break;
				}
			}
			if(queue.isEmpty()) {
				Disk target = list.pop();
				target.order_by_time = false;
				time = target.start;
				queue.add(target);
			}
			
			//디스크 진행
			if(!queue.isEmpty()) {
				Disk target = queue.poll();
				time += target.duration;
				total_time += time - target.start;
			}
			if(queue.isEmpty() && list.isEmpty()) {
				return total_time/jobs.length;
			}
		}
    }
	
	public class Disk implements Comparable<Disk> {
		
		boolean order_by_time = true;
		int start;
		int duration;
		
		Disk(int start, int duration){
			this.start = start;
			this.duration = duration;
		}
		
		@Override
		public int compareTo(Disk d) {
			if(order_by_time == true) {
				if(this.start > d.start) {
					return 1;
				}else {
					return -1;
				}
			}else if(this.duration> d.duration) {
				return 1;
			}else {
				return -1;
			}
		}
		
	}
	
	
	
	  public static void main(String[] args) { Solution15 solution = new
	  Solution15(); int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
	  System.out.println(solution.solution(jobs)); }
	 
	
	
	
}

