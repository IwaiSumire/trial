
public class Main {

	public static void main(String[] args) {

		List list = new List();

		list.add("A");
		list.add("B");
		list.add("C");

		hoge hoge1 = new hoge();

		hoge1.hello();//インスタンスが必要
		hoge.hello1();//インスタンス不要。staticなメソッドだから

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		hoge.num=10;//staticがついているフィールド
		System.out.println(hoge.num);//インスタンスがなくても動く

	}



}
