public class Test5 {
	public static void main(String[] args) {

		//int型しか使わない配列arrayに３つのint型の集合を扱う配列を宣言
		int[] array = { 10, 20, 30, 39, 50 };

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		for (int num : array) {
			System.out.println(num);
		}
	}
}
