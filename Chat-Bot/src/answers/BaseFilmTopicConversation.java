package answers;

import bot.AnswerData;
import bot.InputData;
import bot.TopicConversation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BaseFilmTopicConversation extends PatternBasedConversation
{
	private final static String[] angryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
			"Давай как-нибудь сам" };

	private final static String[] neutralAnswers = { "Пожалуй посмотри ", "Можешь посмотреть ", "Советую посмотреть ",
			"Я бы рекомендовал посмотреть ", "Кинопоиск подсказывает мне: " };

	private final static String[] cheerfulAnswers = { "Я бы на твоём месте не тратил на это свою жизнь, но ты можешь посмотреть ",
			"Мне очень нравится ", "Несколько раз пересматривал ", "Люблю всем советовать: ",
			"Никогда не смотрю фильмы.Шутка:D Глянь " };

	private final String[] films;

	protected BaseFilmTopicConversation(String[] patterns, String[] films) {
		super(patterns);
		this.films = films;
	}

	@Override
	public AnswerData getAnswerData(InputData input) {
		if(input.currentAttitude.isAngry()){
			return new AnswerData(RandomHelpers.pickRandom(angryAnswers), false);
		}

		String[] answers = input.currentAttitude.isCheerful() ? cheerfulAnswers : neutralAnswers;
		return new AnswerData(
				String.format("%s\"%s\".", RandomHelpers.pickRandom(answers), RandomHelpers.pickRandom(films)),
				false
		);
	}
}
