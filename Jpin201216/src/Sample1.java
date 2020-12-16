
public class Sample1 {

	public static void main(String[] args) {

		Sample2 sample = new Sample2();

		//sample.name = "Java"; //外部のデータを変えている

		sample.setName("Java");

		sample.syaHello();


		Sample2 sample2 = new Sample2();

		//sample2.name = "hogehoge";//外部のデータを変えている

		sample2.setName("hoge");

		sample2.syaHello();
	}

}
