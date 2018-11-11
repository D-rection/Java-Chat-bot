package towns;

import answers.DifficultLevel;

//TODO Разберитесь с модификаторами у методов(почему они protected?!)
public class TownsData {
	private int spreadValues = 20;
	private boolean start = true;
	private boolean endOfGame = false;
	private boolean isSetMaxCountCities = false;
	private int maxCountCities;
	private int currentCountCities;
	private String lastCity;

	public void reboot() {
		start = true;
		isSetMaxCountCities = false;
		endOfGame = false;
		maxCountCities = 0;
		currentCountCities = 0;
		lastCity = null;
	}

	public void setMaxCountCities(DifficultLevel lvl) {
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

	protected void firstCityWas() {
		start = false;
	}

	protected void continueGame() {
		endOfGame = false;
	}

	protected void endOfGame() {
		endOfGame = true;
	}

	protected void increaseCurrentCities() {
		currentCountCities++;
	}

	protected int getCurrentCountCities() {
		return currentCountCities;
	}

	public int getMaxCountCities() {
		return maxCountCities;
	}

	public boolean isEndOfGame() {
		return endOfGame;
	}

	public boolean isStart() {
		return start;
	}

	protected void setLastCity(String s) {
		lastCity = s;
	}

	protected String getLastCity() {
		return lastCity;
	}
}
