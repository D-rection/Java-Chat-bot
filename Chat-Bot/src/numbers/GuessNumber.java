package numbers;

import java.util.regex.Pattern;

public class GuessNumber {

	public String getAnswer(String mess) {

		Pattern pattern1 = Pattern.compile("����������");

		if (pattern1.matcher(mess).find()) {
			return "����.� ������� ����� �� 0 �� 100:) ���� ������ ��� ��������))) �� ����� � ���� ������ ���������:D ��� ������: ����� �����:)";
		} else {
			String number = mess.replaceAll("[^0-9]", "");
			int UserNumber = Integer.parseInt(number);
			if (UserNumber > UnknowNumber.getBotNumber()) {
				return "�� ����� ������.";
			} else if (UserNumber < UnknowNumber.getBotNumber()) {
				return "�� ����� ������.";
			} else {
				return "�� ������!";
			}
		}
	}
}
