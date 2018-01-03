package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 
 * 붕어빵 판매하기 (DP)
 * https://www.acmicpc.net/problem/11052
 * 
 */
public class BOJ_11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] price = new int[N+1];
		int[] dp = new int[N+1];
			
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N+1; i++) {			
			price[i] = Integer.parseInt(st.nextToken());
		}
	
		dp[0] = 0 ;
		
		for (int i = 1; i <= N; i++) {
			dp[i] = 0;
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + price[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
