package codingtest;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	HashMap<String,Integer> music_total = new HashMap<String,Integer>();
    	HashMap<String,Max_values> music_max = new HashMap<String,Max_values>();
    	
    	for(int i=0; i<genres.length;i++) {
    		if(music_total.containsKey(genres[i])){
    			music_total.replace(genres[i], music_total.get(genres[i]) + plays[i]);
    		}else {
    			music_total.put(genres[i], plays[i]);    			
    		}
    		if(music_max.containsKey(genres[i])){
    			music_max.get(genres[i]).add_max(plays[i],i);
    		}else {
    			music_max.put(genres[i], new Max_values(plays[i],i));
    		}
    	}
    	//map을 정렬 시키는 부분
        List<String> keySetList = new ArrayList<>(music_total.keySet());
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return music_total.get(o2).compareTo(music_total.get(o1));
            }
        });
        //여기까지
    	ArrayList<Integer> answer_list = new ArrayList<Integer>();
    	for(String key : keySetList) {
    		answer_list.add(music_max.get(key).key1);
    		if(music_max.get(key).key2 != -1) {
    			answer_list.add(music_max.get(key).key2);
    		}
    	}
    	
        int[] answer = ArrayList_to_array(answer_list);
        return answer;
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
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    	int[] plays = {500, 600, 150, 800, 2500};
    	solution.solution(genres,plays);
    	
    }
    
   
    
}

class Max_values{
	public int max1 = 0;
	public int max2 = 0;
	public int key1 = -1;
	public int key2 = -1;
	
	Max_values(int max1, int key1){
		this.max1 = max1;
		this.key1 = key1;
	}
	Max_values(int max1, int max2, int key1, int key2){
		this.max1 = max1;
		this.key1 = key1;
		this.max2 = max2;
		this.key2 = key2;
	}
	
	public void add_max(int a, int key) {
		if(a>max1) {
			max2 = max1;
			max1 = a;
			key2 = key1;
			key1 = key;
		}
		else if(a>max2) {
			max2=a;
			key2 = key;
		}
	}
}
