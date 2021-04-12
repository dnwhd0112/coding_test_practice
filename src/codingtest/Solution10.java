package codingtest;

import java.util.*;

class Solution10 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        int people1_correct = people1(answers);
        int people2_correct = people2(answers);
        int people3_correct = people3(answers);
        int max = Math.max(people3_correct, Math.max(people1_correct, people2_correct));
        if(people1_correct == max) {
        	list.add(1);
        }
        if(people2_correct == max) {
        	list.add(2);
        }
        if(people3_correct == max) {
        	list.add(3);
        }
       answer = ArrayList_to_array(list);
        return answer;
    }
    
    
    public int people1(int[] answers){
    	int count =0;
    	int num = 0;
    	for(int i=0; i<answers.length; i++) {
    		num = (num)%5+1;
    		if(answers[i] == num) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public int people2(int[] answers){
    	int count =0;
    	int num = 0;
    	int num_2 = 0;
    	for(int i=0; i<answers.length; i++) {
    		if(i%2==0) {
    			num = 2;
    		}else {
    			num_2 = (num_2)%5+1;
	    		if(num_2 == 2) {
	    			num_2 = 3;
	    		}
	    		num = num_2;
    		}
    		if(answers[i] == num) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public int people3(int[] answers){
    	int[] pattern = {3,3,1,1,2,2,4,4,5,5};
    	int num = pattern[0];
    	int count =0;
    	for(int i=0; i<answers.length; i++) {
    		num = pattern[i%pattern.length];
    		if(answers[i] == num) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public int[] ArrayList_to_array(ArrayList<Integer> list){
        int[] answer= {};

        answer = new int[list.size()];
          int cursur = 0;
          while(cursur < list.size()) {
             answer[cursur] = list.get(cursur);
             System.out.println(list.get(cursur));
             cursur++;
          }
          return answer;        
     }
    
    
}
	
