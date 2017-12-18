package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 열혈강호 (이분매칭) 
 * https://www.acmicpc.net/problem/11375
 * 
 */
public class BOJ_11375 {
	private static int N;
	private static int M;
	
	private static boolean[] isVisited;
	private static ArrayList<Integer>[] list;
	private static int[] aMatch, bMatch;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// N : 직원의 수 | M : 일의 개수 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// A[i] 와 인접한 그룹 B의 정점
		list = new ArrayList[N + 1];

		// 각 정점이 매칭 된 반대편 정점 번호 배열
		aMatch = new int[N+1];
		bMatch = new int[M+1];
		
		// 방문 여부 저장 배열 
		isVisited = new boolean[N + 1];
		
		// list, isVisited, aMatch, bMatch 초기화 
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(isVisited, false);
		Arrays.fill(aMatch, -1);
		Arrays.fill(bMatch, -1);
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			for (int j = 0; j < S; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));	
				System.out.print(list[i]);
			}
			System.out.println("\n");
		}
		
		// 결과 저장 변수 
		int result = 0;
		
		for (int i = 1; i <= N; i++) {
			// 아직 매칭 되지 않은 그룹 A 정점에 대해 매칭 시도
			if (aMatch[i] == -1) {
				Arrays.fill(isVisited, false);
				if (dfs(i)) {
					result++;				
				}
			}		
		}

		System.out.println(result);
	}
	
	private static boolean dfs(int a) {
		isVisited[a] = true;
		for (int b: list[a]) {
			// 반대편이 매칭 되지 않았거나
			// 매칭되어 있었지만 원래 매칭되어 있던 정점을 다른 정점과 매칭 시킬 수 있으면 
			if(bMatch[b] == -1 || !isVisited[bMatch[b]] && dfs(bMatch[b])) {
				aMatch[a] = b;
				bMatch[b] = a;
	
				return true;
			}
		}
		return false;
	}
}
