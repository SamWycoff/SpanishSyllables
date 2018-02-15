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
		stressedSyllable();
		return separated;
	}
	
	public void separate() {
		int place = 0;
		if (word.charAt(word.length() - 1) == '/') {
			for (int i = 0; i < word.length() - 1; i++) {
				if (shouldSeparate(word.substring(0, word.length() - 1), i)) {
					syllables.add(new Syllable(word.substring(place, i + 1)));
					place = i + 1;
				}
			}
		}
		else {
			for (int i = 0; i < word.length() - 1; i++) {
				if (shouldSeparate(i)) {
					syllables.add(new Syllable(word.substring(place, i + 1)));
					place = i + 1;
				}
			}
		}
		if (place != word.length()) {
			syllables.add(new Syllable(word.substring(place)));
		}
	}
	
	public void stressedSyllable() {
		separate();
		for (int i = 0; i < syllables.size(); i++) {
			accentCheck(i);
		}
		if (!accented) {
			markNotAccented();
		}
		for (int i = 0; i < syllables.size(); i++) {
			String temp = syllables.get(i).getSyllable();
			if (temp.charAt(temp.length() - 1) 
					!= '/'){
				separated = separated + temp + ".";
			}
			else {
				separated = separated + temp;
			}
		}
	}
	
	public boolean vowel(char c) {
		String vowel = "ÁÉÍÓÚAEIOUáéíóúüaeiou";
		return vowel.contains(Character.toString(c));
	}
	
	public boolean strongVowel(char c) {
		String strong = "ÁÉÍÓÚAEOáéíóúaeo";
		return strong.contains(Character.toString(c));
	}
	
	public boolean weakVowel(char c) {
		String weak = "IUiuü";
		return weak.contains(Character.toString(c));
	}
	
	public boolean consonant(char c) {
		String consonant = "BCÇDFGHJKLMNÑPQRSTVWXYZbcçdfghjklmnñpqrstvwxyz";
		return consonant.contains(Character.toString(c));
	}
	
	public boolean accent(char c) {
		String accents = "ÁÉÍÓÚáéíóú";
		return accents.contains(Character.toString(c));
	}
	
	public boolean isAccented(Syllable s) {
		for (int i = 0; i < s.getSyllable().length(); i++) {
			if (accent(s.getSyllable().charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean shouldSeparate(int i) {
		if (vowel(word.charAt(i))) {
			return vowelSeparate(i);
		}
		else {
			return consonantSeparate(i);
		}
	}
	
	public boolean shouldSeparate(String s, int i) {
		if (vowel(s.charAt(i))) {
			return vowelSeparate(s, i);
		}
		else {
			return consonantSeparate(s, i);
		}
	}
	
	public boolean consonantSeparate(int i) {
		if (i + 1 == word.length() - 1) {
			return false;
		}
		else if (word.charAt(i + 1) == 'r' || word.charAt(i + 1) == 'l') {
			return false;
		}
		else if (i >= 1 && consonant(word.charAt(i - 1)) && consonant(word.charAt(i + 1))) {
			return false;
		}
		else if (consonant(word.charAt(i + 1))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean consonantSeparate(String s, int i) {
		if (i + 1 == s.length()) {
			return false;
		}
		else if (s.charAt(i + 1) == 'r' || s.charAt(i + 1) == 'l') {
			return false;
		}
		else if (i >= 1 && consonant(s.charAt(i - 1)) && consonant(s.charAt(i + 1))) {
			return false;
		}
		else if (consonant(s.charAt(i + 1))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean vowelSeparate(int i) {
		if (i + 1 == word.length()) {
			return false;
		}
		else if (weakVowel(word.charAt(i + 1))) {
			return false;
		}
		else if (i + 2 != word.length() && consonant(word.charAt(i + 1)) 
				&& vowel(word.charAt(i + 2))) {
			return true;
		}
		else if (i + 2 != word.length() && consonant(word.charAt(i + 1)) 
				&& consonant(word.charAt(i + 2)) && word.charAt(i + 2) != 'r' 
				&& word.charAt(i + 2) != 'l') {
			return false;
		}
		else if (i + 2 != word.length() && consonant(word.charAt(i + 1)) 
				&& consonant(word.charAt(i + 2)) && (word.charAt(i + 2) == 'r' 
				|| word.charAt(i + 2) == 'l')) {
			return true;
		}
		else if (weakVowel(word.charAt(i)) && strongVowel(word.charAt(i + 1))) {
			return false;
		}
		else if (strongVowel(word.charAt(i)) && strongVowel(word.charAt(i + 1))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean vowelSeparate(String s, int i) {
		if (i + 1 == s.length()) {
			return false;
		}
		else if (weakVowel(s.charAt(i + 1))) {
			return false;
		}
		else if (i + 2 != s.length() && consonant(s.charAt(i + 1)) 
				&& vowel(s.charAt(i + 2))) {
			return true;
		}
		else if (i + 2 != s.length() && consonant(s.charAt(i + 1)) 
				&& consonant(s.charAt(i + 2)) && s.charAt(i + 2) != 'r' 
				&& s.charAt(i + 2) != 'l') {
			return false;
		}
		else if (i + 2 != s.length() && consonant(s.charAt(i + 1)) 
				&& consonant(s.charAt(i + 2)) && (s.charAt(i + 2) == 'r' 
				|| s.charAt(i + 2) == 'l')) {
			return true;
		}
		else if (weakVowel(s.charAt(i)) && strongVowel(s.charAt(i + 1))) {
			return false;
		}
		else if (strongVowel(s.charAt(i)) && strongVowel(s.charAt(i + 1))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void accentCheck(int i) {
		if (isAccented(syllables.get(i))) {
			syllables.get(i).setStressed();
			accented = true;
		}
	}
	
	public void markNotAccented() {
		if (word.charAt(word.length() - 1) == '/') {
			word = word.substring(0, word.length() - 1);
		}
		if (syllables.size() == 1) {
			syllables.get(0).setStressed();
		}
		else if (word.charAt(word.length() - 1) == 'n' || word.charAt(word.length() - 1) == 's' 
				|| vowel(word.charAt(word.length() - 1))) {
			syllables.get(syllables.size() - 2).setStressed();
		}
		else {
			syllables.get(syllables.size() - 1).setStressed();
		}
	}
}
