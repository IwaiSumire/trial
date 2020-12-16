
public class Sample2 {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void syaHello() { //使われる側
		System.out.println("Hello" + name);
	}

}
