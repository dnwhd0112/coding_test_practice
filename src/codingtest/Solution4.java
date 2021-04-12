package codingtest;

public class Solution4 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer += calculate(numbers[0], numbers, target, 1 );
        answer += calculate(-numbers[0], numbers, target, 1 );
        return answer;
    }
    
    public int calculate(int prev, int[] numbers, int target, int index) {
    	
    	if(index >= numbers.length) {
    		if(target == prev) {
    			return 1;
    		}else {
    			return 0;
    		}
    	}
    	int cur = prev + numbers[index];
    	int cur2 = prev - numbers[index];
    	
    	int ans = 0;
    	ans += calculate(cur, numbers, target, index+1);
    	ans += calculate(cur2, numbers, target, index+1);
    	
    	return ans;
    }
}
