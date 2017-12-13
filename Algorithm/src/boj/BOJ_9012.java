package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * 괄호 https://www.acmicpc.net/problem/9012
 * 
 */
public class BOJ_9012 {
	private final static String NEW_LINE = "\n";
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<Character>();
			char[] parenthesis = br.readLine().toCharArray();
			boolean result = true;
			
			for (char p : parenthesis) {
				if (p == '(') {
					stack.push(p);
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
					} else {
						result = false;
					}
				}
			}			
			
			if (result) {
				if (!stack.isEmpty()) {
					sb.append("NO").append(NEW_LINE);
				} else {
					sb.append("YES").append(NEW_LINE);
				}
			} else {
				sb.append("NO").append(NEW_LINE);
			}
						
		}
		
		br.close();
		
		System.out.println(sb.toString());
	}
}
