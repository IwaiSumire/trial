
public class School implements Place {

	@Override
	public void morning() {
		System.out.println("おっはー");
	}

	@Override
	public void night() {
		System.out.println("ばいびー");
	}

	@Override
	public void night(int x) {
		System.out.println(x);

	}



}

