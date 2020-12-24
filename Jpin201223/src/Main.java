
public class Main {

	public static void main(String[] args) {

		/*インスタンスの生成
		スタック領域：100番地にitemという名前をつける
		ヒープ領域：200番地にあるnameとpriceに"aple"と"100"を入れる*/
		Item item = new Item();

		item.setName("apple");
		item.setPrice(100);

		/*インスタンスの生成
		スタック領域：101番地にorderという名前をつける
		ヒープ領域：200番地にあるitemとqtyに"item"と"100"を入れる*/
		Order order = new Order();
		order.setItem(item);
		order.setQty(3);

		int result = order.getTotal();
		System.out.println(result);
	}

}
