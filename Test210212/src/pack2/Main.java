package pack2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = 0;

		int n = sc.nextInt();

		if (n % 100 > 1) {

			a = -1;

		} else if (n >= 500) {

			a = n / 500;

			if (n - (500 * a) >= 100) {

				int s = n - a * 500;

				a = a + (s / 100);

			}

		}

		System.out.println(a);

		sc.close();
	}

}
