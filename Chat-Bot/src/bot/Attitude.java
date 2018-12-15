package bot;

public class Attitude {
	private Mood friendliness;
	
	public synchronized Mood getFriendliness() {
		return friendliness;
	}

	public Attitude() {
		friendliness = Mood.Neutral;
	}

	public synchronized void increasedFriendliness() {
		friendliness = friendliness.increasedFriendliness();
	}

	public synchronized void decreaseFriendliness() {
		friendliness = friendliness.decreaseFriendliness();
	}
	
	public synchronized boolean isAngry() {
		return friendliness.isAngry();
	}
	
	public synchronized boolean isNeutral() {
		return friendliness.isNeutral();
	}
	
	public synchronized boolean isCheerful() {
		return friendliness.isCheerful();
	}

}