package bot;

public class InputData {
	public Attitude currentAttitude;
	public String textMessage;

	public InputData(Attitude a, String s) {
		currentAttitude = a;
		textMessage = s;
	}
}
