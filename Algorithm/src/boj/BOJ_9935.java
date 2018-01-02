package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 문자열 폭발 (문자열) 
 * https://www.acmicpc.net/problem/9935
 * 
 */
public class BOJ_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String bomb = br.readLine();

		String word = line;

		for (int i = 0; i < bomb.length(); i++) {
			word = word.replaceAll(String.valueOf(bomb.charAt(i)), "");
		}
		
		if (word.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(word);
		}
	}
}
