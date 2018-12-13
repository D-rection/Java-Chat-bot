package bot;

public enum Mood {
	VeryAngry, Angry, SomeAngry, NeutralAngry, Neutral, NeutralCheerful, SomeCheerful, Cheerful, VeryCheerful;
	
	public Mood increasedFriendliness() {	
		if (this != VeryCheerful)
			return values()[this.ordinal() + 1];
		return this;
	}
	
	public Mood decreaseFriendliness() {
		if (this != VeryAngry)
			return values()[this.ordinal() - 1];
		return this;
	}
	
	public boolean isAngry() {
		return (this == VeryAngry || this == Angry || this == SomeAngry);
	}
	
	public boolean isNeutral() {
		return (this == NeutralAngry || this == Neutral || this == NeutralCheerful);	
	}
	
	public boolean isCheerful() {
		return (this == SomeCheerful || this == Cheerful || this == VeryCheerful);	
	}
}
