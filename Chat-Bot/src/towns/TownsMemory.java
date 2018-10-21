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
	static private HashSet<String> unusedTowns = new HashSet<String>();
	static private HashSet<String> usedTowns = new HashSet<String>();
	static private HashMap<String, List<String>> firstLetterLists = new HashMap<String, List<String>>();
	static private String pathOriginalInfo = "src/files/OriginalTowns.txt";

	static public boolean containsUnusedTowns(String str) {
		return unusedTowns.contains(str);
	}

	static public boolean containsUsedTowns(String str) {
		return usedTowns.contains(str);
	}

	static public void useTown(String s) {
		String firstLetter = getFirstLetter(s);
		firstLetterLists.get(firstLetter).remove(s);
		unusedTowns.remove(s);
		usedTowns.add(s);
	}

	static public String getUnusedTown(String lastTown) {
		String lastLetter = getLastLetter(lastTown).toUpperCase();
		List<String> currentList = firstLetterLists.get(lastLetter);
		if (currentList.size() == 0)
			return null;
		int random = (int) (Math.random() * currentList.size());
		String town = currentList.get(random);
		useTown(town);
		return town;
	}

	static private String getLastLetter(String s) {
		int i = 1;
		while (s.charAt(s.length() - i) == 'ь' || s.charAt(s.length() - i) == 'ы') {
			i++;
		}
		return s.substring(s.length() - i, s.length() - i + 1);
	}

	static private String getFirstLetter(String s) {
		return s.substring(0, 1);
	}

	static public void reboot() {
		unusedTowns.clear();
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
