
public class Order {
	private Item item;
	private int qty;//いくつ注文したか

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getTotal() {
		int result = item.getPrice() * qty;
		return result;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}


}
