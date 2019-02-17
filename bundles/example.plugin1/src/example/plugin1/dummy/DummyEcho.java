package example.plugin1.dummy;

public class DummyEcho {
	
	private String text;

	public DummyEcho(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
