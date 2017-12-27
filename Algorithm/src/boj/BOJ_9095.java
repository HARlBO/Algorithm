package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 1, 2, 3 더하기 (DP)
 * https://www.acmicpc.net/problem/9095
 * 
 */
public class BOJ_9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[11];
		
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for (int i = 4; i < dp.length; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			sb.append(dp[n]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
