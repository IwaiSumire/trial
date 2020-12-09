public class Test4 {
	public static void main(String[] args) {

		int a = 1;

		while (a < 10) {
			System.out.println("Hello");
			a++;
			if (a % 2 == 0) {
				break; //continueがあるとそれ以降の式が全部スキップされる
			}

			//			a++;
		}
	}
}
