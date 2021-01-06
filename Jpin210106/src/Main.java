public class Main {

	public static void main(String[] args) {

		int[] array = new int[3];

		array[0] = 10;
		array[1] = 20;
		array[2] = 30;

		int[] array2 = array;

		array2[0] = 100;

		for (int i : array) {
			System.out.println(i);
		}

	}

}
