
public class RaiseTech2 {

	public static void main(String[] args) {

		Place sc = new School();
		Place of = new Ofice();


		sc.morning();
		sc.night();
		of.morning();
		of.night();

		int a = 10;
		int b = --a - --a + a + a++ + a + --a ;
		
		
		System.out.println(b);
		System.out.println(9-8+8+8+9+8);
		
		String q = "sample";
		String c = "sample";
		
		int f = 1;
		int d =1;
		
		System.out.println(q.equals(c));
		System.out.println(q == c);
		
		System.out.println(f == d);
	}

}
