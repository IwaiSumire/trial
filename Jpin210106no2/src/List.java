
public class List {

	private String value;
	private int index;
	private List next;

	public List() {//公開コンストラクタ
		this.value = null;
		this.index = 0;
		this.next = null;
	}

	private List(int index) {//非公開コンストラクタ
		this();
		this.index = index;
	}

	public void add(String value) {
		if (this.value == null) {
			this.value = value;
			return;
		}

		if (this.next == null) {
			this.next = new List(index + 1);
		}
		this.next.add(value);

	}

	public String get(int index) {
		if (this.index == index) {
			return this.value;
		}
		if (this.next == null) {
			return null;
		}
		return this.next.get(index);
	}

	public int size() {
		if (this.next == null) {
			return this.index + 1;
		}
		return this.next.size();
	}
}
