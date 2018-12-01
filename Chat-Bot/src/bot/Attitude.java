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
	
	public boolean isAngry() {
		return (friendliness == Mood.VeryAngry || friendliness == Mood.Angry || friendliness == Mood.SomeAngry);	
	}
	
	public boolean isNeutral() {
		return (friendliness == Mood.NeutralAngry || friendliness == Mood.Neutral || friendliness == Mood.NeutralCheerful);	
	}
	
	public boolean isCheerful() {
		return (friendliness == Mood.SomeCheerful || friendliness == Mood.Cheerful || friendliness == Mood.VeryCheerful);	
	}

}