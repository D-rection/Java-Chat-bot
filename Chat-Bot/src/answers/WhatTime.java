package answers;

public class WhatTime extends BaseTopicTimeConversation {
	private static final String[] triggers =
			{

					"(?iu:который\\s.*час)",
					"(?iu:сколько\\s.*время)"
			};

	public WhatTime() {
		super(triggers, "'Сейчас' kk:mm");
	}

}
