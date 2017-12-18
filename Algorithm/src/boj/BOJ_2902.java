package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * KMP는 왜 KMP일까?
 * https://www.acmicpc.net/problem/2902
 * 
 * 
 * Knuth-Morris-Pratt
 * 
 */
public class BOJ_2902 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] name = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < name.length; i++) {
			if(Character.isUpperCase(name[i])) {
				sb.append(name[i]);
			}
		}

		System.out.println(sb.toString());
	}
}
