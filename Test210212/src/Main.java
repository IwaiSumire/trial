import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();

		int time = (x * 3600) + (y * 60) + z;

		System.out.println(time);

		sc.close();
	}
}
