package pack3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*	反転したnはNより大きいか？ではなく
			N以下のnを反転して行ったとき、nを反転したn'はnより大きいものを数を数える。
			ここが理解できず、時間が掛かりました。

			*/

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int n;

		int count = 0;

		for (; N > 0; N--) {

			n = N;

			if (n > 9) {

				String s = String.valueOf(n);

				StringBuilder strb = new StringBuilder(s);
				String reverse = strb.reverse().toString();

				int reReverse = Integer.parseInt(reverse);

				if (n < reReverse) {

					count++;
				}
			}

			sc.close();
		}

		System.out.println(count);

	}
}