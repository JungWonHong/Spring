package ex8_19_interface_Multiple_inheritance;

//외형 변경 인터페이스를 구현하는 라벨 클래스
public class Label implements Changeable {
	String text;
	int width, height;
	String foreground, background;
	String font;

	Label(String text, int width, int height, String foreground, String background, String font) {
		this.text = text;
		this.width = width;
		this.height = height;
		this.foreground = foreground;
		this.background = background;
		this.font = font;
	}

	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void setForeground(String color) {
		this.foreground = color;
	}

	public void setBackground(String color) {
		this.background = color;
	}

	public void setFont(String font) {
		this.font = font;
	}
}
