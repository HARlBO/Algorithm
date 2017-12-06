package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 양치기 꿍 https://www.acmicpc.net/problem/3187
 * 
 */
public class BOJ_3187 {
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 울타리 배열 초기화
		int[][] fence = new int[N][M];

		for (int row = 0; row < N; row++) {
			String line2 = br.readLine();

			for (int col = 0; col < M; col++) {
				// 빈공간 : 0 | 울타리 : -1 | 양 : 1 | 늑대 : 2
				switch (line2.charAt(col) + "") {
				case ".":
					fence[row][col] = 0;
					break;
				case "#":
					fence[row][col] = -1;
					break;
				case "v":
					fence[row][col] = 2;
					break;
				case "k":
					fence[row][col] = 1;
					break;
				}
				// System.out.print(fence[row][col] + " ");
			}
			// System.out.println("\n");
		}

		br.close();

		// 방문 여부 저장 배열 초기화
		boolean[][] isVisited = new boolean[N][M];

		// 결과 받을 배열 초기화 
		int[] result = new int[2];

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				// 양, 늑대 마리 수 저장 변수
				int sheepCnt = 0, wolfCnt = 0;
				
				// 울타리가 없고, bfs를 실행하지 않은 지점일 경우
				if (fence[row][col] > -1 && !isVisited[row][col]) {
					isVisited[row][col] = true;

					if (fence[row][col] == 1) {
						sheepCnt++;
					} else if (fence[row][col] == 2) {
						wolfCnt++;
					}

					Queue<Point> queue = new LinkedList<>();
					queue.offer(new Point(row, col));

					// bfs
					while (!queue.isEmpty()) {
						Point current = queue.poll();

						for (final int[] DIRECTION : DIRECTIONS) {
							int nextRow = current.row + DIRECTION[ROW];
							int nextCol = current.col + DIRECTION[COL];

							if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M) {
								if (!isVisited[nextRow][nextCol]) {
									if (fence[nextRow][nextCol] == 1) {
										sheepCnt++;
										isVisited[nextRow][nextCol] = true;
										queue.offer(new Point(nextRow, nextCol));
									} else if (fence[nextRow][nextCol] == 2) {
										wolfCnt++;
										isVisited[nextRow][nextCol] = true;
										queue.offer(new Point(nextRow, nextCol));
									} else if (fence[nextRow][nextCol] == 0) {
										isVisited[nextRow][nextCol] = true;
										queue.offer(new Point(nextRow, nextCol));
									}
								}
							}							
						}

					}
					if (sheepCnt > wolfCnt) {
						result[0] += sheepCnt;
					} else {
						result[1] += wolfCnt;
					}
					System.out.println("@@@ " + sheepCnt + " " + wolfCnt);

				}
			}
		}

		System.out.println(result[0] + " " + result[1]);
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
