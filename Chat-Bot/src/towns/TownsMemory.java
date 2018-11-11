package towns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class TownsMemory {
	private HashSet<String> unusedTowns = new HashSet<String>();
	private HashSet<String> usedTowns = new HashSet<String>();
	private HashMap<String, List<String>> firstLetterLists = new HashMap<String, List<String>>();
	private String pathOriginalInfo = "src/files/OriginalTowns.txt";

	public boolean containsUnusedTowns(String str) {
		return unusedTowns.contains(str);
	}

	public boolean containsUsedTowns(String str) {
		return usedTowns.contains(str);
	}

	public void useTown(String s) {
		String firstLetter = getFirstLetter(s);
		//TODO Удаление из List<String> работает за O(N), не очень понятно, почему вы не использовали HashSet
		firstLetterLists.get(firstLetter).remove(s);
		unusedTowns.remove(s);
		usedTowns.add(s);
	}

	//TODO Не очень понятно из названия метода, что после город в итоге станет использованным
	public String getUnusedTown(String lastTown) {
		String lastLetter = getLastLetter(lastTown).toUpperCase();
		//TODO Наверное, get может вернуть так же и null, если в файле не оказалось города начиная с переданной буквы
		List<String> currentList = firstLetterLists.get(lastLetter);
		if (currentList.size() == 0)
			return null;
		int random = (int) (Math.random() * currentList.size());
		String town = currentList.get(random);
		useTown(town);
		return town;
	}

	//TODO Нужно возвращать char
	//TODO Что если пришла пустая строка или состоящая из мягко-твердных знаков?
	private String getLastLetter(String s) {
		int i = 1;
		//TODO Я бы завел HashSet<Character> букв исключений
		while (s.charAt(s.length() - i) == 'ь' || s.charAt(s.length() - i) == 'ы') {
			i++;
		}
		return s.substring(s.length() - i, s.length() - i + 1);
	}

	//TODO Нужно возвращать char
	//TODO Что если пустая строка пришла на вход?
	private String getFirstLetter(String s) {
		return s.substring(0, 1);
	}

	public void reboot() {
		unusedTowns.clear();
		//TODO Не очень понятно, зачем читать из файла каждый раз
		String prevFirst = null;
		try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathOriginalInfo), StandardCharsets.UTF_8))) {			
			String line;
			while ((line = reader.readLine()) != null) {
				String firstLetter = getFirstLetter(line);
				if (!firstLetter.equals(prevFirst)) {
					firstLetterLists.put(firstLetter, new ArrayList<String>());
					prevFirst = firstLetter;
				}
				firstLetterLists.get(firstLetter).add(line);
				unusedTowns.add(line);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		usedTowns.clear();
	}

}
