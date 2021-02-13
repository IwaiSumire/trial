package pack2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int count = 0;

		int n = sc.nextInt();

		if (n % 100 > 1) {

			count = -1;

		} else if (n >= 500) {

			count = n / 500;

			if (n - (500 * count) >= 100) {

				int s = n - count * 500;

				count = count + (s / 100);

			}

		}

		System.out.println(count);

		sc.close();
	}

}
