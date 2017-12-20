package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * 일곱 난쟁이 (브루트 포스)
 * https://www.acmicpc.net/problem/2309
 * 
 */
public class BOJ_2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];
		int sum = 0;
		
		for (int i = 0 ; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}
		
		br.close();
		
		Arrays.sort(dwarf);
		
		int diff = sum - 100;
		
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if (dwarf[i] + dwarf[j] == diff) {
					dwarf[i] = 0;
					dwarf[j] = 0;

					break;
				}
			}
			if (dwarf[i] == 0) {
				break;
			}
		}
	
		for (int i = 0; i < 9; i++) {
			if (dwarf[i] != 0) {
				System.out.println(dwarf[i]);
			}
		}
	}
}
