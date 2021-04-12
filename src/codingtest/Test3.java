package codingtest;

import java.util.*;

public class Test3 {
	
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		
		int[] answer = new int [enroll.length];
		Member center = new Member("center");
		HashMap<String, Member> hash = new HashMap<String, Member>();
		for(int i=0; i<enroll.length; i++) {
			hash.put(enroll[i], new Member(enroll[i]));
		}
		for(int k=0; k<referral.length; k++) {
			Member target = hash.get(enroll[k]);
			if(referral[k].equals("-")) {
				target.boss=center;
				continue;
			}
			target.boss = hash.get(referral[k]);
		}
		
		for(int j=0; j<seller.length; j++) {
			Member target = hash.get(seller[j]);
			int money = amount[j]*100;
			target.get_money(money);
		}
		
		for(int i=0; i<enroll.length; i++) {
			answer[i] = hash.get(enroll[i]).money;
		}
		return answer;
    }
	
	

}


class Member {
	public String member;
	public Member boss = null;
	public int money = 0;
	
	Member(String member){
		this.member = member;
	}
	Member(String member, Member boss, int money){
		this.member = member;
		this.boss = boss;
		this.money = money;
	}
	public void get_money(int new_money) {
		if(this.member.equals("center")) {
			this.money += new_money;
			return;
		}
		int sending = new_money/10;
		this.money += new_money-sending;
		if(sending !=0) {
		boss.get_money(sending);
		}
	}
	
	
}
