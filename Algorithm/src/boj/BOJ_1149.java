package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * RGB 거리 (DP)
 * https://www.acmicpc.net/problem/1149
 * 
 */
public class BOJ_1149 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N][3];
		int[][] dp = new int[N][3];
		
		// dp 배열 초기화
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = rgb[0][0];
		dp[0][1] = rgb[0][1];
		dp[0][2] = rgb[0][2];
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = rgb[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = rgb[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = rgb[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}
}
