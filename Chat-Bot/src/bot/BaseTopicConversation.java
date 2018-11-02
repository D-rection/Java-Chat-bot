package bot;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseTopicConversation implements TopicConversation {
	public AnswerData getAnswerData(InputData input, String[] angryAnswers, String[] neutralAnswers,
			String[] cheerfulAnswers) {
		if (input.currentAttitude.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return new AnswerData(angryAnswers[random], false);
		} else if (input.currentAttitude.getFriendliness() == Mood.Neutral) {
			int random = 0 + (int) (Math.random() * neutralAnswers.length);
			return new AnswerData(neutralAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * cheerfulAnswers.length);
			return new AnswerData(cheerfulAnswers[random], false);
		}
	}

	public AnswerData getAnswerDataWithDate(InputData input, String information) {
		String[] angryAnswers = { "У тебя что телефона нет?", "В углу экрана посмотри" };
		Date date = new Date();
		if (input.currentAttitude.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return new AnswerData(angryAnswers[random], false);
		} else {
			return new AnswerData(new SimpleDateFormat(information).format(date), false);
		}
	}

	public AnswerData getAnswerDataWithFilm(InputData input, String[] films) {
		String[] angryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
				"Давай как-нибудь сам" };
		String[] neutralAnswers = { "Пожалуй посмотри ", "Можешь посмотреть ", "Советую посмотреть ",
				"Я бы рекомендовал посмотреть ", "Кинопоиск подсказывает мне: " };
		String[] cheerfulAnswers = { "Я бы на твоём месте не тратил на это свою жизнь, но ты можешь посмотреть ",
				"Мне очень нравится ", "Несколько раз пересматривал ", "Люблю всем советовать: ",
				"Никогда не смотрю фильмы.Шутка:D Глянь " };

		int random = 0 + (int) (Math.random() * films.length);
		String film = films[random];
		AnswerData answer = getAnswerData(input, angryAnswers, neutralAnswers, cheerfulAnswers);

		if (input.currentAttitude.getFriendliness() == Mood.Angry) {
			return answer;
		} else {
			return new AnswerData(String.format("%s\"%s\".", answer.getAnswer(), film), answer.saveTheme());
		}
	}
}
