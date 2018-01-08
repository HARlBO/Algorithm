package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 헤일스톤 수열 (DP) 
 * https://www.acmicpc.net/problem/3943
 * 
 */
public class BOJ_3943 {
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			// 시작값 n
			int n = Integer.parseInt(br.readLine());
			int max = 1;

			while (n != 1) {
				if (max <= n) {
					max = n;
				}

				if (n % 2 == 0) {
					n = n / 2;
				} else {
					n = (n * 3) + 1;
				}
			}
			sb.append(max).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}
}
