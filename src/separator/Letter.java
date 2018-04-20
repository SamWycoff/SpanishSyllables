package separator;

public class Letter {
	public static boolean isLetter(char c) {
		String letters = "�����AEIOU������aeiouBC�DFGHJKLMN�PQRSTVWXYZbc�dfghjklmn�pqrstvwxyz0123456789";
		return letters.contains(Character.toString(c));
	}
	
	public static boolean vowel(char c) {
		String vowel = "�����AEIOU������aeiou";
		return vowel.contains(Character.toString(c));
	}
	
	public static boolean strongVowel(char c) {
		String strong = "�����AEO�����aeo";
		return strong.contains(Character.toString(c));
	}
	
	public static boolean weakVowel(char c) {
		String weak = "IUiu�";
		return weak.contains(Character.toString(c));
	}
	
	public static boolean consonant(char c) {
		String consonant = "BC�DFGHJKLMN�PQRSTVWXYZbc�dfghjklmn�pqrstvwxyz";
		return consonant.contains(Character.toString(c));
	}
	
	public static boolean accent(char c) {
		String accents = "����������";
		return accents.contains(Character.toString(c));
	}
	
}
