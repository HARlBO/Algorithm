package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 팰린드롬인지 확인하기 (문자열)
 * https://www.acmicpc.net/problem/10988
 * 
 */
public class BOJ_10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		String reverseWord = sb.append(word).reverse().toString();
		System.out.println(word + " " + reverseWord);
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != reverseWord.charAt(i)) {
				System.out.println("0");
				
				break;
			} 
			
			if (i == word.length() - 1) {
				System.out.println("1");
			}			
		}
	}
}
