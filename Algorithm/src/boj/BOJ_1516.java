package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 게임 개발 (위상정렬) https://www.acmicpc.net/problem/1516
 * 
 */
public class BOJ_1516 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] list = new ArrayList[N];
		int[] time = new int[N];
		int[] result = new int[N];
		int[] degree = new int[N];

		Arrays.fill(time, 0);
		Arrays.fill(degree, 0);
		Arrays.fill(result, 0);

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			boolean fin = true;

			while (fin) {
				int next = Integer.parseInt(st.nextToken());

				if (next != -1) {
					degree[i]++;
					list[next - 1].add(i);
				} else {
					fin = false;
				}
			}

			// 차수가 0 (들어오는 간선이 없는) 인 정점 큐에 넣고
			// 건물을 짓는 시간 = 건물을 완성하는 시간
			if (degree[i] == 0) {
				result[i] = time[i];
				queue.offer(i);
			}
		}

		// 위상 정렬
		for (int i = 0; i < N; i++) {
			int current = queue.poll();

			for (int next : list[current]) {
				// 최소 건설 완료 시간 갱신
				result[next] = Math.max(result[next], result[current] + time[next]);
				// 간선을 삭제하여 next의 차수가 0이 되면 next도 큐에 넣음
				if (--degree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append("\n");
		}

		System.out.println(sb.toString());
	}
}
