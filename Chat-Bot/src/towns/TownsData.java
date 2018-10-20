package towns;

import answers.DifficultLevel;

public class TownsData {
	static private int spreadValues = 20;
	static private boolean start = true;
	static private boolean endOfGame = false;
	static private boolean isSetMaxCountCities = false;
	static private int maxCountCities;
	static private int currentCountCities;
	static private String lastCity;

	public static void reboot() {
		start = true;
		isSetMaxCountCities = false;
		endOfGame = false;
		maxCountCities = 0;
		currentCountCities = 0;
		lastCity = null;
	}

	public static void setMaxCountCities(DifficultLevel lvl) {
		if (!isSetMaxCountCities) {
			switch (lvl) {
			case Easy:
				maxCountCities = 5 + (int) (Math.random() * spreadValues);
				break;
			case Medium:
				maxCountCities = 15 + (int) (Math.random() * spreadValues);
				break;
			case Hard:
				maxCountCities = 50 + (int) (Math.random() * spreadValues);
				break;
			case Madness:
				maxCountCities = Integer.MAX_VALUE;
				break;
			}
			isSetMaxCountCities = true;
		}
	}

	static protected void firstCityWas() {
		start = false;
	}

	static protected void continueGame() {
		endOfGame = false;
	}

	static protected void endOfGame() {
		endOfGame = true;
	}

	static protected void increaseCurrentCities() {
		currentCountCities++;
	}

	static protected int getCurrentCountCities() {
		return currentCountCities;
	}

	public static int getMaxCountCities() {
		return maxCountCities;
	}

	public static boolean isEndOfGame() {
		return endOfGame;
	}

	public static boolean isStart() {
		return start;
	}

	static protected void setLastCity(String s) {
		lastCity = s;
	}

	static protected String getLastCity() {
		return lastCity;
	}
}
