package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 미로 탐색 https://www.acmicpc.net/problem/2178
 * 
 */
public class BOJ_2178 {
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 미로 배열 초기화
		int[][] maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}

		br.close();

		// 방문 여부 저장 배열
		int[][] isVisited = new int[N][M];
		isVisited[0][0] = 1;

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));

		// bfs
		while (!queue.isEmpty()) {
			Point current = queue.poll();

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = current.row + DIRECTION[ROW];
				int nextCol = current.col + DIRECTION[COL];

				if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M) {
					if (maze[nextRow][nextCol] == 1 && isVisited[nextRow][nextCol] == 0){
						isVisited[nextRow][nextCol] = isVisited[current.row][current.col] + 1;
						queue.offer(new Point(nextRow, nextCol));
					}
				}
			}
		}

		System.out.println(isVisited[N -1][M -1]);
		}

	private static class Point {
		public int row;
		public int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
