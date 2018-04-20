package separator;

public class Letter {
	public static boolean isLetter(char c) {
		String letters = "ÁÉÍÓÚAEIOUáéíóúüaeiouBCÇDFGHJKLMNÑPQRSTVWXYZbcçdfghjklmnñpqrstvwxyz0123456789";
		return letters.contains(Character.toString(c));
	}
	
	public static boolean vowel(char c) {
		String vowel = "ÁÉÍÓÚAEIOUáéíóúüaeiou";
		return vowel.contains(Character.toString(c));
	}
	
	public static boolean strongVowel(char c) {
		String strong = "ÁÉÍÓÚAEOáéíóúaeo";
		return strong.contains(Character.toString(c));
	}
	
	public static boolean weakVowel(char c) {
		String weak = "IUiuü";
		return weak.contains(Character.toString(c));
	}
	
	public static boolean consonant(char c) {
		String consonant = "BCÇDFGHJKLMNÑPQRSTVWXYZbcçdfghjklmnñpqrstvwxyz";
		return consonant.contains(Character.toString(c));
	}
	
	public static boolean accent(char c) {
		String accents = "ÁÉÍÓÚáéíóú";
		return accents.contains(Character.toString(c));
	}
	
}
