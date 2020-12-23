
public class Main {

	public static void main(String[] args) {

		Item item = new Item();

		item.setName("apple");
		item.setPrice(100);

		Order order = new Order();
		order.setItem(item);
		order.setQty(3);

		int result = order.getTotal();
		System.out.println(result);
	}

}
