package numbers;

public class UnknowNumber {
	private int botNumber;
	private int currentMinNumber;
	private int currentMaxNumber;

	public void setBotNumber(int c) {
		if (c >= 0 || c <= 100) {
			botNumber = c;
		} else {
			throw new NumberFormatException("The number does not match the range");
		}
	}

	public int getBotNumber() {
		return botNumber;
	}

	public void setMinNumber(int c) {
		if (c >= 0 || c <= 100) {
			currentMinNumber = c;
		} else {
			throw new NumberFormatException("The number does not match the range");
		}
	}

	public int getMinNumber() {
		return currentMinNumber;
	}
	
	public void setMaxNumber(int c) {
		if (c >= 0 || c <= 100) {
			currentMaxNumber = c;
		} else {
			throw new NumberFormatException("The number does not match the range");
		}
	}

	public int getMaxNumber() {
		return currentMaxNumber;
	}

}
