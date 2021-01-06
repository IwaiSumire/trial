public class Main {

	public static void main(String[] args) {

		Item item = new Item("ばなな", 100);
		Item item2 = new Item("りんご", 300);

		Order order = new Order(item, 3);
		Order order2 = new Order(item2, 5);

		ShoppingCart cart = new ShoppingCart();

		cart.add(order);
		cart.add(order2);

		int total = cart.getTotal();

		System.out.println(item.getName());
		System.out.println(item.getPrice());
		System.out.println(order.getQty());

		System.out.println(item2.getName());
		System.out.println(item2.getPrice());
		System.out.println(order2.getQty());

		System.out.println("合計" + total);

	}

}
