package codingtest;

import java.util.*;

public class Test1 {
	public int[] solution(int[] lottos, int[] win_nums) {
		HashSet<Integer> win_set = new HashSet<Integer>();
		int count_0 = 0;
		int count_win = 0;
		for(int i=0; i<win_nums.length; i++) {
			win_set.add(win_nums[i]);
		}
		for(int k=0; k<lottos.length; k++) {
			int number = lottos[k];
			if(number == 0) {
				count_0++;
			}
			if(win_set.contains(number)) {
				count_win++;
			}
		}
		
		int min = 7- count_win;
		int best = 7-count_win-count_0;
		
		if(min == 7) {
			min = 6;
		}
		if(best == 7) {
			best = 6;
		}
		
        int[] answer = new int[] {best,min};
        return answer;
    }
	

}
