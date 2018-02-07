package separator;

import java.util.ArrayList;

public class Word {
	private String word;
	private ArrayList<Syllable> syllables = new ArrayList<>();
	
	public Word(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}
	
	public void separate() {
		int place = 0;
		for (int i = 0; i < word.length() - 1; i++) {
			if (shouldSeparate(i)) {
				syllables.add(new Syllable(word.substring(place, i + 1)));
				place = i + 1;
			}
		}
	}
	
/*	public String stressedSyllable() {
		if (accented) {
			int i = 0;
			while (!accent(word.charAt(i))) {
				i++;
			}
			if (i == 0) {
				separated = "'" + separated;
			}
			else if (consonant(word.charAt(i - 1))) {
				separated = separated.substring(0, i) + "'" + separated.substring(i);
			}
			else {
				separated = separated.substring(0, i + 1) + "'" + separated.substring(i + 1);
			}
		}
		else {
			if (word.length() <= 2) {
				separated = "'" + separated;
			}
			else if (consonant(word.charAt(word.length() - 1)) && word.charAt(word.length() - 1) != 'n' 
				&& word.charAt(word.length() - 1) != 's') {
				int i = separated.length() - 2;
				while (separated.charAt(i) != '.' && i > 0) {
					i--;
				}
				separated = separated.substring(0, i + 1) + "'" + separated.substring(i + 1);
			}
			else {
				int i = separated.length() - 1;
				int periods = 0;
				while (periods < 2 && i > 0) {
					i--;
					if (separated.charAt(i) == '.') {
						periods++;
					}
				}
				separated = separated.substring(0, i) + "'" + separated.substring(i);
			}
		}
		return separated;
	} */
	
	public boolean vowel(char c) {
		String vowel = "ÁÉÍÓÚAEIOUáéíóúaeiou";
		return vowel.contains(Character.toString(c));
	}
	
	public boolean strongVowel(char c) {
		String strong = "ÁÉÍÓÚAEOáéíóúaeo";
		return strong.contains(Character.toString(c));
	}
	
	public boolean weakVowel(char c) {
		String weak = "IUiu";
		return weak.contains(Character.toString(c));
	}
	
	public boolean consonant(char c) {
		String consonant = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
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
		if ((i + 2 != word.length()) && vowel(word.charAt(i)) && consonant(word.charAt(i + 1)) 
				&& vowel(word.charAt(i + 2))) {
			return true;
		}
		else if (i >= 1 && consonant(word.charAt(i - 1)) && consonant(word.charAt(i + 1))) {
			return true;
		}
		else if (strongVowel(word.charAt(i)) && strongVowel(word.charAt(i + 1))) {
			return true;
		}
		else if ((i + 2 != word.length()) && vowel(word.charAt(i)) && consonant(word.charAt(i + 1)) 
				&& consonant(word.charAt(i + 2)) && (word.charAt(i + 2) == 'r' 
				|| word.charAt(i + 2) == 'l')) {
			return false;
		}
		else {
			return false;
		}
	}
}
