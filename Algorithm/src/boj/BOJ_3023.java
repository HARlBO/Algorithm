package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 마술사 이민혁 (구현)
 * https://www.acmicpc.net/problem/3023
 * 
 */
public class BOJ_3023 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] card = new char[2*N][2*M];
		
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0 ; j < M; j++) {
				card[i][j] = line.charAt(j);
				card[i][M*2-1 - j] = line.charAt(j);
				card[N*2-1 - i][j] = line.charAt(j);
				card[N*2-1 - i][M*2-1 - j] = line.charAt(j);			
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()) - 1;
		int B = Integer.parseInt(st.nextToken()) - 1;
		
		String sharp = "#";
		String dot = ".";
		
		if (card[A][B] == sharp.charAt(0)) {
			 card[A][B] = dot.charAt(0);
		} else {
			card[A][B] = sharp.charAt(0);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0 ; i < N*2; i++) {
			for (int j = 0; j < M*2; j++) {
				sb.append(card[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
