package bot;

import java.util.ArrayList;

public class InputData {
	public Attitude currentAttitude;
	public String textMessage;
	public ArrayList<String> log = new ArrayList<String>();

	public InputData(Attitude a, String s) {
		currentAttitude = a;
		textMessage = s;
	}
	
	public InputData(Attitude a, String s, ArrayList<String> inputLog) {
		currentAttitude = a;
		textMessage = s;
		if (inputLog != null)
			log = (ArrayList<String>) inputLog.clone();
		else
			log = null;
	}
}
