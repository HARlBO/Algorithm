package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 숫자 삼각형 (다이나믹 프로그래밍) 
 * https://www.acmicpc.net/problem/1932
 * 
 */
public class BOJ_1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] triangle = new int[N][N];
		int[][] dp = new int[N][N];

		// 삼각형 배열 초기화
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		dp[0][0] = triangle[0][0];
		int max = 0;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					// 왼쪽 끝 일 경우
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				} else if (j == i) {
					// 오른쪽 끝 일 경우
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					// 오른쪽, 왼쪽 모두 비교				
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
				}
				
				if (dp[i][j] > max) {
					// 최댓값 저장 
					max = dp[i][j];
				}
			}
		}

		System.out.println(max);
	}
}
