package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 문자열 반복 (문자열) 
 * https://www.acmicpc.net/problem/2675
 * 
 */
public class BOJ_2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();

			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < R; j++) {
					sb.append(S.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
