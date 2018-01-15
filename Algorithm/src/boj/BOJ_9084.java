package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 동전 (DP) 
 * https://www.acmicpc.net/problem/9084
 * 
 */
public class BOJ_9084 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int[] coin = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());

			int[] dp = new int[M + 1];

			dp[0] = 1;

			for (int i = 1; i <= N; i++) {
				for (int j = coin[i]; j <= M; j++) {
					dp[j] += dp[j - coin[i]];
				}
			}
			sb.append(dp[M]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
