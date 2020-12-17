package baekjoon.no2771;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17135_캐슬디펜스 {

	static int[] combination;
	static int N, M, D, max;
	static Coord[][] range;
	static int[][] map, field;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		combination = new int[3];

		map = new int[N + 1][M];
		field = new int[N + 1][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j=0; j<M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		range = new Coord[D + 1][];

		for (int i=1; i<=D; i++) {
			range[i] = new Coord[2*i-1];
			for (int j=0; j<2*i-1; j++) {
				int dr = (int) -(-Math.abs(j-i+1)+i);
				int dc = j-i+1;

				range[i][j] = new Coord(dr, dc);
			}
		}
		genComb(0, 0);
		System.out.println(max);
	}
	static void genComb(int index, int cnt) {
		if (cnt>M) return;
		
		if (index>2) {
			init();
			int count = defense();
			if(count > max) max = count;
			return;
		}
		combination[index] = cnt;
		genComb(index + 1, cnt + 1);
		genComb(index, cnt + 1);
	}
	static int defense() {
		int count=0;
		for (int k=N; k>=1; k--) {
			for (int p=0; p<3; p++) {
				L: for (int i=1; i<range.length; i++) {
					for (int j=0; j<range[i].length; j++) {
						int row = combination[p] + range[i][j].row;
						int col = k + range[i][j].col;
						if (row>=N || row<0 || col>=M || col<0)
							continue;
						int target = map[row][col];
						if (target == 0)
							continue;

						if (target==1) {
							map[row][col]++;
							count++;
							break L;
						} else {
							map[row][col]++;
							break L;
						}
					}
				}
			}
			for(int i=0; i<N ;i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] > 1) map[i][j] = 0;
				}
			}
		}
		return count;
	}
	static void init() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = field[i][j];
			}
		}
	}
}
class Coord {
	int row, col;
	Coord(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
