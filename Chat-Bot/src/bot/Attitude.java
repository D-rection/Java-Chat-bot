package bot;

public class Attitude {
	private Mood friendliness;

	public Attitude() {
		friendliness = Mood.Neutral;
	}

	public void increasedFriendliness() {
		if (friendliness != Mood.VeryCheerful)
			friendliness = Mood.values()[friendliness.ordinal() + 1];
	}

	public void decreaseFriendliness() {
		if (friendliness != Mood.VeryAngry)
			friendliness = Mood.values()[friendliness.ordinal() - 1];
	}

	public Mood getFriendliness() {
		return friendliness;
	}

}