package numbers;

import java.util.regex.Pattern;

public class MakeNumber {
	public String getAnswer(String mess) {
		Pattern pattern1 = Pattern.compile("����������");
		Pattern pattern2 = Pattern.compile("������");
		Pattern pattern3 = Pattern.compile("������");
		Pattern pattern4 = Pattern.compile("������");

		if (pattern1.matcher(mess).find()) {
			UnknowNumber.setMinNumber(0);
			UnknowNumber.setMaxNumber(100);
			return "����.������� ����� �� 0 �� 100:) ��� ������ ��� ��������))) ������ ����� ��� ���������(������/������):D ����� ������ ������:'������'))) �� �����?";
		} else if (pattern2.matcher(mess).find()) {
			return "�����!!!���� ������� � ����� ��������)))";
		} else {
			if (pattern3.matcher(mess).find()) {
				UnknowNumber.setMaxNumber(UnknowNumber.getBotNumber());
			} else if (pattern4.matcher(mess).find()) {
				UnknowNumber.setMinNumber(UnknowNumber.getBotNumber());
			}
			UnknowNumber.setBotNumber(
					UnknowNumber.getMinNumber() + (UnknowNumber.getMaxNumber() - UnknowNumber.getMinNumber()) / 2);
			return UnknowNumber.getBotNumber() + "?";
		}
	}

}
