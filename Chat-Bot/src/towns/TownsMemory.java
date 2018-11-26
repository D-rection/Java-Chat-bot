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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.google.common.collect.Sets;


public class TownsMemory {
	private HashSet<String> unusedTowns = new HashSet<String>();
	private HashSet<String> usedTowns = new HashSet<String>();
	private ArrayList<String> allCities = new ArrayList<String>();
	private HashMap<Character, HashSet<String>> firstLetterLists = new HashMap<Character, HashSet<String>>();
	private String pathOriginalInfo = "src/files/OriginalTowns.txt";
	private HashSet<Character> invalidCharacter = new HashSet<>(Arrays.asList('ъ','ь','ы'));
			

	public boolean containsUnusedTowns(String str) {
		return unusedTowns.contains(str);
	}

	public boolean containsUsedTowns(String str) {
		return usedTowns.contains(str);
	}

	public void useTown(String s) {
		Character firstLetter = getFirstLetter(s);
		if (firstLetter != null)
			Character.toUpperCase(firstLetter);
		firstLetterLists.get(firstLetter).remove(s);
		unusedTowns.remove(s);
		usedTowns.add(s);
	}

	
	public String getUnusedTownAndAddItToUsed(String lastTown) {
		Character lastLetter = getLastLetter(lastTown);
		if (lastLetter != null)
			lastLetter = Character.toUpperCase(lastLetter);
		else
			return null;
		HashSet<String> currentList = firstLetterLists.get(lastLetter);
		if (currentList == null || currentList.isEmpty())
			return null;
		String town = currentList.iterator().next();
		useTown(town);
		return town;
	}

	private Character getLastLetter(String s) {
		int i = 1;
		int length = s.length();
		boolean trueInput = i <= length;
		while (invalidCharacter.contains(s.charAt((length - i))) && trueInput) 
		{
			i++;
			if (i >= length)
				trueInput = false;
		}
		return trueInput ? s.charAt(length - i) : null;
	}

	private Character getFirstLetter(String s) 
	{
		return s.length() != 0 ? s.charAt(0) : null;
	}

	public void reboot() {
		unusedTowns.clear();
		if (allCities == null || allCities.isEmpty())
			superReboot();
		Character prevFirst = 'S';
		for(String city: allCities)
		{
			if (!getFirstLetter(city).equals(prevFirst)) 
			{
				firstLetterLists.put(getFirstLetter(city), new HashSet<String>());
				prevFirst = getFirstLetter(city);
			}
			firstLetterLists.get(getFirstLetter(city)).add(city);
			unusedTowns.add(city);
		}
		usedTowns.clear();
	}
	
	private void superReboot()
	{
		try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathOriginalInfo), StandardCharsets.UTF_8))) {			
			String line;
			while ((line = reader.readLine()) != null) 
			{
				allCities.add(line);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
