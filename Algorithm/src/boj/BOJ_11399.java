package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * ATM https://www.acmicpc.net/problem/11399
 * 
 */
public class BOJ_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		int[] time = new int[N];

		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		// 대기 시간이 짧은 사람 부터 정렬 
		Arrays.sort(time);

		int result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				result += time[j];
				System.out.println(result);
			}
		}
		System.out.println(result);
	}
}
