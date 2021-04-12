package codingtest;

import java.util.*;

public class Test2 {
	
	public int[] solution(int rows, int columns, int[][] queries) {
		int[][] table = new int[rows][columns];
		int count = 0;
		for(int x=0; x<rows; x++) {//이게 세로
			for(int y=0; y<columns; y++) {//이게 가로
				table[x][y] = count;
				count++;
			}
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int k=0; k<queries.length; k++) {
			int[] mission = queries[k];
			int a,b,c,d;
			a = mission[0] -1;
			b = mission[1] -1;
			c = mission[2] -1;
			d = mission[3] -1;
			if(a>c) {
				int temp = c;
				c = a;
				a = temp;
			}
			if(b>d) {
				int temp = d;
				d = b;
				b = temp;
			}
			int min = table[a][b];
			int temp = 0;
			int temp2=0;
			
			for(int x=b; b<d; b++) { //첫번째 행
				temp = table[a][x+1];
				table[a][x+1] = table[a][x];
				if(table[a][x+1]<min) {
					min = table[a][x];
				}
			}
			for(int y=a; y<=c; y++) { //첫번째행 마지막 열
				temp2 = table[y][b];
				table[y][b] = temp;
				temp = temp2;
				if(table[y][b]<min) {
					min = table[y][b];
				}
			}
			for(int x=d; x>=b; x--) { //마지막행 마지막 열
				temp2 = table[c][x];
				table[c][x] = temp;
				if(table[c][x]<min) {
					min = table[c][x];
				}
			}
			for(int y=c; y>=c; y--) { //첫번째행 마지막 열
				temp2 = table[y][b];
				table[y][b] = temp;
				temp = temp2;
				if(table[y][b]<min) {
					min = table[y][b];
				}
			}
			table[a][b] = temp;
			if(table[a][b]<min) {
				min = table[a][b];
			}
			que.add(min);
			
		}
		
		
        int[] answer = new int[que.size()];
        for(int i=0; i<que.size(); i++) {
        	answer[i] = que.poll();
        }
        return answer;
    }
	
	

}
