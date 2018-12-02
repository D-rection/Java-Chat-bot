package bot;

public class Attitude {
	private Mood friendliness;

	public Attitude() {
		friendliness = Mood.Neutral;
	}

	public void increasedFriendliness() {
		if (friendliness != Mood.VeryCheerful)
			friendliness = Mood.values()[friendliness.ordinal() + 1];

		//TODO Так добавьте в enum уже эти методы!
	}

	public void decreaseFriendliness() {
		if (friendliness != Mood.VeryAngry)
			friendliness = Mood.values()[friendliness.ordinal() - 1];

		//TODO Так добавьте в enum уже эти методы!
	}

	public Mood getFriendliness() {
		return friendliness;
	}
	
	public boolean isAngry() {

		//TODO Так добавьте в enum уже эти методы!
		return (friendliness == Mood.VeryAngry || friendliness == Mood.Angry || friendliness == Mood.SomeAngry);	
	}
	
	public boolean isNeutral() {

		//TODO Так добавьте в enum уже эти методы!
		return (friendliness == Mood.NeutralAngry || friendliness == Mood.Neutral || friendliness == Mood.NeutralCheerful);	
	}
	
	public boolean isCheerful() {

		//TODO Так добавьте в enum уже эти методы!
		return (friendliness == Mood.SomeCheerful || friendliness == Mood.Cheerful || friendliness == Mood.VeryCheerful);	
	}

}