package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 나이트의 이동 (BFS) 
 * https://www.acmicpc.net/problem/7562
 * 
 */
public class BOJ_7562 {
	private static final int[][] DIRECTIONS = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 },
			{ 1, -2 }, { 2, -1 } };
	private static final int X = 1;
	private static final int Y = 0;

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			int I = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int srcX = Integer.parseInt(st.nextToken());
			int srcY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			int desX = Integer.parseInt(st.nextToken());
			int desY = Integer.parseInt(st.nextToken());

			Point src = new Point(srcX, srcY);
			Point des = new Point(desX, desY);

			int[][] isVisited = new int[I][I];
			isVisited[srcX][srcY] = 1;

			Queue<Point> queue = new LinkedList<>();
			queue.offer(src);

			int knite = 0;

			while (!queue.isEmpty()) {
				Point current = queue.poll();
				knite++;
				if (current.x == des.x && current.y == des.y) {
					break;
				}

				for (final int[] DIRECTION : DIRECTIONS) {
					int nextX = current.x + DIRECTION[X];
					int nextY = current.y + DIRECTION[Y];

					if (0 <= nextX && nextX < I && 0 <= nextY && nextY < I) {
						if (isVisited[nextX][nextY] == 0) {							
							isVisited[nextX][nextY] = isVisited[current.x][current.y] + 1;
							queue.offer(new Point(nextX, nextY));
						}
					}
				}
			}

			sb.append(isVisited[des.x][des.y] - 1).append("\n");
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
