package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 
 * 회의실 배정 https://www.acmicpc.net/problem/1931
 * 
 */
public class BOJ_1931 {
	
	public static class Compare implements Comparator<Time> {
		@Override
		public int compare(Time t1, Time t2) {
			// 끝나는 시간 기준으로 오름차순 정렬
			return Integer.compare(t1.endTime, t2.endTime);
		}
	}
	
	public static void main(String args[]) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());			
		Time[] timeArr = new Time[N];
		
		for (int i = 0; i < N; i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			timeArr[i] = new Time(str, end);
		}
		
		// 끝나는 시간 기준으로 정렬 
		Compare cmp = new Compare();
		Arrays.sort(timeArr, cmp);
				
		int cnt = 1;
		int idx = 0;
		
		for (int i = 0; i < timeArr.length; i++){
			if (timeArr[idx].endTime <= timeArr[i].strTime) {
				idx = i;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static class Time {
		int strTime;
		int endTime;
		
		public Time(int s, int e) {
			this.strTime = s;
			this.endTime = e;
		}
	}
}
