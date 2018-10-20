package bot;

public class Attitude {
	private byte friendliness;

	public Attitude() {
		friendliness = 5;
	}

	public void increasedFriendliness() {
		if (friendliness < 9)
			friendliness++;
	}

	public void decreaseFriendliness() {
		if (friendliness > 1)
			friendliness--;
	}

	public byte getByteFriendliness() {
		return friendliness;
	}

	public Mood getFriendliness() {
		if (friendliness < 4)
			return Mood.Angry;
		else if (friendliness < 7)
			return Mood.Neutral;
		else
			return Mood.Cheerful;
	}

}