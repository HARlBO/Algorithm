package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 유기농 배추 (BFS) 
 * https://www.acmicpc.net/problem/1012
 * 
 */
public class BOJ_1012 {
	private static final char NEW_LINE = '\n';

	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	// 방향 행, 열 상수
	private static final int X = 1;
	private static final int Y = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			boolean[][] isExist = new boolean[N][M];

			while (K-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				isExist[y][x] = true;
			}

			boolean[][] isVisited = new boolean[N][M];

			Queue<Point> queue = new LinkedList<>();

			int areaNum = 0;

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (isExist[y][x] && !isVisited[y][x]) {
						areaNum++;

						queue.offer(new Point(x, y));

						while (!queue.isEmpty()) {
							Point current = queue.poll();

							for (final int[] DIRECTION : DIRECTIONS) {
								int nextY = current.y + DIRECTION[Y];
								int nextX = current.x + DIRECTION[X];

								if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
									if (isExist[nextY][nextX] && !isVisited[nextY][nextX]) {
										isVisited[nextY][nextX] = true;
										queue.offer(new Point(nextX, nextY));
									}
								}
							}
						}
					}
				}
			}

			sb.append(areaNum).append(NEW_LINE);
		}

		br.close();

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
