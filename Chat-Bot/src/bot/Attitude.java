package bot;

public class Attitude {
	private Mood friendliness;
	
	public Mood getFriendliness() {
		return friendliness;
	}

	public Attitude() {
		friendliness = Mood.Neutral;
	}

	public void increasedFriendliness() {	
		friendliness = friendliness.increasedFriendliness();
	}

	public void decreaseFriendliness() {
		friendliness = friendliness.decreaseFriendliness();
	}
	
	public boolean isAngry() {
		return friendliness.isAngry();
	}
	
	public boolean isNeutral() {
		return friendliness.isNeutral();
	}
	
	public boolean isCheerful() {
		return friendliness.isCheerful();
	}

}