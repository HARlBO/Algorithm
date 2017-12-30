package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * DFS와 BFS (DFS,BFS) 
 * https://www.acmicpc.net/problem/1260
 * 
 */
public class BOJ_1260 {
	private static boolean[] isVisited = new boolean[1001];
	private static int[][] matrix = new int[1001][1001];
	private static StringBuilder sb = new StringBuilder();
	private static int N = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N 노드 개수 | M 간선 개수 | V 탐색 시작 정
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
				
			matrix[r][c] = matrix[c][r] = 1;
		}
		
		br.close();
		
		dfs(V);
		sb.append("\n");
		Arrays.fill(isVisited, false);
		bfs(V);

		System.out.println(sb.toString());
	}
	
	private static void dfs(int u) {
		sb.append(u).append(" ");
		isVisited[u] = true;

		for (int v = 1; v <= N; v++) {
			if (!isVisited[v] && matrix[u][v] == 1) {
				dfs(v);
			}
		}
	}
	
	private static void bfs(int u) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(u);

		while (!queue.isEmpty()) {
			u = queue.poll();
			sb.append(u).append(" ");
			isVisited[u] = true;

			for (int v = 1; v <= N; v++) {
				if (!isVisited[v] && matrix[u][v] == 1) {
					isVisited[v] = true;
					queue.offer(v);
				}
			}
		}
	}
}
