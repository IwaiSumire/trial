
public class ShoppingCart {

	private Order[] orders = new Order[10];

	private int index = 0;

	public void add(Order order) {

		orders[index] = order;
		index++;
	}

	public int getTotal() {
		int total = 0;

		for (int i = 0; i < index; i++) {
			total = total + orders[i].getTotal();
		}
		return total;
	}
}
