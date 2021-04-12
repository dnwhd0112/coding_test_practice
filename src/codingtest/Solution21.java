package codingtest;

public class Solution21 {
	public int solution(int[] money) {
        
		int[] copy_money = money.clone();
		
		//1번째 를 사용했을때
		money[1] = Math.max(money[0],money[1]);
		money[2] += money[0];
		
		for(int i =3; i<money.length-1; i++) {
			money[i] += Math.max(money[i-3], money[i-2]);
		}
		int answer1 = Math.max(money[money.length-3], money[money.length-2]);
		
		//마지막을 사용했을때 (1번째 사용안할때)
		copy_money[0] = 0;
		for(int i=3; i<copy_money.length; i++) {
			copy_money[i] += Math.max(copy_money[i-3], copy_money[i-2]);
		}
		int answer2 = Math.max(copy_money[copy_money.length-1], copy_money[copy_money.length-2]);
		
        return Math.max(answer1, answer2);
    }
	
}
