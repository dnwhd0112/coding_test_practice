package codingtest;

import java.util.*;
import java.util.Queue;

class Solution2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int index =0;
        int remain_weight = weight;
    	Queue<Truck> trucks = new LinkedList<Truck>();
    	while(index < truck_weights.length) {
    		if(remain_weight >= truck_weights[index]) { //새로운 트럭이 다리를 지나는 경우
    			time++;
    			trucks.add(new Truck(truck_weights[index],time-1+bridge_length));
    			remain_weight = remain_weight - truck_weights[index];
    			index++;
    			if(trucks.peek().end_time == time) {
        			Truck out_truck = trucks.poll();
    				remain_weight = remain_weight+out_truck.weight;
    			}
    		}else {
    			Truck out_truck = trucks.poll();
    			time = out_truck.end_time;
    			remain_weight = remain_weight+out_truck.weight;
    		}
    		
    	}
    	while(!trucks.isEmpty()) {
    		time = trucks.poll().end_time + 1;
    	}
        
        
        return time;
    }
	/*
	 * public static void main(String[] args) { Solution2 solution = new
	 * Solution2(); int bridge_length =100; int weight =100; int[] truck_weights =
	 * {10,10,10,10,10,10,10,10,10,10};
	 * 
	 * System.out.println(solution.solution(bridge_length,weight, truck_weights));
	 * 
	 * }
	 */
    
}

class Truck{
	public int weight;
	public int end_time;
	
	Truck(int weight, int end_time){
		this.weight = weight;
		this.end_time = end_time;
	}
	
	
}
