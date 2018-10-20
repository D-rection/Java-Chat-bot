package bot;

import java.util.HashMap;
import java.util.Map;
import answers.*;
import numbers.*;
import towns.TownsGame;

public class Memory {
	final String[] COMMON_PHRASES = { "��� ������ ������ ����, ��������� � ����� � �� �������.",
			"����� �������� ����� ������� ������, ������ ���� ����.",
			"����� ��� ��� ������/�������� ������ ����� ��������.", "�������� � ��������� ���� ������� � ������� ����.",
			"������� ����� ����� ��� ��������������� ������.", "����������� ���� ������� ���������������� ���.",
			"����� ����� ������, �� ����� � ��������.", "��������� �����, �� ��������� �� ����.",
			"��� ���� ������, ��� ���� ��������.", "����� �� ���-�� �� �������������." };
	final String[] ELUSIVE_ANSWERS = { "������ ���������, ����� ����-��� �� ��������.",
			"�� ������, ��� ���������� ����� �����������.", "����� ����� ��������� � ���-�� ������?",
			"��������, �� ��� ����� ������ ������.", "�� ������, ��� ��� ���������� �����.",
			"��������, � ��� ����� �� ��� �����.", "�� ������������� ������ ��� �����?",
			"������, �� ��� ���������� ����.", "����� ��� ����� ����������?", "������� �������� �������?" };
	Map<String, TopicConversation> patternsForAnalysis = new HashMap<String, TopicConversation>() {
		{
			// hello
			put("���", new Hello());
			put("������", new Hello());
			put("�������", new Hello());
			put("����������", new Hello());
			put("��������", new Hello());
			// whatcan
			put("���\\s.*������",  new WhatCan());
			put("���\\s.*������",  new WhatCan());
			// howareyou
			put("���\\s.*����", new HowAreYou());
			put("���\\s.*�����", new HowAreYou());
			// whatareyoudoing
			put("�����\\s.*���", new WhatAreYouDoing());
			put("�����\\s.*�����", new WhatAreYouDoing());
			put("���\\s.*�������", new WhatAreYouDoing());
			put("���\\s.*�����������", new WhatAreYouDoing());
			put("���\\s.*�������", new WhatAreYouDoing());
			put("���\\s.*�����", new WhatAreYouDoing());
			// whatday
			put("�����\\s.*����",  new WhatDay());
			put("�����\\s.*�����",  new WhatDay());
			put("�����\\\\s.*����",  new WhatDay());
			put("�����\\\\s.*�����",  new WhatDay());
			// whattime
			put("�������\\s.*���", new WhatTime());
			put("�������\\s.*�����", new WhatTime());
			// bye
			put("������", new Bye());
			put("����", new Bye());
			put("������", new Bye());
			put("��������", new Bye());
			put("��\\s.*��������", new Bye());
			// whatwatch
			put("���\\s.*����������", new WhatWatch());
			put("���\\s.�������", new WhatWatch());
			// cartoon
			put("����������", new Cartoon());
			put("�������", new Cartoon());
			put("�����\\s.*����������", new Cartoon());
			put("��������\\s.*����������", new Cartoon());
			put("���������\\s.*����������", new Cartoon());
			// film
			put("�����", new Film());
			put("�������", new Film());
			put("�����\\s.*�����", new Film());
			put("��������\\s.*�����", new Film());
			put("���������\\s.*�����", new Film());
			// series
			put("������", new Series());
			put("����������", new Series());
			put("�����\\s.*������", new Series());
			put("��������\\s.*������", new Series());
			put("���������\\s.*������", new Series());
			// towns
			put("������", new TownsGame());
			// numbers
			put("��������\\s.*�����", new PlayNumbers());
			put("�������\\s.*�����", new PlayNumbers());
			put("����������",  new PlayNumbers());
			put("����������", new PlayNumbers());
		}
	};
}
