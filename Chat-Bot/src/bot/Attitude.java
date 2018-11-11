package bot;

//TODO Не очень очевидно, как у вас Mood и Attitude сопоставляются
//TODO Насколько я понимаю, у вас три степени доброты, три степени нейтральности и три степени злости.
//TODO Предлагаю вам завести для этого enum(или использовать Mood), добавить в него методов по увеличению или уменьшению настроения(да, в Java такое делать можно!)
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