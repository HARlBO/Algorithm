package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 만취한 상범 (DP) 
 * https://www.acmicpc.net/problem/6359
 * 
 */
public class BOJ_6359 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append((int)Math.sqrt(n)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
