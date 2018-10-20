package numbers;

import bot.TopicConversation;
import java.util.regex.Pattern;
import bot.AnswerData;
import bot.InputData;

public class PlayNumbers implements TopicConversation {

	public AnswerData getAnswerData(InputData input) {
		Pattern pattern1 = Pattern.compile("�������|��������");
		Pattern pattern2 = Pattern.compile("����������");
		Pattern pattern3 = Pattern.compile("\\d+");
		Pattern pattern4 = Pattern.compile("����������");
		Pattern pattern5 = Pattern.compile("�����|��");
		Pattern pattern6 = Pattern.compile("������|������");
		String mess = input.textMessage;
		if (pattern1.matcher(mess).find()) {
			return new AnswerData("������ ����� �������. �� ������ ���������� ��� ����������?", true);
		} else if (pattern2.matcher(mess).find() || pattern3.matcher(mess).find()) {
			if (pattern2.matcher(mess).find()) {
				UnknowNumber.setBotNumber((int) Math.floor(Math.random() * 100));
			}
			String answer = new GuessNumber().getAnswer(mess);
			if (answer == "�� ������!") {
				return new AnswerData(answer, false);
			} else {
				return new AnswerData(answer, true);
			}
		} else if (pattern4.matcher(mess).find() || pattern5.matcher(mess).find() || pattern6.matcher(mess).find()) {
			String answer = new MakeNumber().getAnswer(mess);
			if (mess == "������") {
				return new AnswerData(answer, false);
			} else {
				return new AnswerData(answer, true);
			}
		} else {
			return new AnswerData("��� �� ������ �����!!!�� ��������(", false);
		}
	}
}
