package bot;

public class AnswerData {
	private String answer;
	private boolean saveTheme;

	public AnswerData(String a, boolean b) {
		answer = a;
		saveTheme = b;
	}

	public String getAnswer() {
		return answer;
	}

	public boolean saveTheme() {
		return saveTheme;
	}
}
