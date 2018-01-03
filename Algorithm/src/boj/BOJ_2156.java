package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 포도주 시식 (DP)
 * https://www.acmicpc.net/problem/2156
 * 
 */
public class BOJ_2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] wine = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solve(wine, dp, N));
	}
	
	public static int solve(int[] wine, int[] dp, int N) {
		if (N < 1) {
			return 0;
		} else if (N == 1) {
			return wine[1];
		} else if (N == 2) {
			return wine[1] + wine[2];
		}
		
		if (dp[N] > 0) {
			return dp[N];
		}
		
		dp[N] = Math.max(Math.max(solve(wine, dp, N-1), solve(wine, dp, N-2) + wine[N]), solve(wine, dp, N-3) + wine[N-1] + wine[N]);
		
		return dp[N];
	}
}
