package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 동전 0 https://www.acmicpc.net/problem/11047
 * 
 */
public class BOJ_11047 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 동전 단위 저장 배열
		int[] coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		int quotient = 0;
		int cnt = 0;

//		for (int i = N - 1; K > 0; i--) {
//			quotient = K / coin[i];
//			K -= quotient * coin[i];
//			cnt += quotient;
//		}

		for (int i = N - 1; i >= 0; i--) {
			quotient = K / coin[i];
			K = K % coin[i];
			cnt += quotient;
		}

		System.out.println(cnt);
	}
}
