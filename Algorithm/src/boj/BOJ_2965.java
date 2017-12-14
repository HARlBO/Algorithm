package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 캥거루 세마리 (수학) 
 * https://www.acmicpc.net/problem/2965
 * 
 */
public class BOJ_2965 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int pos1 = Integer.parseInt(st.nextToken());
		int pos2 = Integer.parseInt(st.nextToken());
		int pos3 = Integer.parseInt(st.nextToken());
		
		int leftDis = pos2 - pos1;
		int rightDis = pos3 - pos2;
		
		System.out.println((leftDis > rightDis ? leftDis - 1 : rightDis - 1));
	}
}
