package answers;

public class WhatDay extends BaseTopicTimeConversation  {
	private static final String[] triggers =
			{
					"(?iu:какой\\s.*день)",
					"(?iu:какое\\s.*число)"
			};

	public WhatDay() {
		super(triggers, "'Сегодня' EE dd.MM.yyyy");
	}
}
