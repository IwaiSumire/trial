public class Ofice implements Place {

	@Override
	public void morning() {
		System.out.println("おはようございます");
	}

	@Override
	public void night() {
		System.out.println("お疲れ様でした");
	}

	@Override
	public void night(int x) {
		try {
			check();

		} catch (Exception e) {
			System.out.println(e + "ゼロで割れません");
		}

	}

	private void check() {
		int y = 60;
		int b = y / 0;
		System.out.println(b);
	}

}
