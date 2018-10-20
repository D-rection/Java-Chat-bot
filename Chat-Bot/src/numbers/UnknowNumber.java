package numbers;

public class UnknowNumber {
	private static int botNumber;
	private static int currentMinNumber;
	private static int currentMaxNumber;
	

	public static void setBotNumber(int c) {
		if (c >= 0 || c <= 100) {
			botNumber = c;
		} else {
			throw new NumberFormatException("The number does not match the range");
		}
	}

	public static int getBotNumber() {
		return botNumber;
	}

	public static void setMinNumber(int c) {
		if (c >= 0 || c <= 100) {
			currentMinNumber = c;
		} else {
			throw new NumberFormatException("The number does not match the range");
		}
	}

	public static int getMinNumber() {
		return currentMinNumber;
	}
	
	public static void setMaxNumber(int c) {
		if (c >= 0 || c <= 100) {
			currentMaxNumber = c;
		} else {
			throw new NumberFormatException("The number does not match the range");
		}
	}

	public static int getMaxNumber() {
		return currentMaxNumber;
	}

}
