package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 영역 구하기 (BFS)
 * https://www.acmicpc.net/problem/2583
 * 
 */
public class BOJ_2583 {
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int X = 1;
	private static final int Y = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[][] area = new boolean[N][M];
		
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());
			
			for (int i = leftY; i < rightY; i++) {
				for (int j = leftX; j < rightX; j++) {
					area[i][j] = true;
				}
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		
		int areaCnt = 0;
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if(!area[x][y]) {
					queue.offer(new Point(x,y));
					areaCnt++;
					int size = 0;
					
					while (!queue.isEmpty()) {
						Point current = queue.poll();
						area[x][y] = true;
						
						size++;
						
						for (final int[] DIRECTION : DIRECTIONS) {
							int nextX = current.x + DIRECTION[X];
							int nextY = current.y + DIRECTION[Y];
							
							if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
								if (!area[nextX][nextY]) {
									area[nextX][nextY] = true;
									queue.offer(new Point(nextX, nextY));
								}
							}
						}
					}
					result.add(size);
				}
			}
		}
		
		Collections.sort(result);
		
		StringBuilder sb = new StringBuilder();
		sb.append(areaCnt).append("\n");
		
		for (int size : result) {
			sb.append(size).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	private static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
