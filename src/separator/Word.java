package separator;

import java.util.ArrayList;

public class Word {
	private String word;
	private ArrayList<Syllable> syllables = new ArrayList<>();
	private boolean accented;
	private String separated;
	
	public Word(String word) {
		this.word = word;
		this.accented = false;
		this.separated = "";
	}
	
	public String getWord() {
		return word;
	}
	
	public String getSeparated() {
		boolean reattach = false;
		if (word.charAt(word.length() - 1) == '/') {
			word = word.substring(0, word.length() - 1);
			reattach = true;
		}
		stressedSyllable();
		if (reattach) {
			separated = separated.substring(0, separated.length() - 1) + "/";
		}
		return separated;
	}

	private void stressedSyllable() {
		separate();
		for (Syllable s : syllables) {
			accentCheck(s);
		}
		if (!accented) {
			markAccent();
		}
		for (int i = 0; i < syllables.size(); i++) {
			String temp = syllables.get(i).getSyllable();
			separated = separated + temp + ".";
		}
	}
	
	private void separate() {
		int place = 0;
		for (int i = 0; i < word.length() - 1; i++) {
			if (shouldSeparate(i)) {
				syllables.add(new Syllable(word.substring(place, i + 1)));
				place = i + 1;
			}
		}
		if (place != word.length()) {
			syllables.add(new Syllable(word.substring(place)));
		}
	}
	
	private boolean shouldSeparate(int i) {
		if (Letter.vowel(word.charAt(i))) {
			return vowelSeparate(i);
		}
		else {
			return consonantSeparate(i);
		}
	}
	
	protected boolean vowelSeparate(int i) {
		if (i + 1 == word.length()) {
			return false;
		}
		else if (Letter.weakVowel(word.charAt(i + 1))) {
			return false;
		}
		else if (i + 2 != word.length() && Letter.consonant(word.charAt(i + 1)) 
				&& Letter.vowel(word.charAt(i + 2))) {
			return true;
		}
		else if (i + 2 != word.length() && Letter.consonant(word.charAt(i + 1)) 
				&& Letter.consonant(word.charAt(i + 2)) && word.charAt(i + 2) != 'r' 
				&& word.charAt(i + 2) != 'l') {
			return false;
		}
		else if (i + 2 != word.length() && Letter.consonant(word.charAt(i + 1)) 
				&& Letter.consonant(word.charAt(i + 2)) && (word.charAt(i + 2) == 'r' 
				|| word.charAt(i + 2) == 'l')) {
			return true;
		}
		else if (Letter.weakVowel(word.charAt(i)) && Letter.strongVowel(word.charAt(i + 1))) {
			return false;
		}
		else if (Letter.strongVowel(word.charAt(i)) && Letter.strongVowel(word.charAt(i + 1))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	protected boolean consonantSeparate(int i) {
		if (i + 1 == word.length()) {
			return false;
		}
		else if (word.charAt(i + 1) == 'r' || word.charAt(i + 1) == 'l') {
			return false;
		}
		else if (i >= 1 && Letter.consonant(word.charAt(i - 1)) && Letter.consonant(word.charAt(i + 1))) {
			return false;
		}
		else if (Letter.consonant(word.charAt(i + 1))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void accentCheck(Syllable s) {
		if (s.isAccented()) {
			s.setStressed();
			accented = true;
		}
	}
	
	private void markAccent() {
		if (syllables.size() == 1) {
			syllables.get(0).setStressed();
		}
		else if (word.charAt(word.length() - 1) == 'n' || word.charAt(word.length() - 1) == 's' 
				|| Letter.vowel(word.charAt(word.length() - 1))) {
			syllables.get(syllables.size() - 2).setStressed();
		}
		else {
			syllables.get(syllables.size() - 1).setStressed();
		}
	}
}
