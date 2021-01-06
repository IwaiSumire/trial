
public class Order {

	private Item item;

	public Order(Item item, int qty) {
		this.item = item;
		this.qty = qty;
	}

	private int qty;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getTotal() {
		return item.getPrice() * this.qty;
	}
}
